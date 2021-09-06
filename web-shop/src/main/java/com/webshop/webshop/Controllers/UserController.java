package com.webshop.webshop.Controllers;

import com.webshop.webshop.Global.GlobalData;
import com.webshop.webshop.Models.User;
import com.webshop.webshop.Services.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/users/signUp")
    public String signUp(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "signUp";
    }

    @RequestMapping("/users/signIn")
    public String signIn() {
        return "signIn";
    }

    @RequestMapping("/users/authenticateUser")
    public String authenticateUser(User user) {
        User checkedUser = getOneByName(user.getName());
        if(checkedUser == null) {
            System.out.println("Empty");
            return "signIn";
        }
        System.out.println("Not empty");
        return "redirect:/";
    }

    @RequestMapping("/users/getAll")
    public String getAll(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);

        String username = "Marko";
        model.addAttribute("username", username);

        return "users";
    }
    @RequestMapping("/users/getOne")
    @ResponseBody
    public Optional<User> getOne(Integer Id) {
        return userService.getOne(Id);
    }

    @ResponseBody
    public User getOneByName(String name) {
        return userService.getOneByName(name);
    }

    @PostMapping("/users/addNew")
    public String addNew(User user) {
        System.out.println("User: " + user);
        userService.addNew(user);
        return "redirect:/";
    }

    @RequestMapping(value="/users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(User user) {
        userService.update(user);
        return "redirect:/users/getAll";
    }

    @RequestMapping(value="/users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        userService.delete(Id);
        return "redirect:/users/getAll";
    }
}
