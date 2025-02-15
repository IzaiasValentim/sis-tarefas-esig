package com.esig.izaiasvalentim.domain.entity;

import com.esig.izaiasvalentim.domain.entity.enums.PrioridadeTarefaEnum;
import com.esig.izaiasvalentim.domain.entity.enums.SituacaoTarefaEnum;
import com.esig.izaiasvalentim.uteis.TimeUtils;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "TAREFAS")
@Table(name = "TAREFAS")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private PrioridadeTarefaEnum prioridade;
    @Enumerated(EnumType.STRING)
    private SituacaoTarefaEnum situacao;
    private LocalDate dataInicio;
    private LocalDate dataFinalizacao;
    private Boolean estaFinalizada;
    @Transient
    private Integer diasAteFinalizar;
    private Boolean estaDeletada;

    public Tarefa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PrioridadeTarefaEnum getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeTarefaEnum prioridade) {
        this.prioridade = prioridade;
    }

    public SituacaoTarefaEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoTarefaEnum situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDate dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public Integer getDiasAteFinalizar() {
        return TimeUtils.diasAteFinalizarTarefa(this);
    }

    public Boolean getEstaFinalizada() {
        return estaFinalizada;
    }

    public void setEstaFinalizada(Boolean estaFinalizada) {
        this.estaFinalizada = estaFinalizada;
    }

    public Boolean getEstaDeletada() {
        return estaDeletada;
    }

    public void setEstaDeletada(Boolean estaDeletada) {
        this.estaDeletada = estaDeletada;
    }
}
