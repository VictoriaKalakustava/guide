package com.itransition.guide.services;

import com.itransition.guide.entity.Instruction;
import com.itransition.guide.repository.InstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstructionService {
    @Autowired
    InstructionRepository instructionRepository;

    @Transactional
    public Instruction save(Instruction instruction) {
        return instructionRepository.saveAndFlush(instruction);
    }
}
