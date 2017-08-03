package com.itransition.guide.dto;

import com.itransition.guide.entity.Instruction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StepDTO {
    Long id;
    String title;
    List<ElementDTO> elements;
    Long instructionId;
    Integer position;
    Instruction instruction;
}
