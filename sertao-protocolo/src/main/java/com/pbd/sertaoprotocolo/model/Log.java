package com.pbd.sertaoprotocolo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@NoArgsConstructor
@Entity
public class Log extends AbstractEntity<Long> {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_fk")
    private User user;

    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private Operacoes operacoes;

    private String descricao;

    public Log(User user, String descricao, Operacoes operacoes) {
        this.user = user;
        this.descricao = descricao;
        this.operacoes = operacoes;
    }

    public String getLog(){
        return getId()+ " - "+ user.getUserName() + " - " + operacoes.getDescricao()+ " | " + descricao;
    }
}
