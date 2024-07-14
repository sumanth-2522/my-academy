package com.staffs.myacademy.services;

import com.staffs.myacademy.models.Customer;
import com.staffs.myacademy.models.Login;
import com.staffs.myacademy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findCustomerByEmail(Login email){
       return customerRepository.findByEmail(email.getEmail());
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
