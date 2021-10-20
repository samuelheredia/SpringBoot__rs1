package com.bosonit.springboot.rs1.Ejercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class ControllerDelete {
    @Autowired
    @Qualifier("personars1")
    PersonaService personas;

    @DeleteMapping("/persona/{id}")
    public ResponseEntity<Persona> deletePersona(@PathVariable Integer id){
        return new ResponseEntity<>( personas.deletePersona(id).orElse(new Persona()), HttpStatus.OK);
    }
}