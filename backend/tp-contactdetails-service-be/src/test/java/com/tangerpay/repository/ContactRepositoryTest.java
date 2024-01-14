package com.tangerpay.repository;

import com.tangerpay.exception.NotFoundException;
import com.tangerpay.model.entity.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ContactRepositoryTest {

    @Autowired
    ContactRepository contactRepository;

    Contact contact;

    @BeforeEach
    public void setup() {
        contact = Contact.builder()
                .name("Tony Stark")
                .phone("099999999")
                .build();
    }

    @Test
    public void should_store_a_contact() {
        Contact savedContact = contactRepository.save(contact);
        assertThat(savedContact.getName()).isEqualTo("Tony Stark");
    }

    @Test
    public void should_return_contact() {
        contactRepository.save(contact);
        Contact retrievedContact = contactRepository.findById(contact.getId()).get();
        assertThat(retrievedContact.getName()).isEqualTo("Tony Stark");
    }

    @Test
    public void should_throw_entity_notfound_exception() {
        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            Contact retrievedContact = contactRepository.findById(1L)
                    .orElseThrow(NotFoundException::new);
        });
    }
}