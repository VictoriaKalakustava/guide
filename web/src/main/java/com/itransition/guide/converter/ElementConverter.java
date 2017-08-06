package com.itransition.guide.converter;

import com.itransition.guide.dto.ElementDTO;
import com.itransition.guide.entity.Element;
import com.itransition.guide.entity.Step;
import org.springframework.stereotype.Component;

@Component
public class ElementConverter {

    public static ElementDTO convert(Element element) {
        ElementDTO dto = new ElementDTO();
        dto.setId(element.getId());
        dto.setType(element.getType());
        dto.setValue(element.getValue());
        dto.setPosition(element.getPosition());
        return dto;
    }

    public static Element convert(ElementDTO elementDTO){
        Element element = new Element();
        element.setId(elementDTO.getId());
        element.setStep(new Step());
        element.getStep().setId(elementDTO.getStepId());
        element.setType(elementDTO.getType());
        element.setValue(elementDTO.getValue());
        element.setPosition(elementDTO.getPosition());
        return element;
    }

}
