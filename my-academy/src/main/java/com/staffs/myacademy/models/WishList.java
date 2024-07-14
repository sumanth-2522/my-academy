//package com.staffs.myacademy.models;
//
//import javax.persistence.*;
//
//@Entity
//public class WishList {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int wishListId;
//    private boolean inStock;
//
//    @OneToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customers;
//
//    @OneToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    public int getWishListId() {
//        return wishListId;
//    }
//
//    public void setWishListId(int wishListId) {
//        this.wishListId = wishListId;
//    }
//
//    public boolean isInStock() {
//        return inStock;
//    }
//
//    public void setInStock(boolean inStock) {
//        this.inStock = inStock;
//    }
//
//    public Customer getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(Customer customers) {
//        this.customers = customers;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//}
