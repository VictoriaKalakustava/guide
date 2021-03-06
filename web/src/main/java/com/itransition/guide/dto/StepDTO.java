package com.itransition.guide.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StepDTO {
    private Long id;
    private String title;
    private List<ElementDTO> elements;
    private Long instructionId;
    private Integer position;
}
