package com.staffs.myacademy.repository;

import com.staffs.myacademy.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
