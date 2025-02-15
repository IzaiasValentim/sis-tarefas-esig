package com.esig.izaiasvalentim.uteis;

import com.esig.izaiasvalentim.domain.entity.Tarefa;

import java.time.temporal.ChronoUnit;

public class TimeUtils {
    public static Integer diasAteFinalizarTarefa(Tarefa tarefa) {
        if (tarefa == null || tarefa.getDataInicio() == null || tarefa.getDataFinalizacao() == null) {
            return 0;
        }

        return (int) ChronoUnit.DAYS.between(tarefa.getDataInicio(), tarefa.getDataFinalizacao());
    }
}
