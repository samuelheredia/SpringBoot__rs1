package com.bosonit.springboot.rs1;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getList();
    public Optional<User> getUser(String id);

    public String toString();
}