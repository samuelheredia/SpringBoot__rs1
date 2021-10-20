package com.bosonit.springboot.rs1.Ejercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class ControllerCreate {
    @Autowired
    @Qualifier("personars1")
    PersonaService personas;

    @PostMapping("/persona")
    public ResponseEntity<Persona> createPersona(@RequestBody Persona nuevaPersona){
        return new ResponseEntity<>( personas.createPersona(nuevaPersona), HttpStatus.OK);
    }
}