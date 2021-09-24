package com.saboritech.restaurantapi.services.impl;

import java.util.List;
import java.util.ArrayList;

import com.saboritech.restaurantapi.models.Estado;
import com.saboritech.restaurantapi.models.Orden;
import com.saboritech.restaurantapi.models.Platillo;

import com.saboritech.restaurantapi.repositories.OrdenRepository;
import com.saboritech.restaurantapi.repositories.PlatilloRepository;

import com.saboritech.restaurantapi.services.OrdenService;

import com.saboritech.restaurantapi.payload.OrdenRequest;
import com.saboritech.restaurantapi.payload.OrdenResponse;

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

        for(String nombre : nuevaOrdenRequest.getPlatillos()) {
            Platillo platillo = platilloRepository.findByNombre(nombre);
            platillos.add(platillo);
        }

        Orden orden = new Orden();
        orden.setNombreCliente(nuevaOrdenRequest.getNombreCliente());
        orden.setNotasDeOrden(nuevaOrdenRequest.getNotasDeOrden());
        orden.setFechaHoraCreacionToNow();
        orden.setEstado(Estado.CREADA);
        orden.setPlatillos(platillos);
        
        Orden nuevaOrden = ordenRepository.save(orden);
        
        return new ResponseEntity<>(nuevaOrden, HttpStatus.OK);
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
        System.out.println("TODO");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<HttpStatus> eliminaOrden(long id) {
        System.out.println("TODO");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Orden> actualizaOrden(long id, Orden nuevaOrden) {
        System.out.println("TODO");
        return new ResponseEntity<>(null, HttpStatus.OK);        
    }
    
}
