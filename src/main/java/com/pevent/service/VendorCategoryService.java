package com.pevent.service;

import com.pevent.entity.VendorCategory;
import com.pevent.repository.VendorCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorCategoryService {

    private final VendorCategoryRepository vendorCategoryRepository;

    public VendorCategoryService(VendorCategoryRepository vendorCategoryRepository) {
        this.vendorCategoryRepository = vendorCategoryRepository;
    }

    public List<VendorCategory> findAll() {
        return vendorCategoryRepository.findAll();
    }

    public VendorCategory findById(Long id) {
        return vendorCategoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Vendor Category not found: " + id));
    }

    public VendorCategory save(VendorCategory vendorCategory) {
        return vendorCategoryRepository.save(vendorCategory);
    }

    public void deleteById(Long id) {
        vendorCategoryRepository.deleteById(id);
    }
}
