package com.pbd.sertaoprotocolo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cargos")
public class Cargo extends AbstractEntity<Long>{

    @Column(name = "nome", unique = true, nullable = false)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
