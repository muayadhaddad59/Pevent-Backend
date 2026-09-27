package com.pevent.service;

import com.pevent.dto.CreateVendorRequest;
import com.pevent.entity.Vendor;
import com.pevent.entity.VendorCategory;
import com.pevent.repository.VendorCategoryRepository;
import com.pevent.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;
    private final VendorCategoryRepository vendorCategoryRepository;

    public VendorService(VendorRepository vendorRepository, VendorCategoryRepository vendorCategoryRepository) {
        this.vendorRepository = vendorRepository;
        this.vendorCategoryRepository = vendorCategoryRepository;
    }

    public List<Vendor> findAll() {
        return vendorRepository.findAll();
    }

    public Vendor findById(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Vendor not found: " + id));
    }

    public void deleteById(Long id) {
        vendorRepository.deleteById(id);
    }

    public Vendor save(CreateVendorRequest request) {
        VendorCategory category = vendorCategoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new RuntimeException("Vendor Category not found: " + request.categoryId()));

        Vendor vendor = new Vendor(
                request.name(),
                request.description(),
                request.city(),
                request.address(),
                request.startingPrice(),
                request.phone(),
                request.website()
        );

        vendor.setCategory(category);

        return vendorRepository.save(vendor);
    }
}
