package com.bosonit.springboot.rs1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class rs1Controller {
    @Autowired
    UserService usuarios;

    @PostMapping("/rs1")
    public ResponseEntity<User> addUser(@RequestBody User nuevoUser) {
        if (usuarios.getUser(nuevoUser.getId().toString()).isPresent())
            return new ResponseEntity<>(new User(), HttpStatus.OK);
        else{
            usuarios.getList().add(nuevoUser);
            return new ResponseEntity<>(nuevoUser, HttpStatus.OK);
        }
    }

    @GetMapping("/rs1/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        return new ResponseEntity<>(usuarios.getUser(id).orElse(new User()),HttpStatus.OK);
    }

    @PutMapping("/rs1/put")
    public ResponseEntity<User> editUser(@RequestParam String id, @RequestParam String name){
        usuarios.getUser(id).ifPresentOrElse(
            (user) -> {
                user.setId(id);
                user.setName(name);
            },
            () -> { addUser(new User(id, name)); }
        );
        return new ResponseEntity<>( usuarios.getUser(id).get(), HttpStatus.OK);
    }
}
