package com.pbd.sertaoprotocolo.model;

import javax.persistence.*;

@Entity
@Table(name = "sub_setores")
public class SubSetor extends AbstractEntity<Long> {

    @Column(name = "nome")
    private String nome;

    @Column(name = "ativo")
    private boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "id_setor_fk")
    private Setor setor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
