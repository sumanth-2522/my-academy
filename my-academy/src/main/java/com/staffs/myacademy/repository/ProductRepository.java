package com.staffs.myacademy.repository;

import com.staffs.myacademy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
