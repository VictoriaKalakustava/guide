package com.itransition.guide.services;

import com.itransition.guide.entity.Comment;
import com.itransition.guide.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public Comment save(Comment comment){
        return commentRepository.saveAndFlush(comment);
    }

    public List<Comment> findByInstructionId(Long id) {
        return commentRepository.findByInstruction_Id(id);

    }

}
