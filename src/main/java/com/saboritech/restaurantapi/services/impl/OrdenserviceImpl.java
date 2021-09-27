package com.saboritech.restaurantapi.services.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.saboritech.restaurantapi.models.Orden;
import com.saboritech.restaurantapi.models.Platillo;

import com.saboritech.restaurantapi.repositories.OrdenRepository;
import com.saboritech.restaurantapi.repositories.PlatilloRepository;

import com.saboritech.restaurantapi.services.OrdenService;

import com.saboritech.restaurantapi.payload.OrdenRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class OrdenserviceImpl implements OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private PlatilloRepository platilloRepository;

    @Override
    public ResponseEntity<Orden> crearOrden(OrdenRequest nuevaOrdenRequest) {
        List<Platillo> platillos = new ArrayList<>(nuevaOrdenRequest.getPlatillos().size());
        Float totalOrden = 0.0f;

        for(String nombre : nuevaOrdenRequest.getPlatillos()) {
            Platillo platillo = platilloRepository.findByNombre(nombre);
            platillos.add(platillo);
            totalOrden += platillo.getPrecio();
        }

        Orden orden = new Orden();
        orden.setNombreCliente(nuevaOrdenRequest.getNombreCliente());
        orden.setNotasDeOrden(nuevaOrdenRequest.getNotasDeOrden());
        orden.setFechaHoraCreacionToNow();
        orden.setEstado(nuevaOrdenRequest.getEstado().toUpperCase());
        orden.setPlatillos(platillos);
        orden.setTotalOrden(totalOrden);
        orden.setTotalMasImpuesto();
        Orden nuevaOrden = ordenRepository.save(orden);
        return new ResponseEntity<>(nuevaOrden, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Orden>> listaOrdenes() {
        try {
            List<Orden> ordenes = new ArrayList<Orden>();
            ordenRepository.findAll().forEach(ordenes::add);
            if(ordenes.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ordenes, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity<Orden> consultaOrden(long id) {
        Optional<Orden> orden = ordenRepository.findById(id);
        if(orden.isPresent()) {
			return new ResponseEntity<>(orden.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
    
    @Override
    public ResponseEntity<HttpStatus> eliminaOrden(long id) {
        try {
            ordenRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Orden> actualizaOrden(long id, OrdenRequest nuevaOrdenRequest) {
        Optional<Orden> orden = ordenRepository.findById(id);

        if(orden.isPresent()) {
            Orden _orden = orden.get();
            PlatillosTotal platillosTotal = new PlatillosTotal(nuevaOrdenRequest.getPlatillos());
            platillosTotal.setPlatillosTotal();

            _orden.setNombreCliente(nuevaOrdenRequest.getNombreCliente());
            _orden.setNotasDeOrden(nuevaOrdenRequest.getNotasDeOrden());
            _orden.setEstado(nuevaOrdenRequest.getEstado().toUpperCase());
            _orden.setPlatillos(platillosTotal.getPlatillos());
            _orden.setTotalOrden(platillosTotal.getTotalOrden());
            _orden.setTotalMasImpuesto();
            Orden ordenActualizada = ordenRepository.save(_orden);
            return new ResponseEntity<>(ordenActualizada, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    class PlatillosTotal {
        private List<Platillo> platillos;
        private List<String> platillosList;
        private Float totalOrden = 0.0f;
    
        public PlatillosTotal(List<String> platillosList) {
            setPlatillos(new ArrayList<>(platillosList.size()));
            setPlatillos_list(platillosList);
        }
    
        public void setPlatillosTotal() {
            for(String nombre : platillosList) {
                Platillo platillo = platilloRepository.findByNombre(nombre);
                platillos.add(platillo);
                totalOrden += platillo.getPrecio();
            }
        }
    
        public List<Platillo> getPlatillos() {
            return this.platillos;
        }
    
        public void setPlatillos(List<Platillo> platillos) {
            this.platillos = platillos;
        }
    
        public List<String> getPlatillosList() {
            return this.platillosList;
        }
    
        public void setPlatillos_list(List<String> platillos_list) {
            this.platillosList = platillos_list;
        }
    
        public Float getTotalOrden() {
            return this.totalOrden;
        }
    
        public void setTotalOrden(Float totalOrden) {
            this.totalOrden = totalOrden;
        }
    
    }
    
    
}
