package br.com.cgtecnologia.gestaoevento.application.dtos.out;

import br.com.cgtecnologia.gestaoevento.core.entities.ParticipanteCoreEntity;

public record ParticipanteDtoOut(
        Long id,
        String nome,
        String email) {

    public ParticipanteDtoOut(ParticipanteCoreEntity entity) {
        this(entity.getId(), entity.getNome(), entity.getEmail());
    }
}
