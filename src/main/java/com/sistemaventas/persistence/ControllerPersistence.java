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
    
    public void deleteUserById(int id){
        try {
            usuJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Rols
    public List<Rol> getRoles() {
        return rolJpa.findRolEntities();
    }

}
