package com.tracecirclebackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracecirclebackend.entity.PasswordHistory;

@Repository
public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, Long> {
    List<PasswordHistory> findTop3ByEmailOrderByChangedAtDesc(String email);
}
