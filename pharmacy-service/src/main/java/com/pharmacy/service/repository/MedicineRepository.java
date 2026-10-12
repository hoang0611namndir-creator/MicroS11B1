package com.pharmacy.service.repository;

import com.pharmacy.service.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository
        extends JpaRepository<Medicine, Long> {
}