package controller;


import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public void showProduct(HttpServletRequest request, HttpServletResponse response)  {
        request.setAttribute("products", ProductService.products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ShowProduct.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/create")
    public String createForm(HttpServletRequest request, HttpServletResponse response) {
        return "/createProduct.jsp";
    }
    @PostMapping ("/create")
    public void createProduct (HttpServletRequest request, HttpServletResponse response){
        List<Product> list = ProductService.products;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        list.add(new Product(id,name,img));
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/edit")
    public String editForm(HttpServletRequest request){
        int index = Integer.parseInt(request.getParameter("index"));
        request.setAttribute("p", ProductService.products.get(index) );

        return "/editProduct.jsp";
    }
   @PostMapping("/edit")
    public String edit (HttpServletRequest request){
        int index = Integer.parseInt(request.getParameter("index"));
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        Product product = new Product(id,name,img);
        productService.edit(index,product);
        request.setAttribute("products" , ProductService.products);
   return "/ShowProduct.jsp";
    }
  @GetMapping("/delete")
    public String delete(HttpServletRequest request){
      int id = Integer.parseInt(request.getParameter("index"));
        productService.delete(id);
      return "/product";
  }


}
