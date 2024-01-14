package com.tangerpay.service.impl;

import com.tangerpay.model.dto.ContactDto;
import com.tangerpay.model.entity.Contact;
import com.tangerpay.repository.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class ContactServiceImplTest {

    @Mock
    ContactRepository contactRepository;

    @Mock
    ModelMapper modelMapper;
    @InjectMocks
    ContactServiceImpl contactService;

   ContactDto contactDto;
   Contact contact;
   Contact entity;

    @BeforeEach
    public void setup() {
        contactDto = new ContactDto("Tony Stark","099999999");
        contact = modelMapper.map(contactDto, Contact.class);
        entity = Contact.builder()
                .id(1L)
                .name("Tony Stark")
                .phone("099999999")
                .build();
    }

    @Test
    void should_return_id() {
        given(modelMapper.map(contactDto, Contact.class)).willReturn(contact);
        given(contactRepository.save(contact)).willReturn(entity);
        String id = contactService.recordContactDetails(contactDto);
        assertThat(id).isNotBlank();
    }

    @Test
    void should_return_name_stark() {
        given(contactRepository.findById(1L)).willReturn(Optional.ofNullable(entity));
        lenient().when(contactService.retrieveContactDetails(1L)).thenReturn(contactDto);
        assertThat(contactDto.getName()).isEqualTo("Tony Stark");
    }
}