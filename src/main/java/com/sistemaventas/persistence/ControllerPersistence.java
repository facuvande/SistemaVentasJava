package com.sistemaventas.persistence;

import com.sistemaventas.logic.Rol;
import com.sistemaventas.logic.Usuario;
import com.sistemaventas.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControllerPersistence {
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    VentaJpaController ventaJpa = new VentaJpaController();
    ProductoJpaController produJpa = new ProductoJpaController();
    VentaProductoJpaController ventaProduJpa = new VentaProductoJpaController();
    
    // Users
    public List<Usuario> getUsers() {
        return usuJpa.findUsuarioEntities();
    }

    public void addUser(Usuario miUsuario) {
        usuJpa.create(miUsuario);
    }

    public void editUser(Usuario user) {
        try {
            usuJpa.edit(user);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteUserById(int id){
        try {
            usuJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Usuario getUserById(int id) {
        return usuJpa.findUsuario(id);
    }

    // Rols
    public List<Rol> getRoles() {
        return rolJpa.findRolEntities();
    }



}
