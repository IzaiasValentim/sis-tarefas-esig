package com.esig.izaiasvalentim.controller;

import com.esig.izaiasvalentim.domain.entity.Tarefa;
import com.esig.izaiasvalentim.domain.entity.Usuario;
import com.esig.izaiasvalentim.domain.entity.enums.PrioridadeTarefaEnum;
import com.esig.izaiasvalentim.domain.entity.enums.SituacaoTarefaEnum;
import com.esig.izaiasvalentim.domain.repository.repositories.TarefasRepository;
import com.esig.izaiasvalentim.service.tarefas.TarefasService;
import com.esig.izaiasvalentim.service.usuario.UsuarioServiceImp;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.model.FilterMeta;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.logging.Logger;

@Named(value = "tarefasBean")
@ViewScoped
public class TarefasController implements Serializable {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @EJB
    private TarefasService tarefasService;
    @EJB
    UsuarioServiceImp usuarioService;
    @EJB
    TarefasRepository tarefasRepository;

    private List<Tarefa> tarefas;

    private Tarefa tarefa = new Tarefa();

    private Long idUsuario;

    private Long idTarefa;

    private List<PrioridadeTarefaEnum> listaDePrioridades = PrioridadeTarefaEnum.obterListaPrioridadeTarefa();
    private List<SituacaoTarefaEnum> listaDeSituacao = SituacaoTarefaEnum.obterListaSituacaoTarefa();

    private List<Usuario> listaDeUsuarios;

    private List<FilterMeta> filterBy;

    private List<Tarefa> tarefasFiltradas;

    @PostConstruct
    public void init() {

        tarefas = listarTodasTarefas();
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

    public List<PrioridadeTarefaEnum> getListaDePrioridades() {
        return listaDePrioridades;
    }

    public void novaTarefa() {
        tarefa = new Tarefa();
        idUsuario = null;
    }

    public List<Tarefa> listarTodasTarefas() {
        return tarefas = tarefasService.listarTodasTarefas();
    }

    public void salvarTarefa() {
        try {
            Usuario usuario = usuarioService.retornarPorId(idUsuario);
            tarefa.setUsuario(usuario);
            tarefa.setSituacao(SituacaoTarefaEnum.PENDENTE);
            tarefa.setEstaFinalizada(false);
            tarefa.setEstaDeletada(false);
            tarefasService.criarTarefa(tarefa);

            novaTarefa();
        } catch (Exception e) {
            logger.severe("Erro ao salvar a tarefa: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void editarTarefa() {
        Usuario usuario = usuarioService.retornarPorId(tarefa.getUsuario().getId());
        tarefa.setUsuario(usuario);
        tarefa.setSituacao(SituacaoTarefaEnum.PENDENTE);
        tarefa.setEstaFinalizada(false);
        tarefasService.atualizarTarefa(tarefa);
    }

    public void finalizarTarefa() {
        tarefa = tarefasService.buscarTarefaPorId(idTarefa);
        tarefa.setSituacao(SituacaoTarefaEnum.FINALIZADA);
        tarefa.setEstaFinalizada(true);
        tarefasService.atualizarTarefa(tarefa);
        idTarefa = null;
        listarTodasTarefas();
    }

    public void excluirTarefa() {
        tarefa = tarefasService.buscarTarefaPorId(idTarefa);
        tarefasService.excluirTarefa(tarefa);
        idTarefa = null;
        listarTodasTarefas();
    }

    public TarefasService getTarefasService() {
        return tarefasService;
    }

    public void setTarefasService(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    public TarefasRepository getTarefasRepository() {
        return tarefasRepository;
    }

    public void setTarefasRepository(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }

    public UsuarioServiceImp getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioServiceImp usuarioService) {
        this.usuarioService = usuarioService;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
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

    public List<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public void setListaDeUsuarios(List<Usuario> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
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
}
