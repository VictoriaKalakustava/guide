package com.itransition.guide.repository;

import com.itransition.guide.entity.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, Long> {
    Instruction findInstructionByUser(Long userId);
    Instruction save(Instruction instruction);
}
