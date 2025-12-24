package com.inventario.Entity;

import java.util.ArrayList;
import java.util.List;

public class LogicaCarrito {

    //esta clase es toda la logica que va a tener to carrito de compra

    private List<CarritoCompra>compra;

    public LogicaCarrito(){
        compra = new ArrayList<>();
    }

    public void agregarProducto(CarritoCompra compraPro){
        compra.add(compraPro);
    }

    public List<CarritoCompra> mostrarProductos(){return compra;}
    public double mosstrarCarrito(){
        return compra.stream().mapToDouble(CarritoCompra::getTotal).sum();
    }
    public void limpiarCarrito(CarritoCompra venta){compra.clear();}
}
