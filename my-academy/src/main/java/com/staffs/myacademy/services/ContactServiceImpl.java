package com.staffs.myacademy.services;

import com.staffs.myacademy.models.Contact;
import com.staffs.myacademy.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact insertContactDetails(Contact contact){
        return contactRepository.save(contact);
    }
}
