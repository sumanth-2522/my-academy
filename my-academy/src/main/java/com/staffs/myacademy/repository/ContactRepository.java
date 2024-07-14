package com.staffs.myacademy.repository;

import com.staffs.myacademy.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
