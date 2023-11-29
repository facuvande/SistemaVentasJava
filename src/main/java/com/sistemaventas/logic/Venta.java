package com.sistemaventas.logic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private Date date_sale;
    private int amount;
    private boolean state;

    @ManyToOne
    @JoinColumn(name="vendedor_id")
    private Usuario vendedor;
    
    @OneToMany()
    @JoinColumn(name="venta_id")
    private List<Producto> listProducts;

    public Venta() {
    }

    public Venta(int id, Date date_sale, int amount, boolean state, Usuario vendedor, List<Producto> listProducts) {
        this.id = id;
        this.date_sale = date_sale;
        this.amount = amount;
        this.state = state;
        this.vendedor = vendedor;
        this.listProducts = listProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_sale() {
        return date_sale;
    }

    public void setDate_sale(Date date_sale) {
        this.date_sale = date_sale;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isState() {
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

    public List<Producto> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Producto> listProducts) {
        this.listProducts = listProducts;
    }

    
}
