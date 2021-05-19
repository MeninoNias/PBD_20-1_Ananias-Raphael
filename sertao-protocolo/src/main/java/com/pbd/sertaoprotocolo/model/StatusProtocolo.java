package com.pbd.sertaoprotocolo.model;

public enum StatusProtocolo {

    PE("PE", "PENDENTE"),
    AN("AN", "ANALIZE"),
    RE("RE", "RESPONDIDO"),
    CA("CA", "CANCELADO");

    private String sigla;
    private String descricao;

    StatusProtocolo(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

}
