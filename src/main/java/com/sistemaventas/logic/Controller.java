package com.sistemaventas.logic;

import com.sistemaventas.persistence.ControllerPersistence;
import java.util.List;


public class Controller {
    ControllerPersistence controllerPersis = new ControllerPersistence();

    // USUARIOS
    
    public Usuario Login(String username, String password) {
        Usuario user = null;
        List<Usuario> listUsers = controllerPersis.getUsers();
        
        for(Usuario usu : listUsers){
            if(usu.getUsername().equals(username) && usu.getPassword().equals(password)){
                user = usu;
                return user;
            }
        }
        return user;
    }

    public List<Usuario> getUsers() {
        return controllerPersis.getUsers();
    }
}
