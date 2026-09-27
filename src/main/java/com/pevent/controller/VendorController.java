package com.pevent.controller;

import com.pevent.dto.CreateVendorRequest;
import com.pevent.entity.Vendor;
import com.pevent.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<Vendor> getAll() {
        return vendorService.findAll();
    }

    @GetMapping("/{id}")
    public Vendor getById(@PathVariable Long id) {
        return vendorService.findById(id);
    }

    @PostMapping
    public Vendor save(@RequestBody CreateVendorRequest request) {
        return vendorService.save(request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        vendorService.deleteById(id);
    }
}
