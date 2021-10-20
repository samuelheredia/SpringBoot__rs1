package com.bosonit.springboot.rs1.Ejercicio;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List<Persona> getList();

    // CRUD
    Persona createPersona(Persona nuevaPersona);
    Optional<Persona> readPersona(Integer id);
    Optional<Persona> readPersona(String nombre);
    boolean updatePersona(Integer id, String nombre, String poblacion, String edad);
    Optional<Persona> deletePersona(Integer id);

    String toString();
}