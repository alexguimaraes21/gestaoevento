package br.com.cgtecnologia.gestaoevento.application.mappers;

import br.com.cgtecnologia.gestaoevento.application.dtos.in.EventoDtoIn;
import br.com.cgtecnologia.gestaoevento.application.dtos.out.EventoDtoOut;
import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.enums.TipoStatusInscricaoEventoEnum;

public class EventoDtoMapper {

    public static EventoCoreEntity toCoreEntity(EventoDtoIn eventoDtoIn) {
        return EventoCoreEntity.builder()
                .nome(eventoDtoIn.nome())
                .descricao(eventoDtoIn.descricao())
                .dataHoraEvento(eventoDtoIn.dataHoraEvento())
                .local(eventoDtoIn.local())
                .capacidade(eventoDtoIn.capacidade())
                .ativo(eventoDtoIn.ativo())
                .statusInscricao(TipoStatusInscricaoEventoEnum.ABERTA)
                .build();
    }

    public static EventoDtoOut toDtoOut(EventoCoreEntity eventoCoreEntity) {
        return new EventoDtoOut(eventoCoreEntity);
    }

    private EventoDtoMapper() {}
}
