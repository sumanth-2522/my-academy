package com.staffs.myacademy.services;

import com.staffs.myacademy.models.Cart;
import com.staffs.myacademy.models.OrderStatus;
import com.staffs.myacademy.models.Product;

import java.util.List;


public interface CartService {
    List<Cart> getCartItems(int id);
    void saveCartItems(Product product);
    void deleteCartItem(int id);
    void updateCartStatus(OrderStatus isOrdered);
}
