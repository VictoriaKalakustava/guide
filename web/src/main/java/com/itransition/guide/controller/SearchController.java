package com.itransition.guide.controller;

import com.itransition.guide.converter.InstructionConverter;
import com.itransition.guide.dto.InstructionDTO;
import com.itransition.guide.entity.Instruction;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<List> search(@RequestBody String searchParam) {
        logger.info("SearchController: {}", searchParam);
        List result = prepareQuery(searchParam).getResultList();
        List<InstructionDTO> dto = new ArrayList<>();
        for (Instruction instruction: (List<Instruction>)result) {
            dto.add(InstructionConverter.convert(instruction));
        }
        entityManager.getTransaction().commit();
        return new ResponseEntity<List>(dto, HttpStatus.OK);
    }

    public javax.persistence.Query prepareQuery(String searchParam) {
        FullTextEntityManager fullTextEntityManager = getFullTextEntityManager();
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(Instruction.class).get();
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .onFields("title", "step.title", "user.login", "tags.name", "step.elements.value", "comments.text", "user.login")
                .matching(searchParam)
                .createQuery();
        javax.persistence.Query jpaQuery =
                fullTextEntityManager.createFullTextQuery(luceneQuery, Instruction.class);
        return jpaQuery;
    }

    public FullTextEntityManager getFullTextEntityManager() {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
        try {
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        entityManager.getTransaction().begin();
        return fullTextEntityManager;
    }
}
