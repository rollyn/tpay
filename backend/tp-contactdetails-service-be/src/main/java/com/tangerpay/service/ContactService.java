package com.tangerpay.service;

import com.tangerpay.model.dto.ContactDto;

public interface ContactService {

    String recordContactDetails(ContactDto contact);
    ContactDto retrieveContactDetails(Long id);
}
