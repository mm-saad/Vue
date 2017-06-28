package com.vuejs.dao.db;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JPAFacade implements DAOFacade {

    @PersistenceContext
    EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public <T, K> T find(Class<T> clazz, K key) {
        return entityManager.find(clazz, key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> getList(String request, Parameter... params) {
        entityManager.setFlushMode(FlushModeType.COMMIT);
        Query query = entityManager.createQuery(request);
        for(Parameter param : params){
            query.setParameter(param.getName(), param.getValue());
        }
        return query.getResultList();
    }

    @Override
    public <T> T getSingle(String request, Parameter... params) {
        entityManager.setFlushMode(FlushModeType.COMMIT);
        Query query = entityManager.createQuery(request);
        for(Parameter param : params){
            query.setParameter(param.getName(), param.getValue());
        }
        return (T) query.getSingleResult();
    }


    @Override
    public void updateSingle(String request, Parameter... params) {
        entityManager.setFlushMode(FlushModeType.COMMIT);
        Query query = entityManager.createQuery(request);
        for(Parameter param : params){
            query.setParameter(param.getName(), param.getValue());
        }
        query.executeUpdate();
    }

    @Override
    public <T> T merge(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public <T> void remove(T entity) {
        entityManager.remove(entityManager.contains(entity)?entity:entityManager.merge(entity));
    }

    @Override
    public <T> void executeRequest(String request, Parameter... params) {
        entityManager.setFlushMode(FlushModeType.COMMIT);
        Query query = entityManager.createQuery(request);
        for(Parameter param : params){
            query.setParameter(param.getName(), param.getValue());
        }
        query.executeUpdate();
    }

    @Override
    public <T> void executeSQLRequest(String request, Parameter... params) {
        entityManager.setFlushMode(FlushModeType.COMMIT);
        Query query = entityManager.createNativeQuery(request);
        for(Parameter param : params){
            query.setParameter(param.getName(), param.getValue());
        }
        query.executeUpdate();
    }


    @Override
    public <T> void persist(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void clear() {
        entityManager.clear();
    }

    @Override
    public void flush() {entityManager.flush();}

    @Override
    public void setFlushMode(FlushModeType flushModeType) {
        entityManager.setFlushMode(flushModeType);
    }

}
