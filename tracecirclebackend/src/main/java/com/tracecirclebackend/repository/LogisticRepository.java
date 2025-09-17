package com.tracecirclebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracecirclebackend.entity.LogisticsEntity;

public interface LogisticRepository extends JpaRepository<LogisticsEntity, Long>{

}
