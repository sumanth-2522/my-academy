package com.staffs.myacademy.services;

import com.staffs.myacademy.models.Product;
import com.staffs.myacademy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product>  op = productRepository.findById(id);
        if(op.isPresent()){
            return op.get();
        }

        return new Product();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }


}
