package br.com.cgtecnologia.gestaoevento.application.mappers;

import br.com.cgtecnologia.gestaoevento.application.dtos.in.InscricaoDtoIn;
import br.com.cgtecnologia.gestaoevento.application.dtos.out.InscricaoDtoOut;
import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.entities.InscricaoCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.entities.ParticipanteCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.enums.TipoStatusInscricaoParticipanteEnum;

import java.time.LocalDateTime;

public class InscricaoDtoMapper {

    public static InscricaoCoreEntity toCoreEntity(InscricaoDtoIn inscricaoDtoIn) {
        return InscricaoCoreEntity.builder()
                .evento(EventoCoreEntity.builder().id(inscricaoDtoIn.cdEvento()).build())
                .participante(ParticipanteCoreEntity.builder()
                        .nome(inscricaoDtoIn.participante().nome())
                        .email(inscricaoDtoIn.participante().email())
                        .build())
                .dataInscricao(LocalDateTime.now())
                .status(TipoStatusInscricaoParticipanteEnum.INSCRITO)
                .build();
    }

    public static InscricaoDtoOut toDtoOut(InscricaoCoreEntity entity) {
        return new InscricaoDtoOut(entity);
    }

    private InscricaoDtoMapper() {}
}
