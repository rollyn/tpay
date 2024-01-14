package com.tangerpay.controller;

import com.tangerpay.exception.NotFoundException;
import com.tangerpay.model.dto.ContactDto;
import com.tangerpay.service.ContactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContactControllerTest {

    @Mock
    private ContactService contactService;

    @InjectMocks
    private ContactController contactController;

    ContactDto contactDto;

    @BeforeEach
    public void setuo() {
        contactDto = new ContactDto("Tony Stark","0999999999");
    }

    @Test
    void should_return_success() {

        when(contactService.recordContactDetails(any(ContactDto.class)))
                .thenReturn(String.valueOf(1L));
        String response = contactController.recordContactDetails(contactDto);
        assertThat(response).isEqualTo("1");
    }

    @Test
    void should_return_contact_dto() {
        when(contactService.retrieveContactDetails(1L))
                .thenReturn(contactDto);
        ContactDto response = contactController.retrieveContactDetails("1");
        assertThat(response.getName()).isEqualTo("Tony Stark");
    }

    @Test
    void should_throw_exception() {
        when(contactService.retrieveContactDetails(1L))
                .thenThrow(NotFoundException.class);
        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            ContactDto response = contactController.retrieveContactDetails("1");
        });
    }
}