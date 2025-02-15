package com.esig.izaiasvalentim.service.tarefas;

import com.esig.izaiasvalentim.domain.entity.Tarefa;
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
    public void excluirTarefa(Tarefa tarefa) {
        this.tarefasRepository.delete(tarefa);
    }

    public Tarefa buscarTarefaPorId(Long id) {
        return (Tarefa) tarefasRepository.findById(id);
    }

    public List<Tarefa> listarTodasTarefas() {
        return tarefasRepository.findAll();
    }

    public Tarefa atualizarTarefa(Tarefa updateTarefa) {
        return (Tarefa) tarefasRepository.update(updateTarefa);
    }

    public void criarTarefa(Tarefa tarefa) {
        this.tarefasRepository.save(tarefa);
    }
}
