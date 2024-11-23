package com.innoverasolutions.resource_management.repository;

import com.innoverasolutions.resource_management.model.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackathonRepository extends JpaRepository<Hackathon, Long> {
    // This interface is for CRUD operations on Hackathon entities
}
