package controller;


import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ProductController {

    ProductService productService = new ProductService();


    @GetMapping("/product")
    public void showProduct(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("products", ProductService.products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ShowProduct.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/create")
    public String createForm() {
        return "/createProduct.jsp";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        productService.create(product);
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String editForm(HttpServletRequest request, @RequestParam int index) {
        request.setAttribute("p", ProductService.products.get(index));
        return "/editProduct.jsp";
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
