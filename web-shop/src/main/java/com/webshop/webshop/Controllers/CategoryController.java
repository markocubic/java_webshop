package com.webshop.webshop.Controllers;

import com.webshop.webshop.Models.Category;
import com.webshop.webshop.Services.Interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/category", method = {RequestMethod.GET})
    public void getAll(Model model)
    {
        List<Category> categories = categoryService.getAll();
        System.out.println("Categories: " + categories);
    }
}
