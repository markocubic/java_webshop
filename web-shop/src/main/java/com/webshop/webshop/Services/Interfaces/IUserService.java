package com.webshop.webshop.Services.Interfaces;

import com.webshop.webshop.Models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();
    Optional<User> getOne(Integer Id);
    User getOneByName(String name);
    User addNew(User user);
    void update(User user);
    void delete(Integer Id);
}
