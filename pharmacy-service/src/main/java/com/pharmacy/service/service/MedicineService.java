package com.pharmacy.service.service;

import com.pharmacy.service.entity.Medicine;
import com.pharmacy.service.repository.MedicineRepository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Cacheable(value = "medicines", key = "#id")
    public Medicine getMedicineById(Long id) {

        System.out.println(">>> CACHE MISS: Truy vấn Database!");

        return medicineRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Không tìm thấy thuốc có ID: " + id
                        )
                );
    }
}