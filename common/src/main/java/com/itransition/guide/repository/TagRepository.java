package com.itransition.guide.repository;


import com.itransition.guide.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findById(Long id);
    Tag findByName(String name);
}
