package controller;


import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    ProductService productService = new ProductService();


    @GetMapping("/product")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("products", ProductService.products);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("createProduct");
        return modelAndView;
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        productService.create(product);
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public ModelAndView editForm( @RequestParam int index) {
        ModelAndView modelAndView = new ModelAndView("editProduct");
        modelAndView.addObject("product",ProductService.products.get(index));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@RequestParam int index, @ModelAttribute Product product){
        productService.edit(index, product);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int index) {
        productService.delete(index);
        return "redirect:/product";
    }


}
