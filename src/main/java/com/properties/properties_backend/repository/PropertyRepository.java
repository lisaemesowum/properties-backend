package com.properties.properties_backend.repository;

import com.properties.properties_backend.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
   Optional<Property> getByName(String name);
    List<Property> findByCategory_Name(String categoryName);
}
