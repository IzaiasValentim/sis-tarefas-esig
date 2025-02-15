package com.esig.izaiasvalentim.domain.repository.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.transaction.Transactional;

import java.util.List;

public abstract class GeneralJPARepository<T> implements Repository<T> {

    private final Class<T> entityClass;

    public GeneralJPARepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    @Override
    public T save(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        getEntityManager().merge(entity);
        return entity;
    }

    @Override
    public T findById(Object entityId) {
        return getEntityManager().find(entityClass, entityId);
    }


    @Override
    @Transactional
    public void delete(T entity) {
        EntityManager entityManager = getEntityManager();
        if (entity == null) {
            throw new IllegalArgumentException("Entidade não encontrada com o ID:");
        }
        entityManager.remove(entityManager.merge(entity));
        entityManager.flush();
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
