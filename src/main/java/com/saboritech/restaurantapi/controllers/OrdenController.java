package com.saboritech.restaurantapi.controllers;

import java.util.List;

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

import com.saboritech.restaurantapi.models.Orden;
import com.saboritech.restaurantapi.payload.OrdenRequest;
import com.saboritech.restaurantapi.services.OrdenService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class OrdenController {
    
    @Autowired
    private OrdenService ordenService;

    @PostMapping("/orden")
    public ResponseEntity<Orden> crearOrden(@Valid @RequestBody OrdenRequest nuevaOrdenRequest) {
        return ordenService.crearOrden(nuevaOrdenRequest);
    }

    @GetMapping("/orden")
    public ResponseEntity<List<Orden>> listaOrdenes() {
        return ordenService.listaOrdenes();
    }

    @GetMapping("/orden/{id}")
    public ResponseEntity<Orden> consultaOrden(@PathVariable(value="id") long id) {
        System.out.println("TODO");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/orden/{id}")
    public ResponseEntity<Orden> actualizaOrden(@PathVariable("id") long id, @RequestBody Orden orden) {
        System.out.println("TODO");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/orden/{id}")
    public ResponseEntity<HttpStatus> eliminaOrden(@PathVariable(value="id") long id) {
        System.out.println("TODO");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
