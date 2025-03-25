package com.drobledo.kiwi.repository;

import com.drobledo.kiwi.model.SavedJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedJobRepository extends JpaRepository<SavedJob, Integer> {
}
