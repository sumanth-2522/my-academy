package com.staffs.myacademy.services;

import com.staffs.myacademy.models.Cart;
import com.staffs.myacademy.models.Customer;
import com.staffs.myacademy.models.Orders;
import com.staffs.myacademy.models.Product;
import com.staffs.myacademy.repository.CartRepository;
import com.staffs.myacademy.repository.CustomerRepository;
import com.staffs.myacademy.repository.OrderRepository;
import com.staffs.myacademy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public String OrderStatus(boolean ordered) {
        if(ordered == true){
            List<Cart> cartList = cartRepository.findAll();
            cartList.stream()
                    .filter(item -> item.isOrdered() == false)
                    .forEach(item -> item.setOrdered(true));

        }
        return "SUCCESS";
    }

    @Override
    public Orders processOrder(Orders order){
        List<Product> productList2 = new ArrayList<>();
        Orders currentOrder = null;
        if(order != null) {
            currentOrder = orderRepository.save(order);
            if (currentOrder != null) {
                if (!order.getProducts().isEmpty() && order.getProducts() != null) {
                    List<Product> productList = order.getProducts();
                    for (Product p : productList) {
                        p.setOrder(currentOrder);
                        productList2.add(p);
                    }
                    productList2.forEach(product -> productRepository.save(product));
                }
            }
        }
        return currentOrder;
    }

    @Override
    public List<Orders> getAllOrdersForCustomer(int custId) {
        Optional<Customer> customerOp = customerRepository.findById(custId);
        Customer customer = null;
        List<Orders> custOrderList = new ArrayList<>();
        if(customerOp.isPresent()){
            customer = customerOp.get();
        }
        List<Orders> allOrdersList = orderRepository.findAll();

        if(!allOrdersList.isEmpty() && allOrdersList != null){
            for(Orders order: allOrdersList){
                if(order.getCustomer().getCustomerId() == customer.getCustomerId()){
                    custOrderList.add(order);
                }

            }
        }
        return custOrderList;
    }
}
