package com.bosonit.springboot.rs1.Ejercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerUpdate {

    @Autowired
    @Qualifier("personars1")
    PersonaService personas;

    @PutMapping("/persona/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Integer id, @RequestBody Persona nuevaPersona){
        if( personas.updatePersona(id,
                nuevaPersona.getNombre(),
                nuevaPersona.getPoblacion().orElse(""),
                nuevaPersona.getEdad().orElse("")) )
            return new ResponseEntity<>( nuevaPersona, HttpStatus.OK);
        else
            return new ResponseEntity<>( new Persona(), HttpStatus.OK);
    }
}