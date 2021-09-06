package com.webshop.webshop;

import com.webshop.webshop.Global.GlobalData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({"/home","/"})
    public String test(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }
}
