package com.itransition.guide.dto;

import com.itransition.guide.entity.Step;
import com.itransition.guide.entity.enums.ElementType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ElementDTO {
    Long id;
    String value;
    ElementType type;
    Long position;
    Long stepId;
    Step step;
}
