package br.com.cgtecnologia.gestaoevento.application.dtos.out;

import br.com.cgtecnologia.gestaoevento.core.entities.InscricaoCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.enums.TipoStatusInscricaoParticipanteEnum;

import java.time.LocalDateTime;

public record InscricaoDtoOut(
        Long id,
        EventoDtoOut evento,
        ParticipanteDtoOut participante,
        LocalDateTime dataInscricao,
        TipoStatusInscricaoParticipanteEnum status) {

    public InscricaoDtoOut(InscricaoCoreEntity entity) {
        this(entity.getId(), new EventoDtoOut(entity.getEvento()), new ParticipanteDtoOut(entity.getParticipante()),
                entity.getDataInscricao(), entity.getStatus());
    }
}
