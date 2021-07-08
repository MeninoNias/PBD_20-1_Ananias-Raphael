package com.pbd.sertaoprotocolo.model;

public enum Operacoes {

    IN("IN", "CRIOU"),
    DE("DE", "DELETOU"),
    UP("UP", "ATUALIZOU"),
    RE("RE", "VIZUALIZOU"),
    LO("LO", "LOGIN");


    private String sigla;
    private String descricao;

    Operacoes(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }
}
