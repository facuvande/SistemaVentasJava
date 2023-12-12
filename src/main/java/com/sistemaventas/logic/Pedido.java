package com.sistemaventas.logic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_pedido;
    
    // Fecha pedido
    private Date date_sale;
    private double amount_total;
    private boolean state;

    @ManyToOne
    @JoinColumn(name="vendedor_id")
    private Usuario vendedor;
    
    @ManyToMany
    @JoinTable(
            name = "pedidoProducto",
            joinColumns = @JoinColumn(name="id_pedido"),
            inverseJoinColumns = @JoinColumn(name="id_producto")
    )
    private List<Producto> productos; 

    public Pedido() {
    }

    public Pedido(int id_pedido, Date date_sale, double amount_total, boolean state, Usuario vendedor, List<Producto> productos) {
        this.id_pedido = id_pedido;
        this.date_sale = date_sale;
        this.amount_total = amount_total;
        this.state = state;
        this.vendedor = vendedor;
        this.productos = productos;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getDate_sale() {
        return date_sale;
    }

    public void setDate_sale(Date date_sale) {
        this.date_sale = date_sale;
    }

    public double getAmount_total() {
        return amount_total;
    }

    public void setAmount_total(double amount_total) {
        this.amount_total = amount_total;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    

    
    
}
