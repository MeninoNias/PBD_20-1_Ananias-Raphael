package com.pbd.sertaoprotocolo.model;

import javax.persistence.*;

@Entity
@Table(name = "cidades")
public class Cidade extends AbstractEntity<Long> {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private UF uf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }
}
