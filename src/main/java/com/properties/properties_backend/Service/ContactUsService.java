package com.properties.properties_backend.Service;

import com.properties.properties_backend.Dto.CategoryResponse;
import com.properties.properties_backend.Dto.ContactRequest;
import com.properties.properties_backend.Dto.ContactUsResponse;
import com.properties.properties_backend.mapper.ContactUsMapper;
import com.properties.properties_backend.model.ContactUs;
import com.properties.properties_backend.repository.ContactUsRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
@Transactional
//@RequiredArgsConstructor
public class ContactUsService {

    private final ContactUsRepository contactUsRepository;
    private final ContactUsMapper contactUsMapper;


    public ContactUsService(ContactUsRepository contactUsRepository, ContactUsMapper contactUsMapper) {
        this.contactUsRepository = contactUsRepository;
        this.contactUsMapper = contactUsMapper;
    }

//     create message
    public ContactUsResponse createMessage(ContactRequest request){
        ContactUs contact = contactUsMapper.toEntity(request);
        ContactUs saveMessage = contactUsRepository.save(contact);
        return contactUsMapper.toResponse(saveMessage);
    }
//    get all message
    public List<ContactUsResponse> getAllContacts(){
        return contactUsRepository.findAll().stream().map(contactUsMapper::toResponse).collect(Collectors.toList());
    }

//    get all messages by id
    public ContactUsResponse getContactById(Long id){
        ContactUs contactUs = contactUsRepository.findById(id).orElseThrow(()-> new RuntimeException("contact message not found " +id));
        return  contactUsMapper.toResponse(contactUs);
    }
////     update message
//
//    public ContactUsResponse updateMessage(Long id, ContactRequest request){
//        ContactUs contactUs = contactUsRepository.findById(id).orElseThrow(()-> new RuntimeException("contact message not found " +id));
//
//        contactUs.setName(request.getName());
//        contactUs.setEmail(request.getEmail());
//        contactUs.setPhone(request.getPhone());
//        contactUs.setSubject(request.getSubject());
//        contactUs.setMessage(request.getMessage());
//        ContactUs updatedMessage = contactUsRepository.save(contactUs);
//        return contactUsMapper.toResponse(updatedMessage);
//
//    }
//     delete message
    public void deleteContact(Long id){
        ContactUs contactUs = contactUsRepository.findById(id).orElseThrow(()-> new RuntimeException("contact message not found " +id));
        contactUsRepository.delete(contactUs);
    }
}
