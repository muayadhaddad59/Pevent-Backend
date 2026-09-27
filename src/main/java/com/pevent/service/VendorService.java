package com.pevent.service;

import com.pevent.entity.Vendor;
import com.pevent.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> findAll() {
        return vendorRepository.findAll();
    }

    public Vendor findById(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Vendor not found: " + id));
    }

    public Vendor save(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public void deleteById(Long id) {
        vendorRepository.deleteById(id);
    }
}
