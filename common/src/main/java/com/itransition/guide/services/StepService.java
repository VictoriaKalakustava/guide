package com.itransition.guide.services;

import com.itransition.guide.entity.Step;
import com.itransition.guide.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StepService {
    @Autowired
    private StepRepository stepRepository;

    public Optional<Step> getStepById(Long id) {
        return Optional.ofNullable(stepRepository.findById(id));
    }

}