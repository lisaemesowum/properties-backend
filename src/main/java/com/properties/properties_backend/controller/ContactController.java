package com.properties.properties_backend.controller;

import com.properties.properties_backend.Dto.ContactRequest;
import com.properties.properties_backend.Dto.ContactUsResponse;
import com.properties.properties_backend.Service.ContactUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final ContactUsService contactUsService;

    // Create a new contact message
    @PostMapping
    public ResponseEntity<ContactUsResponse> createContact(@RequestBody ContactRequest request) {
        return ResponseEntity.ok(contactUsService.createMessage(request));
    }
    // Get all contact messages
    @GetMapping
    public ResponseEntity<List<ContactUsResponse>> getAllContacts() {
        return ResponseEntity.ok(contactUsService.getAllContacts());
    }
    // Get a contact message by ID
    @GetMapping("/{id}")
    public ResponseEntity<ContactUsResponse> getContactById(@PathVariable Long id) {
        return ResponseEntity.ok(contactUsService.getContactById(id));
    }

    // Delete a contact message
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactUsService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }

}
