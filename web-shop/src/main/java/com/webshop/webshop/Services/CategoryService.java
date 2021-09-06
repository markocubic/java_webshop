package com.webshop.webshop.Services;

import com.webshop.webshop.Models.Category;
import com.webshop.webshop.Repositories.CategoryRepository;
import com.webshop.webshop.Services.Interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return (List<Category>)categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getOne(Integer Id) {
        return categoryRepository.findById(Id);
    }

}
