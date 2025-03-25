package com.drobledo.kiwi.controller;

import com.drobledo.kiwi.model.SavedJob;
import com.drobledo.kiwi.repository.SavedJobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class SavedJobController {

    private final SavedJobRepository savedJobRepository;

    public SavedJobController(SavedJobRepository savedJobRepository) {
        this.savedJobRepository = savedJobRepository;
    }

    @GetMapping
    public List<SavedJob> getAllJobs() {
        return savedJobRepository.findAll();
    }

    @PostMapping
    public SavedJob addJob(@RequestBody SavedJob savedJob) {
        return savedJobRepository.save(savedJob);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable int id) {
        savedJobRepository.deleteById(id);
    }
}
