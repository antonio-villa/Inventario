package com.inventario.DTO;

import com.inventario.Entity.CarritoCompra;

import java.util.List;

public class DTORespuesta {

    private List<CarritoCompra> productos;
    private double total;

    //getters and setters
    public List<CarritoCompra> getProductos() {
        return productos;
    }

    public void setProductos(List<CarritoCompra> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public DTORespuesta(List<CarritoCompra> productos, double total) {
        this.productos = productos;
        this.total = total;
    }
}
