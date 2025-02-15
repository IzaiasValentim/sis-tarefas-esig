package com.esig.izaiasvalentim.domain.entity.enums;

import java.util.ArrayList;
import java.util.List;

public enum SituacaoTarefaEnum {
    PENDENTE(1),
    EM_ANDAMENTO(2),
    PAUSADA(3),
    FINALIZADA(4),
    CANCELADA(5);

    private final int valorSituacao;

    SituacaoTarefaEnum(int valorSituacao) {
        this.valorSituacao = valorSituacao;
    }

    public int getValorSituacao() {
        return valorSituacao;
    }

    public static SituacaoTarefaEnum fromInt(int i) {
        for (SituacaoTarefaEnum s : SituacaoTarefaEnum.values()) {
            if (s.getValorSituacao() == i) {
                return s;
            }
        }
        return null;
    }

    public static List<SituacaoTarefaEnum> obterListaSituacaoTarefa() {
        List<SituacaoTarefaEnum> todasSituacoes = new ArrayList<SituacaoTarefaEnum>();
        for (SituacaoTarefaEnum s : SituacaoTarefaEnum.values()) {
            todasSituacoes.add(s);
        }
        return todasSituacoes;
    }
}
