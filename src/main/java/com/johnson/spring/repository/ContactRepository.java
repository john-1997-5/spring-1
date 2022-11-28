package com.johnson.spring.repository;

import com.johnson.spring.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int saveContact(Contact contact) {
        String query = "insert into contact_msg (name, mobile_num, email, subject, message, status, created_at, created_by)" +
                " values(?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(query,
                contact.getName(),
                contact.getMobileNum(),
                contact.getEmail(),
                contact.getSubject(),
                contact.getMessage(),
                contact.getStatus(),
                contact.getCreatedAt(),
                contact.getCreatedBy());
    }
}
