package com.itransition.guide.converter;

import com.itransition.guide.dto.CommentDTO;
import com.itransition.guide.entity.Comment;
import com.itransition.guide.services.InstructionService;
import com.itransition.guide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    @Autowired
    InstructionService instructionService;

    @Autowired
    UserService userService;

    public Comment convert(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setText(dto.getValue());
        comment.setInstruction(instructionService.findById(dto.getInstructionId()));
        comment.setUser(userService.findById(dto.getUserId()).get());
        return comment;
    }

    public CommentDTO convert(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setValue(comment.getText());
        dto.setUserLogin(comment.getUser().getLogin());
        dto.setUserId(comment.getUser().getId());
        dto.setInstructionId(comment.getInstruction().getId());
        dto.setUserImg(comment.getUser().getImage());
        return dto;
    }
}
