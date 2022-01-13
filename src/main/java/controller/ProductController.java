package controller;


import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
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
        modelAndView.addObject("product" , new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute ("product") Product product, @RequestParam MultipartFile uppImg ) {
       String filename = uppImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(),new File("C:\\Users\\Admind\\Desktop\\demoFramWord\\src\\main\\webapp\\wepPro\\public\\img/" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        product.setImg("/i/img/" +filename);

        productService.create(product);
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public ModelAndView editForm( @RequestParam int index) {
        ModelAndView modelAndView = new ModelAndView("editProduct");
        modelAndView.addObject("product",ProductService.products.get(index));
        return modelAndView;
    }
    @PostMapping ("/edit")
    public String edit(@RequestParam int index, @ModelAttribute ("product") Product product , @RequestParam MultipartFile uppImg){
        String fileName = uppImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(),new File("C:\\Users\\Admind\\Desktop\\demoFramWord\\src\\main\\webapp\\wepPro\\public\\img/" + fileName));
            product.setImg("/i/img/" + fileName);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }

        productService.edit(index,product);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int index) {
        productService.delete(index);
        return "redirect:/product";
    }


}
