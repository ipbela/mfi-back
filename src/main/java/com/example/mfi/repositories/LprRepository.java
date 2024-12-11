package com.example.mfi.repositories;

import com.example.mfi.models.LprModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LprRepository extends JpaRepository<LprModel, UUID> {
}