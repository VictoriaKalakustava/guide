package com.itransition.guide.converter;


import com.itransition.guide.dto.ElementDTO;
import com.itransition.guide.dto.StepDTO;
import com.itransition.guide.entity.Element;
import com.itransition.guide.entity.Instruction;
import com.itransition.guide.entity.Step;

import java.util.ArrayList;
import java.util.List;

public class StepConverter {


    public static StepDTO convert(Step step) {
        StepDTO dto = new StepDTO();
        dto.setId(step.getId());
        dto.setInstructionId(step.getInstruction().getId());
        dto.setTitle(step.getTitle());
        dto.setPosition(step.getPosition());
        List<ElementDTO> elementDTO = new ArrayList<>();
        for (Element element: step.getElements()) {
            elementDTO.add(ElementConverter.convert(element));
        }
        dto.setElements(elementDTO);
        return dto;
    }
    public static Step convert(StepDTO stepDTO){
        Step step = new Step();
        step.setId(stepDTO.getId());
        step.setInstruction(new Instruction());
        step.getInstruction().setId(stepDTO.getInstructionId());
        step.setTitle(stepDTO.getTitle());
        List<Element> element = new ArrayList<>();
        for(ElementDTO elementDTO:stepDTO.getElements()){
            element.add(ElementConverter.convert(elementDTO));
        }
        step.setElements(element);
        step.setPosition(stepDTO.getPosition());
        return step;
    }
}
