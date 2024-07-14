package com.staffs.myacademy.contollers;

import com.staffs.myacademy.models.Orders;
import com.staffs.myacademy.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    public void createOrder(@RequestBody boolean order){
//        orderService.processOrder(order);
    }

    @GetMapping("/orders/{id}")
    public List<Orders> getOrdersForCustomer(@PathVariable int id){
        return orderService.getAllOrdersForCustomer(id);
    }


}
