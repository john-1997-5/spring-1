package com.johnson.spring.service;

import com.johnson.spring.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContactService {

    public boolean saveMessage(Contact contact){
        log.info("contact info.. {}", contact);
        return true;
    }
}
