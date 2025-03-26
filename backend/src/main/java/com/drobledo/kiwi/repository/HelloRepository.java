package com.drobledo.kiwi.repository;

import com.drobledo.kiwi.entity.HelloDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<HelloDB, Integer> {
}