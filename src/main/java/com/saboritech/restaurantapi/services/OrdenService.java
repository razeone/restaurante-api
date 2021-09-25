package com.saboritech.restaurantapi.services;

import com.saboritech.restaurantapi.models.Orden;

import com.saboritech.restaurantapi.payload.OrdenRequest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

public interface OrdenService {

    ResponseEntity<Orden> crearOrden(OrdenRequest nuevaOrdenRequest);
    ResponseEntity<List<Orden>> listaOrdenes();
    ResponseEntity<Orden> consultaOrden(long id);
    ResponseEntity<Orden> actualizaOrden(long id, OrdenRequest nuevaOrdenRequest);
    ResponseEntity<HttpStatus> eliminaOrden(long id);
    
}
