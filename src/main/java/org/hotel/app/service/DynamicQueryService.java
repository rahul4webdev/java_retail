package org.hotel.app.service;
import org.hotel.app.repository.DynamicQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class DynamicQueryService {

    @Autowired
    private DynamicQueryRepository dynamicQueryRepository;

    @Autowired
    private EntityManager entityManager;
    
    public List<Object[]> executeDynamicQuery(String sqlQuery) {
        return dynamicQueryRepository.executeDynamicQuery(sqlQuery);
    }

    @Transactional
    public int executeUpdateQuery(String sqlQuery) {
        try {
            Query query = entityManager.createNativeQuery(sqlQuery);
            return query.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error executing update query: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    
    }
}
