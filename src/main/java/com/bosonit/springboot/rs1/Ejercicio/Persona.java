package com.bosonit.springboot.rs1.Ejercicio;

import java.util.Optional;

public class Persona {
    String nombre;
    String poblacion;
    String edad;

    Persona(){
        nombre = null;
        poblacion = null;
        edad = null;
    }

    Persona(String _id, String _nombre, String _poblacion, String _edad){
        nombre = _nombre;
        poblacion = _poblacion;
        edad = _edad.matches("-?\\d+") ? _edad : null;
    }

    Persona(String linea){
        String[] tokens = linea.split(":");
        nombre = tokens[0];
        poblacion = tokens[1];
        edad =  (tokens.length < 3) ? null : tokens[2] ;
        edad = (edad != null ? edad.matches("-?\\d+") : false) ? edad : null;
    }

    public String getNombre(){ return nombre; }

    public Optional<String> getEdad(){ return Optional.ofNullable(edad); }

    public Optional<String> getPoblacion(){ return Optional.ofNullable(poblacion); }

    public void setEdad(String _edadStr) {
        edad = _edadStr.matches("-?\\d+") ? _edadStr : null;
    }

    public void setPoblacion(String pob){ poblacion = pob; }

    public void setNombre (String nom){ nombre = nom; }

    @Override
    public String toString() { return "Nombre: "+nombre+". Poblacion: "+poblacion+". Edad: "+edad+"\n"; }
}