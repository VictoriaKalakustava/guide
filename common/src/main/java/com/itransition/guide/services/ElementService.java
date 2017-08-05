package com.itransition.guide.services;

import com.itransition.guide.entity.Element;
import com.itransition.guide.entity.Step;
import com.itransition.guide.repository.ElementRepository;
import com.itransition.guide.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ElementService {
    @Autowired
    private ElementRepository elementRepository;

    @Transactional
    public Element save(Element element){
        return elementRepository.saveAndFlush(element);
    }

    public Optional<Element> getElementByStep(Step step) {
        return Optional.ofNullable(elementRepository.findElementByStep(step));
    }
}
