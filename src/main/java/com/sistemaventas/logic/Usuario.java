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
    private String name;
    private String surname;
    private String username;
    private String password;
    private int dni;
    @ManyToOne
    @JoinColumn(name="fk_rol")
    private Rol rol;
    
    @OneToMany(mappedBy="vendedor")
    private List<Venta> listSales;

    public Usuario() {
    }

    public Usuario(int id, String name, String surname, String username, String password, int dni, Rol rol, List<Venta> listSales) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.dni = dni;
        this.rol = rol;
        this.listSales = listSales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return listSales;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listSales = listaVentas;
    }

    
    
    
    
}
