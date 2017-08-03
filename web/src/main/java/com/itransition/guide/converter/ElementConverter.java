package com.itransition.guide.converter;

import com.itransition.guide.dto.ElementDTO;
import com.itransition.guide.entity.Element;

public class ElementConverter {
    public static ElementDTO convert(Element element) {
        ElementDTO dto = new ElementDTO();
        dto.setId(element.getId());
        //dto.setStep(element.getStep());
        dto.setType(element.getType());
        dto.setValue(element.getValue());
        dto.setPosition(element.getPosition());
        return dto;
    }

    public static Element convert(ElementDTO elementDTO){
        Element element = new Element();
        element.setId(elementDTO.getId());
        element.setStep(elementDTO.getStep());
        element.setType(elementDTO.getType());
        element.setValue(elementDTO.getValue());
        element.setPosition(elementDTO.getPosition());
        return element;
    }

}
