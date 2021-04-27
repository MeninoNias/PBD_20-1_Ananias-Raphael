package com.pbd.sertaoprotocolo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionarios")
public class Funcionario extends AbstractEntity<Long> {

    @Column(name = "nome")
    @NotEmpty(message = "*Por favor, preencha o campo nome")
    private String nome;

    @NotEmpty(message = "*Por favor, preencha o campo matricula")
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "id_user_fk")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_cargo_fk")
    private Cargo cargo;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "id_subsetor_fk")
    private SubSetor lotacao;


}
