package com.staffs.myacademy.repository;

import com.staffs.myacademy.models.Cart;
import com.staffs.myacademy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByCustomerId(int custId);
}
