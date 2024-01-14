package com.tangerpay.service.impl;

import com.tangerpay.exception.ContactExistException;
import com.tangerpay.exception.NotFoundException;
import com.tangerpay.model.dto.ContactDto;
import com.tangerpay.model.entity.Contact;
import com.tangerpay.repository.ContactRepository;
import com.tangerpay.service.ContactService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    @Override
    public String recordContactDetails(ContactDto contactDto) {
        Contact entity = modelMapper.map(contactDto, Contact.class);

        if (contactRepository.existsByNameIgnoreCase(contactDto.getName())) {
            throw new ContactExistException(String.format("Contact with Name %s already exist",contactDto.getName()));
        }
        if (contactRepository.existsByPhone(contactDto.getPhone())) {
            throw new ContactExistException(String.format("Contact with Phone# %s already exist",contactDto.getPhone()));
        }

        Contact contact = contactRepository.save(entity);
        return contact.getId().toString();
    }

    @Override
    public ContactDto retrieveContactDetails(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Contact with Id %s not found", id)));

        ContactDto contactDto = modelMapper.map(contact, ContactDto.class);
        return contactDto;
    }
}
