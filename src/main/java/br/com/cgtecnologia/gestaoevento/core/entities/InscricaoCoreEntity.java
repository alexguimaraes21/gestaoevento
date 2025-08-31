package br.com.cgtecnologia.gestaoevento.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InscricaoCoreEntity {
    private UUID id;
    private EventoCoreEntity evento;
    private ParticipanteCoreEntity participante;
    private LocalDateTime dataInscricao;
    private String status;
}
