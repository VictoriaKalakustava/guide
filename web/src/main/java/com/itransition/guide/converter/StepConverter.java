package com.itransition.guide.converter;


import com.itransition.guide.dto.ElementDTO;
import com.itransition.guide.dto.StepDTO;
import com.itransition.guide.entity.Element;
import com.itransition.guide.entity.Instruction;
import com.itransition.guide.entity.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StepConverter {

    @Autowired
    private ElementConverter elementConverter;

    public StepDTO convert(Step step) {
        StepDTO dto = new StepDTO();
        dto.setId(step.getId());
        dto.setInstructionId(step.getInstruction().getId());
        dto.setTitle(step.getTitle());
        dto.setPosition(step.getPosition());
        List<ElementDTO> elementDTO = new ArrayList<>();
        for (Element element: step.getElements()) {
            elementDTO.add(elementConverter.convert(element));
        }
        dto.setElements(elementDTO);
        return dto;
    }
    public Step convert(StepDTO stepDTO){
        Step step = new Step();
        step.setId(stepDTO.getId());
        step.setInstruction(new Instruction());
        step.getInstruction().setId(stepDTO.getInstructionId());
        step.setTitle(stepDTO.getTitle());
        List<Element> element = new ArrayList<>();
        for(ElementDTO elementDTO:stepDTO.getElements()){
            element.add(elementConverter.convert(elementDTO));
        }
        step.setElements(element);
        step.setPosition(stepDTO.getPosition());
        return step;
    }
}
