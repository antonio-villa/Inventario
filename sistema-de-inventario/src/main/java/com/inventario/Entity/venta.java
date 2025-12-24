package com.inventario.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="venta")
public class venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="venta")
    private String nombre;
    private float dinero;
    private int cantidad;
    private String fecha_venta;
}
