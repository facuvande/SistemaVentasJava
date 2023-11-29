package com.sistemaventas.persistence;

import com.sistemaventas.logic.Usuario;
import java.util.List;


public class ControllerPersistence {
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    VentaJpaController ventaJpa = new VentaJpaController();
    ProductoJpaController produJpa = new ProductoJpaController();
    VentaProductoJpaController ventaProduJpa = new VentaProductoJpaController();
    
    public List<Usuario> getUsers() {
        return usuJpa.findUsuarioEntities();
    }
}
