package com.staffs.myacademy.contollers;

import com.staffs.myacademy.models.Contact;
import com.staffs.myacademy.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public Contact saveContact(@RequestBody Contact contact){

        return contactService.insertContactDetails(contact);

    }
}
