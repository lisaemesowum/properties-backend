package com.properties.properties_backend.repository;

import com.properties.properties_backend.model.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {
//    Optional<ContactUs> findEmail(String email);
Optional<ContactUs> findByEmail(String email);
}
