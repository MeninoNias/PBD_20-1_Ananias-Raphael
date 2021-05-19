package com.pbd.sertaoprotocolo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RespostaProtocolo extends AbstractEntity<Long>{

    @Column(name = "resposta")
    @Lob
    private String resposta;

    @Column(name = "data_resposta")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataResposta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_protocolo_fk")
    private Protocolo protocolo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_id_fk")
    private Funcionario funcionarioResponsavel ;

}
