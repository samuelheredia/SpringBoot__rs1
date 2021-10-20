package com.bosonit.springboot.rs1;

import java.util.Optional;

public class User {
    private Integer id;
    private String name;

    User(){
        id = null;
        name = null;
    }

    User(String _id, String _name){
        setId(_id);
        setName(_name);
    }

    public Optional<String> getName() { return Optional.ofNullable(name); }

    public Integer getId() { return id; }

    //public void setId(Integer _id) { this.id = _id; }

    public void setName(String name) { this.name = name; }

    public void setId(String _id){
        try {
            this.id = Integer.parseInt(_id);
        }
        catch(Exception e){
            System.err.println("ID debe ser un número --> "+e);
        }
    }

    public String toString(){
        return "ID: "+this.getId()+" Name: "+this.getName().orElse("No definido")+"\n";
    }
}