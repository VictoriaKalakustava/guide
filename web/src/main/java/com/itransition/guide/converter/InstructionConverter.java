package com.itransition.guide.converter;

import com.itransition.guide.dto.InstructionDTO;
import com.itransition.guide.dto.StepDTO;
import com.itransition.guide.entity.Instruction;
import com.itransition.guide.entity.Step;
import com.itransition.guide.entity.User;
import com.itransition.guide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InstructionConverter {
    @Autowired
    private UserService userService;

    @Autowired
    private StepConverter stepConverter;

    public InstructionDTO convert(Instruction instruction) {
        InstructionDTO dto = new InstructionDTO();
        dto.setId(instruction.getId());
        dto.setTitle(instruction.getTitle());
        dto.setUserId(instruction.getUser().getId());
        List<StepDTO> dtoList = new ArrayList<>();
        for (Step step:instruction.getStep()) {
            dtoList.add(stepConverter.convert(step));
        }
        dto.setStep(dtoList);
        dto.setUserLogin(instruction.getUser().getLogin());
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
        List<Step> list = new ArrayList<>();
        for (StepDTO step : dto.getStep()) {
            list.add(stepConverter.convert(step));
        }
        instruction.setStep(list);
        return instruction;
    }
}
