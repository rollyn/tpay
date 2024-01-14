package com.tangerpay.repository;

import com.tangerpay.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    boolean existsByNameIgnoreCase(String name);
    boolean existsByPhone(String phone);
}
