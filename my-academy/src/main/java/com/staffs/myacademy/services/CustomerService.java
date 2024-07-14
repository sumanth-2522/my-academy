package com.staffs.myacademy.services;

import com.staffs.myacademy.models.Customer;
import com.staffs.myacademy.models.Login;

public interface CustomerService {

    Customer findCustomerByEmail(Login email);

    Customer registerCustomer(Customer customer);
}
