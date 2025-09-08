package br.com.cgtecnologia.gestaoevento.core.entities;

import br.com.cgtecnologia.gestaoevento.core.enums.TipoStatusInscricaoEventoEnum;
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
    private TipoStatusInscricaoEventoEnum statusInscricao;
}
