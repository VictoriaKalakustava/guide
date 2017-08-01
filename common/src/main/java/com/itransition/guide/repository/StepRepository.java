package com.itransition.guide.repository;

import com.itransition.guide.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends JpaRepository<Step, Long> {
    Step findById(Long id);
}
