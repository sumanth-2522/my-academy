package com.staffs.myacademy.services;

import com.staffs.myacademy.models.Orders;

import java.util.List;

public interface OrderService {

    String OrderStatus(boolean ordered);

    Orders processOrder(Orders order);

    List<Orders> getAllOrdersForCustomer(int id);
}
