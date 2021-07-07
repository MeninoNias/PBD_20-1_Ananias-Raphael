package com.pbd.sertaoprotocolo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
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

    public Log(User user) {
        this.user = user;
    }
}
