package com.itransition.guide.controller;

import com.itransition.guide.converter.CommentConverter;
import com.itransition.guide.converter.InstructionConverter;
import com.itransition.guide.dto.CommentDTO;
import com.itransition.guide.dto.InstructionDTO;
import com.itransition.guide.entity.Comment;
import com.itransition.guide.entity.Instruction;
import com.itransition.guide.services.CommentService;
import com.itransition.guide.services.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/instruction")
public class InstructionController {
    @Autowired
    InstructionService instructionService;

    @Autowired
    CommentService commentService;

    @Autowired
    private InstructionConverter instructionConverter;

    @Autowired
    private CommentConverter commentConverter;

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<InstructionDTO> getStep(@RequestBody InstructionDTO dto) {
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

    @RequestMapping(value="/add/comment", method = RequestMethod.POST)
    public ResponseEntity<CommentDTO> getStep(@RequestBody CommentDTO dto) {
        Comment comment = commentService.save(commentConverter.convert(dto));
        return new ResponseEntity<>(commentConverter.convert(comment), HttpStatus.OK);
    }

    @RequestMapping(value="/get/comment", method = RequestMethod.POST)
    public ResponseEntity<List<CommentDTO>> getComments(@RequestBody Long id) {
        List<Comment> comments = commentService.findByInstructionId(id);
        List<CommentDTO> dto = new ArrayList<>();
        for (Comment comment: comments) {
            dto.add(commentConverter.convert(comment));
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @RequestMapping(value="/get", method = RequestMethod.POST)
    public ResponseEntity<InstructionDTO> getStep(@RequestBody Long id) {
        Instruction instruction = instructionService.findById(id).get();
        return new ResponseEntity<>(instructionConverter.convert(instruction), HttpStatus.OK);
    }
}
