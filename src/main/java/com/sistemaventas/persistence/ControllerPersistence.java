package com.sistemaventas.persistence;

import com.sistemaventas.logic.Pedido;
import com.sistemaventas.logic.Producto;
import com.sistemaventas.logic.Rol;
import com.sistemaventas.logic.Usuario;
import com.sistemaventas.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControllerPersistence {
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    PedidoJpaController ventaJpa = new PedidoJpaController();
    ProductoJpaController produJpa = new ProductoJpaController();
    
    // Users
    public List<Usuario> getUsers() {
        return usuJpa.findUsuarioEntities();
    }

    public void addUser(Usuario miUsuario) {
        try {
            usuJpa.create(miUsuario);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    // Products
    public void addProduct(Producto miProduct) {
        produJpa.create(miProduct);
    }

    public List<Producto> getProducts() {
        return produJpa.findProductoEntities();
    }
    
    public Producto getProductById(int id) {
        return produJpa.findProducto(id);
    }
    
    public void editProduct(Producto myProduct) {
        try {
            produJpa.edit(myProduct);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteProductById(int id) {
        try {
            produJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Pedidos
    public void savePedido(Pedido pedido) {
        ventaJpa.create(pedido);
    }






}
