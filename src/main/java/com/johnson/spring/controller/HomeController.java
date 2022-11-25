package com.johnson.spring.controller;

import com.johnson.spring.model.Contact;
import com.johnson.spring.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    ContactService contactService;

    /**
     * @ModelAttribute
     * @param contact
     * @param errors
     * @return
     */
    @PostMapping("/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
        if(errors.hasErrors()) {
            log.error("Contact form validation failed due to: {}", errors.toString());
            return "contact.html"; // mantiene la misma sesión (no refresca la página)
        }
        boolean messageSaved = contactService.saveMessage(contact);
        contactService.setCounter(contactService.getCounter() + 1);
        log.info("saved message? -> {}", messageSaved);
        log.info("ContactService Bean counter: {}\n", contactService.getCounter());
        return "redirect:/contact"; // ejecuta dicho endpoint nuevamente (refresco)
    }


}
