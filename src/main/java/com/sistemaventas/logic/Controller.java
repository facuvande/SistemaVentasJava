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

    public List<Rol> getRoles() {
        return controllerPersis.getRoles();
    }

    public void addUser(String name, String surname, String dni, String password, String username, String role) {
        Usuario user = new Usuario();
        user.setName(name);
        user.setSurname(surname);
        user.setDni(dni);
        user.setPassword(password);
        user.setUsername(username);
        
        List<Rol> roles = this.getRoles();
        
        for(Rol rol : roles){
            if(rol.getName().equalsIgnoreCase(role)){
                user.setRol(rol);
            }
        }
        
        int id = this.searchLastIdUser();
        user.setId(id + 1);
        
        controllerPersis.addUser(user);
        
       
    }

    private int searchLastIdUser() {
        List<Usuario> miUsers = this.getUsers();
        
        Usuario usu = miUsers.get(miUsers.size() - 1);
        return usu.getId();
        
    }
}
