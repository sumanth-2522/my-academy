package com.staffs.myacademy.repository;

import com.staffs.myacademy.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String email);
}
