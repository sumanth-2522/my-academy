package com.staffs.myacademy.services;

import com.staffs.myacademy.models.Cart;
import com.staffs.myacademy.models.OrderStatus;
import com.staffs.myacademy.models.Product;
import com.staffs.myacademy.repository.CartRepository;
import com.staffs.myacademy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Cart> getCartItems(int id){
        boolean isOrdered = false;
        List<Product> productList = new ArrayList<>();
        List<Cart> cartList = cartRepository.findByCustomerId(id);
        if(!cartList.isEmpty() && cartList != null){

            Iterator<Cart> it = cartList.iterator();
            while(it.hasNext()){
                Cart c = it.next();
                if(c.isOrdered()){
                    it.remove();
                }
            }
            return cartList;
        }
        else {
            return new ArrayList<>();
        }
    }

    public void saveCartItems(Product product){
        boolean isPresent = false;
        if(product != null && !product.getProductName().isEmpty()){
            List<Cart> cartList = cartRepository.findAll();
               if(!cartList.isEmpty() && cartList != null) {
                   for (Cart cart : cartList) {
                       int qty = 1;
                       if (cart.getProduct().getProductId() == product.getProductId()) {
                           qty += cart.getProdQuantity();
                           cart.setProdQuantity(qty);
                           cart.setOrdered(false);
                           cartRepository.save(cart);
                           isPresent = true;
                           break;
                       }
                   }
               } else {
                   Cart c = new Cart();
                   c.setCustomerId(1);
                   c.setProduct(product);
                   c.setProdQuantity(1);
                   c.setOrdered(false);
                   isPresent = true;
                   cartRepository.save(c);
               }

               if(!isPresent){
                   Cart c = new Cart();
                   c.setCustomerId(1);
                   c.setProduct(product);
                   c.setProdQuantity(1);
                   c.setOrdered(false);
                   cartRepository.save(c);
               }

           }

        }

    @Override
    public void deleteCartItem(int id) {

        List<Cart> cartList = cartRepository.findAll();
        Iterator<Cart> it = cartList.iterator();
        while (it.hasNext()){
            Cart c = it.next();
            if(c.getProduct().getProductId() == id) {
                cartRepository.deleteById(c.getCartId());
            }
        }

    }

    @Override
    public void updateCartStatus(OrderStatus Ordered) {
        List<Cart> cartList = cartRepository.findAll();

        cartList.forEach(item -> {
            item.setOrdered(true);
            item.setProdQuantity(0);
        });

        cartRepository.saveAll(cartList);

    }
}
