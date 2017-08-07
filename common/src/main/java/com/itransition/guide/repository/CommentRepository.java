package com.itransition.guide.repository;

import com.itransition.guide.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Long> {
    Comment findById(Long id);

    List<Comment> findByInstruction_Id(Long id);
}