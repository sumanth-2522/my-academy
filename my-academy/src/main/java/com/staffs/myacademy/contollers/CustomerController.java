package com.staffs.myacademy.contollers;

import com.staffs.myacademy.models.Customer;
import com.staffs.myacademy.models.Login;
import com.staffs.myacademy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer/")
    public Customer findByEmail(@RequestBody Login login){
        return customerService.findCustomerByEmail(login);
    }

    @PostMapping("/customer/register")
    public Customer register(@RequestBody Customer customer){
        return customerService.registerCustomer(customer);
    }


}
