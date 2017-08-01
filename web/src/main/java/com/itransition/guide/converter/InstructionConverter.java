package com.itransition.guide.converter;

import com.itransition.guide.dto.InstructionDTO;
import com.itransition.guide.entity.Instruction;

public class InstructionConverter {
    public static InstructionDTO convert(Instruction instruction) {
        InstructionDTO dto = new InstructionDTO();
        dto.setId(instruction.getId());
        dto.setTitle(instruction.getTitle());
        dto.setUserId(instruction.getUser().getId());
        dto.setStep(instruction.getStep());
        return dto;
    }
}
