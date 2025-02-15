package com.esig.izaiasvalentim.service.usuario;

import com.esig.izaiasvalentim.domain.entity.Usuario;
import com.esig.izaiasvalentim.domain.repository.repositories.UsuarioRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class UsuarioServiceImp {

    @EJB
    private UsuarioRepository usuarioRepository;

    public Usuario retornarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public void remover(Long idUsuario) {
        Usuario usuarioParaDeletar = retornarPorId(idUsuario);
        usuarioRepository.delete(usuarioParaDeletar);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> todos() {
        return usuarioRepository.findAll();
    }
}
