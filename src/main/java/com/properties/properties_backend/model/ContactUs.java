package com.properties.properties_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "contact_us")
@NoArgsConstructor
public class ContactUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false) //required fields
    private String subject;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();  // for current time

}
