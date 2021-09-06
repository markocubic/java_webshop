package com.webshop.webshop.Services.Interfaces;
import com.webshop.webshop.Models.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> getAll();
    Optional<Category> getOne(Integer Id);
}
