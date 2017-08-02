package com.itransition.guide.services;

import com.itransition.guide.entity.Instruction;
import com.itransition.guide.repository.InstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructionService {
    @Autowired
    InstructionRepository instructionRepository;

    public Instruction save(Instruction instruction) {
        return instructionRepository.save(instruction);
    }
}
