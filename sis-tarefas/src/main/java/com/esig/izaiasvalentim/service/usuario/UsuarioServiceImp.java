package com.esig.izaiasvalentim.service.usuario;

import com.esig.izaiasvalentim.domain.entity.Usuario;
import com.esig.izaiasvalentim.domain.repository.repositories.UsuarioRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.transaction.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

@Stateless
public class UsuarioServiceImp {

    @EJB
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        Boolean usuarioExiste = usuarioRepository.buscarUsuarioPorEmail(usuario.getEmail());
        if (usuarioExiste) {
            throw new PersistenceException("E-mail já existente na base de dados!");
        } else {
            return usuarioRepository.save(usuario);
        }
    }

    public Usuario retornarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> todos() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public void remover(Long idUsuario) {
        Usuario usuarioParaDeletar = retornarPorId(idUsuario);
        usuarioRepository.delete(usuarioParaDeletar);
    }
}
