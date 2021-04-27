package com.pbd.sertaoprotocolo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(mappedBy = "lotacao")
    private List<Funcionario> funcionarios;

}
