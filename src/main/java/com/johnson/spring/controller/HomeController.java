package com.johnson.spring.controller;

import com.johnson.spring.model.Contact;
import com.johnson.spring.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    ContactService contactService;

    @PostMapping("/saveMsg")
    public ModelAndView saveMessage(Contact contact) {
        boolean messageSaved = contactService.saveMessage(contact);
        log.info("saved message? -> {}", messageSaved);

        return new ModelAndView("redirect:/contact");
    }

}
