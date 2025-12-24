package com.inventario.DTO;

public class DTOCarrito {

    //esta clase es lo que einteractua con el usuario

    private String nombre;
    private int cantidad;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public DTOCarrito(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
}
