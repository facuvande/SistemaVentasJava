package com.sistemaventas.logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_producto;
    
    private String name;
    private double price;
    private int stock;
    private String barcode;
    
    @ManyToMany(mappedBy="productos")
    private List<Pedido> pedidos;

    public Producto() {
    }

    public Producto(int id_producto, String name, double price, int stock, String barcode) {
        this.id_producto = id_producto;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.barcode = barcode;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    
    
    
    
}
