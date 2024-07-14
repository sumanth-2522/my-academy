package com.staffs.myacademy.contollers;

import com.staffs.myacademy.models.Cart;
import com.staffs.myacademy.models.Product;
import com.staffs.myacademy.services.CartService;
import com.staffs.myacademy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        List<Product>  products = productService.getProducts();
        return products;
    }

    @PostMapping("/product")
    public Product AddProduct(@RequestBody Product product){
        return productService.addProduct(product);

    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id){
       return productService.getProductById(id);
    }

    @PutMapping("/product")
    public Product update(@RequestBody Product product){
        return productService.updateProduct(product);
    }

}
