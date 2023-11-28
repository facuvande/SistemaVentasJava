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
    
    private Date fecha_venta;
    private int monto;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="vendedor_id")
    private Usuario vendedor;
    
    @OneToMany(mappedBy="venta")
    private List<Producto> productos;

    public Venta() {
    }

    public Venta(int id, Date fecha_venta, int monto, boolean estado, Usuario vendedor, List<Producto> productos) {
        this.id = id;
        this.fecha_venta = fecha_venta;
        this.monto = monto;
        this.estado = estado;
        this.vendedor = vendedor;
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
