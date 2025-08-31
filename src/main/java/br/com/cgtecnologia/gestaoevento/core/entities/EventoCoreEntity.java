package br.com.cgtecnologia.gestaoevento.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EventoCoreEntity {
    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime dataHoraEvento;
    private String local;
    private int capacidade;
    private boolean ativo;
}
