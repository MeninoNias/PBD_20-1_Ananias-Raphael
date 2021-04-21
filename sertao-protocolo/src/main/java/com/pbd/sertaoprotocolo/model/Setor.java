package com.pbd.sertaoprotocolo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "setores")
public class Setor extends AbstractEntity<Long>{

    @Column(name = "nome")
    private String nome;

    @Column(name = "ativo")
    private boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "id_instituicao_fk")
    private Instituicao institucao;

    @OneToMany(mappedBy = "setor")
    private List<SubSetor> subSetors;

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

    public Instituicao getInstitucao() {
        return institucao;
    }

    public void setInstitucao(Instituicao institucao) {
        this.institucao = institucao;
    }
}
