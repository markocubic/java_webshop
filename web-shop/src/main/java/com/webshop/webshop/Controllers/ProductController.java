package com.webshop.webshop.Controllers;

import com.webshop.webshop.Global.GlobalData;
import com.webshop.webshop.Models.Category;
import com.webshop.webshop.Models.Product;
import com.webshop.webshop.Services.Interfaces.ICategoryService;
import com.webshop.webshop.Services.Interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value="", method = {RequestMethod.GET})
    public String getAll(
            Model model,
            Boolean priceSortBool,
            Boolean nameSortBool,
            Integer categoryId,
            Boolean test
    ) {
        List<Product> products;
        if(categoryId != null) {
            Optional<Category> category = categoryService.getOne(categoryId);
            products = productService.findByCategory(category);
        }
        else {
            products = productService.getAll();
        }

        List<Category> categories = categoryService.getAll();

        if (priceSortBool != null) {
            if (priceSortBool == true) {
                products.sort(Comparator.comparing(Product::getPrice));
            }
            else {
                products.sort(Comparator.comparing(Product::getPrice).reversed());
            }
            model.addAttribute("priceSort", priceSortBool);
        }

        if (nameSortBool != null) {
            if (nameSortBool == true) {
                products.sort(Comparator.comparing(Product::getName));
            }
            else {
                products.sort(Comparator.comparing(Product::getName).reversed());
            }
            model.addAttribute("priceSort", priceSortBool);
            model.addAttribute("nameSort", nameSortBool);
        }

        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("cartCount", GlobalData.cart.size());

        return "products";
    }
}
