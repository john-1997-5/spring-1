package com.johnson.spring.repository;

import com.johnson.spring.model.AppConstants;
import com.johnson.spring.model.Contact;
import com.johnson.spring.model.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.johnson.spring.model.AppConstants.OPEN;

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

    public List<Contact> findMessagesWithOpenStatus(String status) {
        String query = "select * from contact_msg where status = ?";
        return jdbcTemplate.query(query, ps -> ps.setString(1, status), new ContactRowMapper());
    }
}
