package com.itransition.guide.controller;

import com.itransition.guide.converter.ElementConverter;
import com.itransition.guide.converter.StepConverter;
import com.itransition.guide.dto.ElementDTO;
import com.itransition.guide.dto.StepDTO;
import com.itransition.guide.entity.Element;
import com.itransition.guide.entity.Step;
import com.itransition.guide.services.ElementService;
import com.itransition.guide.services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/step")
public class StepController {
    @Autowired
    StepService stepService;

    @Autowired
    StepConverter stepConverter;

    @RequestMapping(value="/get-by-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<StepDTO> getStep(@PathVariable Long id) {
        Optional<Step> step = stepService.getStepById(id);
        if(step.isPresent()) {
            return new ResponseEntity<>(stepConverter.convert(step.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @RequestMapping(value="/set-step", method = RequestMethod.POST)
    public ResponseEntity<StepDTO> setStep(@RequestBody StepDTO stepDTO){
        System.out.println("save step");
        System.out.println(stepDTO.toString());
        Step step = stepConverter.convert(stepDTO);
        StepDTO dto = stepConverter.convert(stepService.save(step));
        System.out.println(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @RequestMapping(value="/del-step", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> delStep(@RequestBody StepDTO stepDTO){
        System.out.println("delete step");
        System.out.println(stepDTO.toString());
            Step step = stepConverter.convert(stepDTO);
            stepService.delete(step);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
