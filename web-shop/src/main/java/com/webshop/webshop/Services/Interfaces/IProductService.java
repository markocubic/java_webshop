package com.webshop.webshop.Services.Interfaces;

import com.webshop.webshop.Models.Category;
import com.webshop.webshop.Models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAll();

    Optional<Product> getOneById(Integer Id);

    List<Product> findByCategory(Optional<Category> category);
}
