package com.saboritech.restaurantapi.payload;

import lombok.Data;

import java.util.List;
import java.util.Collections;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class OrdenRequest {
    
    @NotBlank
    private String nombreCliente;

    private String notasDeOrden;

    @NotNull
    private List<String> platillos;

    private void setPlatillos(List<String> platillos) {
        this.platillos = Collections.unmodifiableList(platillos);
    }
}
