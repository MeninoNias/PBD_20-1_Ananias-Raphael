package com.pbd.sertaoprotocolo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "institucaos")
public class Institucao extends AbstractEntity<Long>{

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(name = "ativo")
    private boolean ativo = true;

    @Column(name = "bloqueado")
    private boolean bloqueado = false;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk")
    private Endereco endereco;

    @OneToMany(mappedBy = "institucao")
    private List<Setor> setores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
