package com.inventario.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "ferreteria")
@Data
public class Ferreteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="nombre_producto")
    private String nombrep;
    @Column (name = "cantidad")
    private int cantidad;
    private float precio;
    private int codigo;
    private double total;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Ferreteria(Long id, String nombrep, int cantidad, float precio, int codigo,double total) {
        this.id = id;
        this.nombrep = nombrep;
        this.cantidad = cantidad;
        this.precio = precio;
        this.codigo=codigo;
        this.total=total;
    }
    public Ferreteria(){}
}
