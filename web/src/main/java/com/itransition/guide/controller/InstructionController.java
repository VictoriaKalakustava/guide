package com.itransition.guide.controller;

import com.itransition.guide.converter.InstructionConverter;
import com.itransition.guide.converter.UserConverter;
import com.itransition.guide.dto.InstructionDTO;
import com.itransition.guide.dto.UserDTO;
import com.itransition.guide.entity.Instruction;
import com.itransition.guide.entity.User;
import com.itransition.guide.services.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/instruction")
public class InstructionController {
    @Autowired
    InstructionService instructionService;

    @Autowired
    private InstructionConverter instructionConverter;

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<InstructionDTO> getStep(@RequestBody InstructionDTO dto) {
        System.out.println("BOTTOM INSTRUTION DTO");
        System.out.println(dto);
        Instruction instruction = instructionConverter.convert(dto);
        instruction = instructionService.save(instruction);
        dto = instructionConverter.convert(instruction);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @RequestMapping( value="/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<InstructionDTO> getInstruction(@PathVariable Long id) {
        Optional<Instruction> optional = instructionService.findById(id);
        if(optional.isPresent()) {
            Instruction instruction = optional.get();
            return new ResponseEntity<>(instructionConverter.convert(instruction), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
