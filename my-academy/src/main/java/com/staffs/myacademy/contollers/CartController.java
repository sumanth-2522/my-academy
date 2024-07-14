package com.staffs.myacademy.contollers;

import com.staffs.myacademy.models.Cart;
import com.staffs.myacademy.models.OrderStatus;
import com.staffs.myacademy.models.Product;
import com.staffs.myacademy.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/cart/{id}")
    public List<Cart> getCartItems(@PathVariable int id){
        System.out.println(id);

        return cartService.getCartItems(id);
    }

    @PostMapping("/cart")
    public void saveCartItems(@RequestBody Product product) {
        cartService.saveCartItems(product);
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCartItem(@PathVariable int id){
        System.out.println(id + "This is id");

        cartService.deleteCartItem(id);
    }

    @PostMapping("/cart/delete")
    public void saveCartItems(@RequestBody OrderStatus idOrdered) {
        cartService.updateCartStatus(idOrdered);
    }



}
