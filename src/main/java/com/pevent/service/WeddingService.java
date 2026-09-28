package com.pevent.service;

import com.pevent.entity.Wedding;
import com.pevent.repository.WeddingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeddingService {
    private final WeddingRepository weddingRepository;

    public WeddingService(WeddingRepository weddingRepository) {
        this.weddingRepository = weddingRepository;
    }

    public List<Wedding> findAll() {
        return weddingRepository.findAll();
    }

    public Wedding findById(Long id){
        return weddingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wedding not found: " + id));
    }

    public Wedding save(Wedding wedding) {
        return weddingRepository.save(wedding);
    }

    public void deleteById(Long id) {
        weddingRepository.deleteById(id);
    }
}
