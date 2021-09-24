package com.saboritech.restaurantapi.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.saboritech.restaurantapi.models.Platillo;
import com.saboritech.restaurantapi.repositories.PlatilloRepository;

@RestController
@RequestMapping("/api")
public class PlatilloController {
    
    @Autowired
    private PlatilloRepository platilloRepository;

    @PostMapping("/platillo")
    public ResponseEntity<Platillo> crearPlatillo(@RequestBody Platillo platillo) {
        try {
            Platillo _platillo = platilloRepository.save(platillo);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/platillo")
    public ResponseEntity<List<Platillo>> listaPlatillos() {
        try {
            List<Platillo> platillos = new ArrayList<Platillo>();
            platilloRepository.findAll().forEach(platillos::add);
            if(platillos.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(platillos, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/platillo/{id}")
    public ResponseEntity<Platillo> consultaPlatillo(@PathVariable(value="id") long id) {
        Optional<Platillo> platilloData = platilloRepository.findById(id);
        if(platilloData.isPresent()) {
            return new ResponseEntity<>(platilloData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/platillo/{id}")
    public ResponseEntity<Platillo> actualizaPlatillo(@PathVariable("id") long id, @RequestBody Platillo platillo) {
        Optional<Platillo> platilloData = platilloRepository.findById(id);

        if(platilloData.isPresent()) {
            Platillo _platillo = platilloData.get();
            _platillo.setNombre(platillo.getNombre());
            _platillo.setDescripcion(platillo.getDescripcion());
            _platillo.setVegetariano(platillo.getVegetariano());
            _platillo.setDisponible(platillo.getDisponible());
            _platillo.setPrecio(platillo.getPrecio());
            return new ResponseEntity<>(platilloRepository.save(_platillo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/libro/{id}")
    public ResponseEntity<HttpStatus> eliminaLibro(@PathVariable(value="id") long id) {
        try {
            platilloRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
