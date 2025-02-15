package com.esig.izaiasvalentim.domain.repository.persistence;

import jakarta.ejb.Local;
import jakarta.transaction.Transactional;

import java.util.List;

@Local
public interface Repository<T> {

    T save(T entity);

    T update(T entity);

    T findById(Object entityId);

    @Transactional
    void delete(T entity);

    List<T> findAll();

}
