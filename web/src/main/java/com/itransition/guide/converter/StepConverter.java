package com.itransition.guide.converter;


import com.itransition.guide.dto.ElementDTO;
import com.itransition.guide.dto.StepDTO;
import com.itransition.guide.entity.Element;
import com.itransition.guide.entity.Step;

import java.util.ArrayList;
import java.util.List;

public class StepConverter {


    public static StepDTO convert(Step step) {
        StepDTO dto = new StepDTO();
        dto.setId(step.getId());
        dto.setInstructionId(step.getInstruction().getId());
        dto.setTitle(step.getTitle());
        List<ElementDTO> elementDTO = new ArrayList<>();
        for (Element element: step.getElements()) {
            elementDTO.add(ElementConverter.convert(element));
        }
        dto.setElements(elementDTO);
        return dto;
    }
}
