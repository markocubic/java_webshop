package com.webshop.webshop.Services;

import com.webshop.webshop.Models.User;
import com.webshop.webshop.Repositories.UserRepository;
import com.webshop.webshop.Services.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public Optional<User> getOne(Integer Id) {
        return userRepository.findById(Id);
    }

    @Override
    public User getOneByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User addNew(User user) { return userRepository.save(user); }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Integer Id) {
        userRepository.deleteById(Id);
    }
}
