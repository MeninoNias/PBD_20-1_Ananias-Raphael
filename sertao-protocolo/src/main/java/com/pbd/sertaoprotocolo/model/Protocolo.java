package com.pbd.sertaoprotocolo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Protocolo extends AbstractEntity<Long> {

    @Column(name = "n_protolo")
    @NotEmpty(message = "Erro ao gerar o numero do protocolo")
    private String nProtocolo;

    @Column(name = "assunto", length = 120)
    @NotEmpty(message = "*Por favor, preencha o campo assunto")
    private String assunto;


    @Column(name = "descricao")
    @NotEmpty(message = "*Por favor, preencha o campo descrição")
    @Lob
    private String descricao;

    @Column(name = "inicio")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataInicio;

    @Column(name = "fim")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataFim;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_funcionario_fk")
    private Funcionario funcionario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categoria_fk")
    private CategoriaProtocolo categoria;

}
