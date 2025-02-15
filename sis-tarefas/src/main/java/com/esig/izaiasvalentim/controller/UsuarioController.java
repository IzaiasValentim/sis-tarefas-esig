package com.esig.izaiasvalentim.controller;

import com.esig.izaiasvalentim.domain.entity.Usuario;
import com.esig.izaiasvalentim.service.usuario.UsuarioServiceImp;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named(value = "usuariosBean")
@ViewScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioServiceImp usuarioService;

    private List<Usuario> usuarios;

    private Usuario usuario = new Usuario();

    public List<Usuario> getUsuarios() {
        return usuarios = usuarioService.todos();
    }

    private Long idUsuario;

    public void novo() {
        usuario = new Usuario();
    }

    public void salvar() {
        usuarioService.salvar(usuario);
        novo();
    }

    public void excluir() {
        usuarioService.remover(idUsuario);
        idUsuario = null;
    }

    public UsuarioServiceImp getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioServiceImp usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
