package com.esig.izaiasvalentim.domain.repository.repositories;

import com.esig.izaiasvalentim.domain.entity.Tarefa;
import com.esig.izaiasvalentim.domain.repository.persistence.GeneralJPARepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class TarefasRepository extends GeneralJPARepository<Tarefa> {

    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @PersistenceContext(unitName = "TAREFAS")
    private EntityManager em;

    public TarefasRepository() {
        super(Tarefa.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Tarefa> findAll() {
        Query query = em.createQuery(
                "SELECT t FROM TAREFAS t " +
                        "WHERE t.estaDeletada = false " +
                        "ORDER BY t.dataInicio ASC"
        );
        return query.getResultList();
    }
}
