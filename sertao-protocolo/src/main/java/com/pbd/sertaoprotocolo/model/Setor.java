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
    @JoinColumn(name = "id_institucao_fk")
    private Institucao institucao;

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

    public Institucao getInstitucao() {
        return institucao;
    }

    public void setInstitucao(Institucao institucao) {
        this.institucao = institucao;
    }
}
