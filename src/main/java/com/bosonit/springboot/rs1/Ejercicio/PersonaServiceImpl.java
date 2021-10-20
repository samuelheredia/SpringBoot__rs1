package com.bosonit.springboot.rs1.Ejercicio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("personars1")
public class PersonaServiceImpl implements PersonaService {
    List<Persona> personas = new ArrayList<>();

    @Override
    public List<Persona> getList() { return personas; }

    @Override
    public Persona createPersona(Persona nuevaPersona) {
        personas.add(nuevaPersona);
        return nuevaPersona;
    }

    @Override
    public Optional<Persona> readPersona(Integer id) {
        if(id < personas.size() && id >= 0)
            return Optional.ofNullable( personas.get(id) );
        else
            return Optional.of( new Persona() );
    }

    @Override
    public Optional<Persona> readPersona(String nombre) {
        if( nombre.matches("-?\\d+") ){
            Integer id = Integer.parseInt(nombre);
            return readPersona(id);
        }
        else {
            return personas.stream().
                    filter(p -> p.getNombre().equals(nombre))
                    .findFirst();
        }
    }

    @Override
    public boolean updatePersona(Integer id, String nombre, String poblacion, String edad) {
        if(id < personas.size() && id >= 0) {
            Persona persona = personas.get(id);
            persona.setNombre(nombre);
            persona.setPoblacion(poblacion);
            persona.setEdad(edad);
            return true;
        }
        else
            return false;
    }

    @Override
    public Optional<Persona> deletePersona(Integer id) {
        if(id < personas.size() && id >= 0){
            Persona p = personas.get(id);
            return Optional.ofNullable( personas.remove(id.intValue()) );
        }
        return Optional.of( new Persona() );
    }

    @Override
    public String toString() { return personas.toString(); }
}