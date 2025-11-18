package com.properties.properties_backend.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactUsResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;
    private LocalDateTime createdAt;


}
