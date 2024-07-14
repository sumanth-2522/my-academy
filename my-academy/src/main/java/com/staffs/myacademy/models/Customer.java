package com.staffs.myacademy.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

//    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
//    private WishList wishList;

    @Embedded
    private Address address;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Orders> customerOrders;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Orders> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<Orders> customerOrders) {
        this.customerOrders = customerOrders;
    }

//    public WishList getWishList() {
//        return wishList;
//    }
//
//    public void setWishList(WishList wishList) {
//        this.wishList = wishList;
//    }
}
