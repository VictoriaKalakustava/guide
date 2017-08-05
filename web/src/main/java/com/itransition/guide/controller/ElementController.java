package com.itransition.guide.controller;

import com.itransition.guide.converter.ElementConverter;
import com.itransition.guide.converter.StepConverter;
import com.itransition.guide.dto.ElementDTO;
import com.itransition.guide.dto.StepDTO;
import com.itransition.guide.entity.Element;
import com.itransition.guide.entity.Step;
import com.itransition.guide.services.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/element")
public class ElementController {
    @Autowired
    ElementService elementService;

    @RequestMapping(value="/set-element", method = RequestMethod.POST)
    public ResponseEntity<ElementDTO> setElement(@RequestBody ElementDTO elementDTO){
        Element element = ElementConverter.convert(elementDTO);
        ElementDTO dto = ElementConverter.convert(elementService.save(element));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
