package com.bosonit.springboot.rs1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    List<User> users = new ArrayList<>();

    @Override
    public List<User> getList() {
        return users;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("List de users:\n");
        for (User u : users)
            ret.append("ID: ").append(u.getId()).append(" Name: ").append(u.getName().orElse("not defined")).append("\n");
        return ret.toString();
    }

    @Override
    public Optional<User> getUser(String id) {
        Integer idInt = Integer.parseInt(id);
        return users.stream()
                .filter(u -> u.getId().equals(idInt))
                .findFirst();
    }
}
