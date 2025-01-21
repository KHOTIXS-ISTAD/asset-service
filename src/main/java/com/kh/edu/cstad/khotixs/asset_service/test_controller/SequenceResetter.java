package com.kh.edu.cstad.khotixs.asset_service.test_controller;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SequenceResetter {

    private final EntityManager entityManager;

    @PostConstruct
    public void init() {
        // Call the reset method explicitly in a separate transactional method
        resetSequence();
    }

    @Transactional
    public void resetSequence() {
        // Ensure that the EntityManager joins the ongoing transaction
        entityManager.joinTransaction();

        // Execute the native query to reset the sequence
        Query query = entityManager.createNativeQuery(
                "SELECT setval(pg_get_serial_sequence('files', 'id'), (SELECT MAX(id) FROM files))");
        query.executeUpdate();
    }
}
