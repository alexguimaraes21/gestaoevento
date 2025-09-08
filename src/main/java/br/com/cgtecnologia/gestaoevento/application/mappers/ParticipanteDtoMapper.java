package br.com.cgtecnologia.gestaoevento.application.mappers;

import br.com.cgtecnologia.gestaoevento.application.dtos.in.ParticipanteDtoIn;
import br.com.cgtecnologia.gestaoevento.application.dtos.out.ParticipanteDtoOut;
import br.com.cgtecnologia.gestaoevento.core.entities.ParticipanteCoreEntity;

public class ParticipanteDtoMapper {

    public static ParticipanteCoreEntity toCoreEntity(ParticipanteDtoIn participanteDtoIn) {
        return ParticipanteCoreEntity.builder()
                .nome(participanteDtoIn.nome())
                .email(participanteDtoIn.email())
                .build();
    }

    public static ParticipanteDtoOut toDtoOut(ParticipanteCoreEntity entity) {
        return new ParticipanteDtoOut(entity);
    }

    private ParticipanteDtoMapper() {}
}
