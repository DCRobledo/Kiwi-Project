package com.drobledo.kiwi.service;

import com.drobledo.kiwi.model.SavedJob;
import com.drobledo.kiwi.repository.SavedJobRepository;
import org.springframework.stereotype.Service;

@Service
public class SavedJobService {

    private final SavedJobRepository savedJobRepository;

    public SavedJobService(SavedJobRepository savedJobRepository) {
        this.savedJobRepository = savedJobRepository;
    }

    // Method to save a job
    public SavedJob addJob(SavedJob savedJob) {
        return savedJobRepository.save(savedJob);
    }

    // Method to get all jobs
    public Iterable<SavedJob> getAllJobs() {
        return savedJobRepository.findAll();
    }

    // Method to find a job by ID
    public SavedJob getJobById(Integer id) {
        return savedJobRepository.findById(id).orElse(null);
    }

    // Method to delete a job
    public void deleteJob(Integer id) {
        savedJobRepository.deleteById(id);
    }
}
