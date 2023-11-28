package com.sistemaventas.logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private int id;
    private String nombre;
    private String apellido;
    private String username;
    private int dni;
    @ManyToOne
    @JoinColumn(name="fk_rol")
    private Rol rol;
    @OneToMany(mappedBy="vendedor")
    private List<Venta> listaVentas;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, int dni, Rol rol, List<Venta> listaVentas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.rol = rol;
        this.listaVentas = listaVentas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
    

    
    
    
    
}
