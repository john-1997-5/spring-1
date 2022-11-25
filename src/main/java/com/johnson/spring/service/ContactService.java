package com.johnson.spring.service;

import com.johnson.spring.model.Contact;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@ApplicationScope
//@SessionScope
//@RequestScope
@Service
@Slf4j
@Getter
@Setter
public class ContactService {
    private int counter = 0;
    public ContactService() {
        log.info("ContactService Bean initialized");
    }

    public boolean saveMessage(Contact contact){
        log.info("contact info.. {}", contact);
        return true;
    }
}
