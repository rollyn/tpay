package com.tangerpay.controller;

import com.tangerpay.model.dto.ContactDto;
import com.tangerpay.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/recordContactDetails")
    public String recordContactDetails(@Validated @RequestBody ContactDto contact) {
        return contactService.recordContactDetails(contact);
    }

    @GetMapping("/retrieveContactDetails/{id}")
    public ContactDto retrieveContactDetails(@PathVariable(value = "id") String id) {
        return contactService.retrieveContactDetails(Long.valueOf(id));
    }

}
