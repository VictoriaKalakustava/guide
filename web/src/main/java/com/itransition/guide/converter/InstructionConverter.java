package com.itransition.guide.converter;

import com.itransition.guide.dto.InstructionDTO;
import com.itransition.guide.entity.Instruction;
import com.itransition.guide.entity.User;
import com.itransition.guide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InstructionConverter {
    @Autowired
    private UserService userService;

    public static InstructionDTO convert(Instruction instruction) {
        InstructionDTO dto = new InstructionDTO();
        dto.setId(instruction.getId());
        dto.setTitle(instruction.getTitle());
        dto.setUserId(instruction.getUser().getId());
        dto.setStep(instruction.getStep());
        return dto;
    }

    public Instruction convert(InstructionDTO dto) {
        Instruction instruction = new Instruction();
        instruction.setId(dto.getId());
        instruction.setTitle(dto.getTitle());
        Optional<User> optional = userService.findById(dto.getUserId());
        if(optional.isPresent()) {
            instruction.setUser(optional.get());
        }
        instruction.setStep(dto.getStep());
        return instruction;
    }
}
