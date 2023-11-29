package com.sistemaventas.logic;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VentaProducto implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    private Venta sales;
    
    @ManyToOne
    private Producto product;
    
    private int quantity;

    public VentaProducto() {
    }

    public VentaProducto(int id, Venta sales, Producto product, int quantity) {
        this.id = id;
        this.sales = sales;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venta getSales() {
        return sales;
    }

    public void setSales(Venta sales) {
        this.sales = sales;
    }

    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
}
