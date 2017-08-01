package com.itransition.guide.converter;

import com.itransition.guide.dto.ElementDTO;
import com.itransition.guide.entity.Element;

public class ElementConverter {
    public static ElementDTO converter(Element element) {
        ElementDTO dto = new ElementDTO();
        dto.setId(element.getId());
        dto.setStepId(element.getStep().getId());
        dto.setType(element.getType());
        dto.setValue(element.getValue());
        return dto;
    }
}
