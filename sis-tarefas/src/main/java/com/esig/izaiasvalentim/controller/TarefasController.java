package com.esig.izaiasvalentim.controller;

import com.esig.izaiasvalentim.domain.entity.Tarefa;
import com.esig.izaiasvalentim.domain.entity.Usuario;
import com.esig.izaiasvalentim.domain.entity.enums.PrioridadeTarefaEnum;
import com.esig.izaiasvalentim.domain.entity.enums.SituacaoTarefaEnum;
import com.esig.izaiasvalentim.service.tarefas.TarefasService;
import com.esig.izaiasvalentim.service.usuario.UsuarioServiceImp;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.model.FilterMeta;

import java.io.Serializable;
import java.util.List;

@Named(value = "tarefasBean")
@ViewScoped
public class TarefasController implements Serializable {
    @EJB
    private TarefasService tarefasService;
    @EJB
    UsuarioServiceImp usuarioService;

    private Tarefa tarefa;
    private List<Tarefa> tarefas;
    private Long idTarefa;
    private List<PrioridadeTarefaEnum> listaDePrioridades;
    private List<SituacaoTarefaEnum> listaDeSituacao;

    private List<FilterMeta> filterBy;
    private List<Tarefa> tarefasFiltradas;

    private Long idUsuario;
    private List<Usuario> listaDeUsuarios;


    @PostConstruct
    public void init() {

        tarefa = new Tarefa();
        tarefas = listarTodasTarefas();

        listaDePrioridades = PrioridadeTarefaEnum.obterListaPrioridadeTarefa();
        listaDeSituacao = SituacaoTarefaEnum.obterListaSituacaoTarefa();

        listaDeUsuarios = usuarioService.todos();

        String idParam = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("idTarefa");

        if (idParam != null && !idParam.isEmpty()) {
            this.idTarefa = Long.parseLong(idParam);
            this.tarefa = tarefasService.buscarTarefaPorId(this.idTarefa);
            idUsuario = tarefa.getUsuario().getId();
        }
    }

    public void novaTarefa() {
        tarefa = new Tarefa();
        idUsuario = null;
    }

    public void salvarTarefa() {
        try {
            Usuario usuario = usuarioService.retornarPorId(idUsuario);
            tarefa.setUsuario(usuario);
            tarefasService.criarTarefa(tarefa);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Tarefa criada com sucesso!"));

            novaTarefa();
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao criar tarefa!", e.getMessage()));
        }
    }

    public List<Tarefa> listarTodasTarefas() {
        return tarefas = tarefasService.listarTodasTarefas();
    }

    public void editarTarefa() {
        try {
            Usuario usuario = usuarioService.retornarPorId(tarefa.getUsuario().getId());
            tarefa.setUsuario(usuario);
            tarefa.setSituacao(SituacaoTarefaEnum.CONCLUIDA);
            tarefa.setEstaFinalizada(false);
            tarefasService.atualizarTarefa(tarefa);

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Tarefa editada com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
        }
    }

    public void excluirTarefa() {
        try {
            tarefa = tarefasService.buscarTarefaPorId(idTarefa);
            tarefasService.excluirTarefa(tarefa);

            listarTodasTarefas();
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Tarefa Excluída com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir tarefa :/", e.getMessage()));
        }
        idTarefa = null;
    }

    public void finalizarTarefa() {
        try {
            tarefa = tarefasService.buscarTarefaPorId(idTarefa);
            tarefa.setSituacao(SituacaoTarefaEnum.CONCLUIDA);
            tarefa.setEstaFinalizada(true);
            tarefasService.atualizarTarefa(tarefa);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Tarefa Finalizada com sucesso!"));
            idTarefa = null;
            listarTodasTarefas();
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
        }

    }

    public TarefasService getTarefasService() {
        return tarefasService;
    }

    public void setTarefasService(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    public UsuarioServiceImp getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioServiceImp usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }

    public List<PrioridadeTarefaEnum> getListaDePrioridades() {
        return listaDePrioridades;
    }

    public void setListaDePrioridades(List<PrioridadeTarefaEnum> listaDePrioridades) {
        this.listaDePrioridades = listaDePrioridades;
    }

    public List<SituacaoTarefaEnum> getListaDeSituacao() {
        return listaDeSituacao;
    }

    public void setListaDeSituacao(List<SituacaoTarefaEnum> listaDeSituacao) {
        this.listaDeSituacao = listaDeSituacao;
    }

    public List<FilterMeta> getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(List<FilterMeta> filterBy) {
        this.filterBy = filterBy;
    }

    public List<Tarefa> getTarefasFiltradas() {
        return tarefasFiltradas;
    }

    public void setTarefasFiltradas(List<Tarefa> tarefasFiltradas) {
        this.tarefasFiltradas = tarefasFiltradas;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public void setListaDeUsuarios(List<Usuario> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }
}
