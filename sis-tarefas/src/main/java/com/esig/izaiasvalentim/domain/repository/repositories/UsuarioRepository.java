package com.esig.izaiasvalentim.domain.repository.repositories;

import com.esig.izaiasvalentim.domain.entity.Usuario;
import com.esig.izaiasvalentim.domain.repository.persistence.GeneralJPARepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UsuarioRepository extends GeneralJPARepository<Usuario> {

    @PersistenceContext(unitName = "TAREFAS")
    private EntityManager em;

    public UsuarioRepository() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
