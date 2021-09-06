package com.webshop.webshop.Controllers;

import com.webshop.webshop.Global.GlobalData;
import com.webshop.webshop.Models.Product;
import com.webshop.webshop.Services.Interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CartController {
    @Autowired
    private IProductService productService;

    @RequestMapping(value="/addToCart", method = {RequestMethod.GET})
    public String addToCart(HttpServletRequest request, Integer id) {
        GlobalData.cart.add(productService.getOneById(id).get());
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @GetMapping("/cart")
    public String getCart(Model model) {
        System.out.println("Cart: " + GlobalData.cart);
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }

    @RequestMapping(value="/cart/removeItem", method = {RequestMethod.GET})
    public String cartItemRemove(int index) {
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }
}
