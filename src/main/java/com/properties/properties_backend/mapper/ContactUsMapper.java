package com.properties.properties_backend.mapper;

import com.properties.properties_backend.Dto.CategoryRequest;
import com.properties.properties_backend.Dto.ContactRequest;
import com.properties.properties_backend.Dto.ContactUsResponse;
import com.properties.properties_backend.model.ContactUs;
import lombok.Data;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public class ContactUsMapper {

    public ContactUs toEntity(ContactRequest request){
        if(request == null) return null;

        ContactUs contactUs = new ContactUs();
        contactUs.setName(request.getName());
        contactUs.setEmail(request.getEmail());
        contactUs.setPhone(request.getPhone());
        contactUs.setSubject(request.getSubject());
        contactUs.setMessage(request.getMessage());
        return contactUs;
    }

    public ContactUsResponse toResponse(ContactUs contactUs){
        if(contactUs == null) return  null;

       ContactUsResponse response = new ContactUsResponse();
        response.setId(contactUs.getId());
        response.setName(contactUs.getName());
        response.setEmail(contactUs.getEmail());
        response.setPhone(contactUs.getPhone());
        response.setSubject(contactUs.getSubject());
        response.setMessage(contactUs.getMessage());
        response.setCreatedAt(contactUs.getCreatedAt());
        return response;
    }


}
