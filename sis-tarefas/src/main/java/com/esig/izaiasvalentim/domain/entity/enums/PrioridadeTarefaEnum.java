package com.esig.izaiasvalentim.domain.entity.enums;

import java.util.ArrayList;
import java.util.List;

public enum PrioridadeTarefaEnum {
    ALTA(1),
    MEDIA(2),
    BAIXA(3);

    private final int valor;

    PrioridadeTarefaEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static PrioridadeTarefaEnum fromInt(int i) {
        for (PrioridadeTarefaEnum p : PrioridadeTarefaEnum.values()) {
            if (p.getValor() == i) {
                return p;
            }
        }
        return null;
    }

    public static List<PrioridadeTarefaEnum> obterListaPrioridadeTarefa() {
        List<PrioridadeTarefaEnum> listaPrioridadeTarefa = new ArrayList<>();
        for (PrioridadeTarefaEnum p : PrioridadeTarefaEnum.values()) {
            listaPrioridadeTarefa.add(p);
        }
        return listaPrioridadeTarefa;
    }
}

