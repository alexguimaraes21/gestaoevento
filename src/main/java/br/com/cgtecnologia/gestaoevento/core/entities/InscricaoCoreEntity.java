package br.com.cgtecnologia.gestaoevento.core.entities;

import br.com.cgtecnologia.gestaoevento.core.enums.TipoStatusInscricaoParticipanteEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InscricaoCoreEntity {
    private Long id;
    private EventoCoreEntity evento;
    private ParticipanteCoreEntity participante;
    private LocalDateTime dataInscricao;
    private TipoStatusInscricaoParticipanteEnum status;
}
