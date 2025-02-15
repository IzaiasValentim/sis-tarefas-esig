package com.esig.izaiasvalentim.domain.repository.repositories;

import com.esig.izaiasvalentim.domain.entity.Usuario;
import com.esig.izaiasvalentim.domain.repository.persistence.GeneralJPARepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

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

    public Boolean buscarUsuarioPorEmail(String email) {
        Query query = em.createQuery("SELECT u FROM USUARIOS u WHERE u.Email = :email");
        query.setParameter("email", email);

        try {
            Usuario usuario = (Usuario) query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }
}
