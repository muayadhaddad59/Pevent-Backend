package com.pevent.controller;

import com.pevent.dto.CreateWeddingRequest;
import com.pevent.entity.Wedding;
import com.pevent.service.WeddingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weddings")
public class WeddingController {
    private final WeddingService weddingService;

    public WeddingController(WeddingService weddingService) {
        this.weddingService = weddingService;
    }

    @GetMapping
    public List<Wedding> findAll() {
        return weddingService.findAll();
    }

    @GetMapping("/{id}")
    public Wedding findById(@PathVariable Long id) {
        return weddingService.findById(id);
    }

    @PostMapping
    public Wedding save(@Valid @RequestBody CreateWeddingRequest request) {
        return weddingService.save(request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        weddingService.deleteById(id);
    }
}
