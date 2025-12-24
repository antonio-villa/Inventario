package com.inventario.Entity;

public class CarritoCompra extends Materiales {
    //esta clase es lo que se va aguardar en el array de compra

    private float total;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public CarritoCompra(Long id, String nombrep, int cantidad, float precio, float total) {
        super(id, nombrep, cantidad, precio);
        this.total = total;
    }

    public CarritoCompra(float total) {
        super();
        this.total = total;
    }


    public CarritoCompra(){}

}
