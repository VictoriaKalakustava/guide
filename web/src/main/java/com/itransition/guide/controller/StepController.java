package com.itransition.guide.controller;

import com.itransition.guide.entity.Step;
import com.itransition.guide.services.StepService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(value = "/step")
public class StepController {
    StepService stepService = new StepService();

    @RequestMapping(value="/get-by-id", method = RequestMethod.POST)
    public ResponseEntity<Step> getStep(@RequestBody String json, HttpServletRequest request) {
        System.out.println("StepController: " + json.split(":")[1].substring(0,1));
        Optional<Step> step = stepService.getStepById(Long.decode(json.split(":")[1].substring(0,1)));
        if (step.isPresent()) {
            return new ResponseEntity<Step>(step.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Step>(HttpStatus.CONFLICT);
        }
    }

//    @RequestMapping(value="/get-by-id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Step> getStep(@RequestParam String id) {
//        System.out.println("-------------------------------------------------////////////StepController: " + id);
//        Optional<Step> step = stepService.getStepById(Long.decode(id));
//        if(step.isPresent()) {
//            return new ResponseEntity<Step>(step.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//
//    }
}
