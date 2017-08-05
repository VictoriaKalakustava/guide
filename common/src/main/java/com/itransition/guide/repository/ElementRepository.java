package com.itransition.guide.repository;

import com.itransition.guide.entity.Element;
import com.itransition.guide.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository  extends JpaRepository<Element, Long> {
    Element findElementByStep(Step step);
    Element findById(Long id);
}
