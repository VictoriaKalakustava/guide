package com.itransition.guide.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TagDTO {
    private Long id;
    private Long instructionId;
    private String name;
}
