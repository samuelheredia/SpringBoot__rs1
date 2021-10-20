package com.bosonit.springboot.rs1.Ejercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class ControllerRead {

    @Autowired
    @Qualifier("personars1")
    PersonaService personas;

    @GetMapping("/persona/{id}")
    public ResponseEntity<Persona> readPersona(@PathVariable String id){
        return new ResponseEntity<>( personas.readPersona(id).orElse(new Persona()), HttpStatus.OK);
    }
}