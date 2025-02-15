package com.esig.izaiasvalentim.controller;

import com.esig.izaiasvalentim.domain.entity.Usuario;
import com.esig.izaiasvalentim.service.usuario.UsuarioServiceImp;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

@Named(value = "usuariosBean")
@ViewScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioServiceImp usuarioService;
    private Usuario usuario;
    private List<Usuario> usuarios;
    private Long idUsuario;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        usuarios = usuarioService.todos();
    }

    public void novo() {
        usuario = new Usuario();
    }

    public void salvar() {
        try {
            usuarioService.salvar(usuario);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(
                                    FacesMessage.SEVERITY_INFO, "Sucesso", usuario.toString() + " foi cadastrado com sucesso!"));
            novo();
        } catch (PersistenceException violationException) {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR, "Erro ao adicionar usuário", violationException.getMessage()));
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR, "Erro ao criar usuário :/", e.getMessage()));
        }
    }

    public void excluir() {
        try {
            usuarioService.remover(idUsuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Sucesso", "Usuário removido com sucesso!"));
            idUsuario = null;

        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR, "Erro ao remover usuário :/", e.getMessage()));
        }
    }

    public UsuarioServiceImp getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioServiceImp usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios = usuarioService.todos();
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
