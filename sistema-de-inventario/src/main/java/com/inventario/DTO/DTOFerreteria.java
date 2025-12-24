package com.inventario.DTO;

import jakarta.persistence.Column;

public class DTOFerreteria {

    @Column(name="nombre_producto")
    private String nombrep;
    @Column (name = "cantidad")
    private int cantidad;
    private float precio;
    private int codigo;
    private double total;


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

    public DTOFerreteria( String nombrep, int cantidad, float precio, int codigo,double total) {
        this.nombrep = nombrep;
        this.cantidad = cantidad;
        this.precio = precio;
        this.codigo=codigo;
        this.total=total;
    }
}
