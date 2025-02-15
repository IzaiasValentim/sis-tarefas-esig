package com.esig.izaiasvalentim.service.tarefas;

import com.esig.izaiasvalentim.domain.entity.Tarefa;
import com.esig.izaiasvalentim.domain.entity.enums.SituacaoTarefaEnum;
import com.esig.izaiasvalentim.domain.repository.repositories.TarefasRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.transaction.Transactional;

import java.util.List;

@Stateless
public class TarefasService {
    @EJB
    private TarefasRepository tarefasRepository;

    @Transactional
    public void criarTarefa(Tarefa tarefa) {

        tarefa.setSituacao(SituacaoTarefaEnum.EM_ANDAMENTO);
        tarefa.setEstaFinalizada(false);
        tarefa.setEstaDeletada(false);
        this.tarefasRepository.save(tarefa);
    }

    @Transactional
    public Tarefa atualizarTarefa(Tarefa updateTarefa) {
        return this.tarefasRepository.update(updateTarefa);
    }

    public Tarefa buscarTarefaPorId(Long id) {
        return (Tarefa) tarefasRepository.findById(id);
    }

    public List<Tarefa> listarTodasTarefas() {
        return tarefasRepository.findAll();
    }

    @Transactional
    public void excluirTarefa(Tarefa tarefa) {
        this.tarefasRepository.delete(tarefa);
    }


}
