/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.Reto1.controller;

import co.edu.usa.Reto1.model.User;
import co.edu.usa.Reto1.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 
 */
/**
 * inicia el servicio
 */
@RestController

/**
 * el mapping define el contexto
 */

@RequestMapping("/api/user")

/**
 * permite procesamiento de cualquier tipo de peticion
 */

@CrossOrigin("*")

/**
 * creamos la nuestra clase 
 */
public class UserController {
    /**
    * creamos el  Autowired para inyectar
    */
     @Autowired
     /**
    * creamos la nuestra metodo userService
    */
    private UserService userService;
    
    /**
    * creamos el GetMapping
    */
    @GetMapping("/all")

    /**
    * creamos la lista User
    */
    public List<User> getAll() {
        return userService.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    /**
    * creamos el metodo registrar
    */
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }
    
    @GetMapping("/{email}/{password}")
    /**
    * creamos el metodo autenticarUsuario
    */
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }
    
    @GetMapping("/{email}")
    /**
    * creamos el metodo existeEmail
    */
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }   
    
}
