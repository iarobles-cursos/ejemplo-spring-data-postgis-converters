package com.ejemplo.miproyecto.entidades;

import java.time.OffsetDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import net.postgis.jdbc.PGgeography;

@Table("ejemplo")
public class Ejemplo {

    @Id
    private Integer id;
    private String info;
    private Float precio;

    @Column("fecha")
    private OffsetDateTime fecha;
    private PGgeography posicion;
    private PGgeography poligono;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public Float getPrecio() {
        return precio;
    }
    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    public OffsetDateTime getFecha() {
        return fecha;
    }
    public void setFecha(OffsetDateTime fecha) {
        this.fecha = fecha;
    }
    public PGgeography getPosicion() {
        return posicion;
    }
    public void setPosicion(PGgeography posicion) {
        this.posicion = posicion;
    }
    public PGgeography getPoligono() {
        return poligono;
    }
    public void setPoligono(PGgeography poligono) {
        this.poligono = poligono;
    }

    

    
}
