package com.saboritech.restaurantapi.models;

import java.util.Date;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;


@Entity
@Table(name="orden")
public class Orden {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String nombreCliente;
    private String notasDeOrden;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name="platillos_orden",
        joinColumns = @JoinColumn(name="orden_id", referencedColumnName="id"),
        inverseJoinColumns = @JoinColumn(name="platillo_id", referencedColumnName="id")
    )
    private List<Platillo> platillos;

    @Temporal(TemporalType.TIMESTAMP)
    Date fechaHoraCreacion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private Float totalOrden;
    private Float totalMasImpuesto;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNotasDeOrden() {
        return this.notasDeOrden;
    }

    public void setNotasDeOrden(String notasDeOrden) {
        this.notasDeOrden = notasDeOrden;
    }

    public List<Platillo> getPlatillos() {
        return new ArrayList<>(platillos);
    }

    public void setPlatillos(List<Platillo> platillos) {
        this.platillos = platillos;
    }

    public Date getFechaHoraCreacion() {
        return this.fechaHoraCreacion;
    }

    public void setFechaHoraCreacionToNow() {
        this.fechaHoraCreacion = new Timestamp(System.currentTimeMillis());
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Float getTotalOrden() {
        return this.totalOrden;
    }

    public void setTotalOrden(Float totalOrden) {
        this.totalOrden = totalOrden;
    }

    public Float getTotalMasImpuesto() {
        return this.totalMasImpuesto;
    }

    public void setTotalMasImpuesto(Float totalMasImpuesto) {
        this.totalMasImpuesto = totalMasImpuesto;
    }

}
