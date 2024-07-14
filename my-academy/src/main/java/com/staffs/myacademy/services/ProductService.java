package com.staffs.myacademy.services;

import com.staffs.myacademy.models.Product;

import java.util.List;

public interface ProductService {
   List<Product> getProducts();

   Product getProductById(int id);

   Product updateProduct(Product product);

   Product addProduct(Product product);
}
