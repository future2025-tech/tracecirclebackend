package com.tracecirclebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracecirclebackend.entity.RecycleEntity;

@Repository
public interface RecycleRepository extends JpaRepository<RecycleEntity, Long>{

}
