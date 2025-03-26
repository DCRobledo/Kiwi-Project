package com.drobledo.kiwi.repository;

import com.drobledo.kiwi.entity.HelloDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HelloRepository extends JpaRepository<HelloDB, Integer> {
    Optional<HelloDB> findById(int id);
}
