package com.pevent.controller;

import com.pevent.entity.VendorCategory;
import com.pevent.service.VendorCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor-categories")
public class VendorCategoryController {
    private final VendorCategoryService vendorCategoryService;

    public VendorCategoryController(VendorCategoryService vendorCategoryService) {
        this.vendorCategoryService = vendorCategoryService;
    }

    @GetMapping
    public List<VendorCategory> getAll() {
        return vendorCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public VendorCategory getById(@PathVariable Long id) {
        return vendorCategoryService.findById(id);
    }

    @PostMapping
    public VendorCategory save(@RequestBody VendorCategory vendorCategory) {
        return vendorCategoryService.save(vendorCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        vendorCategoryService.deleteById(id);
    }
}
