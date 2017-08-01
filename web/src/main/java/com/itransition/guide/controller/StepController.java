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

//    @RequestMapping(value="/get-by-id", method = RequestMethod.POST)
//    public ResponseEntity<Step> getStep(@RequestBody String json, HttpServletRequest request) {
//        System.out.println("StepController: " + json.split(":")[1].substring(0,1));
//        Optional<Step> step = stepService.getStepById(Long.decode(json.split(":")[1].substring(0,1)));
//        if (step.isPresent()) {
//            return new ResponseEntity<Step>(step.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<Step>(HttpStatus.CONFLICT);
//        }
//    }

    @RequestMapping(value="/get-by-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<StepDTO> getStep(@PathVariable Long id) {
        System.out.println("-------------------------------------------------////////////StepController: " + id);
        Optional<Step> step = stepService.getStepById(id);
        if(step.isPresent()) {
            StepDTO dto = StepConverter.convert(step.get());
            System.out.println(dto);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }
}
