package com.itransition.guide.dto;


import com.itransition.guide.entity.Step;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class InstructionDTO {
    Long id;
    String title;
    Long userId;
    List<Step> step;
}
