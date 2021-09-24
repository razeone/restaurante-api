package com.saboritech.restaurantapi.payload;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.saboritech.restaurantapi.models.Estado;

import lombok.Data;

@Data
public class OrdenResponse {
    private String nombreCliente;
    private String notasOrden;
    private List<String> platillos;
    private Date fechaHoraCreacion;
    private Estado estado;
    private Float totalOrden;
    private Float totalMasImpuesto;

    public List<String> getPlatillos() {
        return new ArrayList<>(platillos);
    }

    public void setPlatillos(List<String> tags) {
        this.platillos = Collections.unmodifiableList(platillos);
    }
}
