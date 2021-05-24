package com.pbd.sertaoprotocolo.model;

public enum StatusProtocolo {

    PE("PE", "PENDENTE"),
    AN("AN", "EM ANALISE"),
    RE("RE", "RESPONDIDO"),
    CA("CA", "CANCELADO");

    private String sigla;
    private String descricao;

    StatusProtocolo(String sigla, String descricao) {
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
