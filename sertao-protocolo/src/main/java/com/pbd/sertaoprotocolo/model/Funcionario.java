package com.pbd.sertaoprotocolo.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Builder
@Getter
@Setter
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

    @Length(min = 10, max = 11, message = "*Formato de telefone invalido")
    private String telefone;

    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "funcionarioResponsavel", cascade = CascadeType.ALL)
    @JoinColumn(name = "resposta_protocolo_id")
    private RespostaProtocolo respostaProtocolo;

    @ManyToOne
    @JoinColumn(name = "id_cargo_fk")
    private Cargo cargo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "id_subsetor_fk")
    private SubSetor lotacao;

    @OneToMany(mappedBy = "funcionario")
    private List<Protocolo> protocolos;

}
