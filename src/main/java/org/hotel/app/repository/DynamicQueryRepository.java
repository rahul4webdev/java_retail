package org.hotel.app.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DynamicQueryRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Object[]> executeDynamicQuery(String sqlQuery) {
        Query query = entityManager.createNativeQuery(sqlQuery);
        return query.getResultList();
    }
}
