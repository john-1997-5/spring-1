package com.johnson.spring.service;

import com.johnson.spring.model.AppConstants;
import com.johnson.spring.repository.ContactRepository;
import com.johnson.spring.model.Contact;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScope
//@SessionScope
//@RequestScope
@Service
@Slf4j
@Getter
@Setter
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    public boolean saveMessage(Contact contact) {
        contact.setStatus(AppConstants.OPEN);
        contact.setCreatedBy(AppConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int saved = contactRepository.saveContact(contact);
        return saved > 0;
    }

    public List<Contact> findMessagesWithOpenStatus() {
       return contactRepository.findMessagesWithOpenStatus(AppConstants.OPEN);
    }
}
