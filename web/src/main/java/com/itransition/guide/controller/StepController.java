package com.itransition.guide.controller;

import com.itransition.guide.converter.StepConverter;
import com.itransition.guide.dto.StepDTO;
import com.itransition.guide.entity.Step;
import com.itransition.guide.services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/step")
public class StepController {
    @Autowired
    StepService stepService;

    @RequestMapping(value="/get-by-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<StepDTO> getStep(@PathVariable Long id) {
        Optional<Step> step = stepService.getStepById(id);
        if(step.isPresent()) {
            return new ResponseEntity<>(StepConverter.convert(step.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }
}
