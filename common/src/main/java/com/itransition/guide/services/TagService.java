package com.itransition.guide.services;

import com.itransition.guide.entity.Tag;
import com.itransition.guide.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    @Transactional
    public Tag save(Tag instruction) {
        return tagRepository.saveAndFlush(instruction);
    }

    public Tag findById(Long id) {
        return tagRepository.findById(id);
    }
}
