package br.com.cgtecnologia.gestaoevento.application.mappers;

import br.com.cgtecnologia.gestaoevento.application.dtos.in.EventoDtoIn;
import br.com.cgtecnologia.gestaoevento.application.dtos.out.EventoDtoOut;
import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;

public class EventoDtoMapper {

    public static EventoCoreEntity toCoreEntity(EventoDtoIn eventoDtoIn) {
        return EventoCoreEntity.builder()
                .nome(eventoDtoIn.nome())
                .descricao(eventoDtoIn.descricao())
                .dataHoraEvento(eventoDtoIn.dataHoraEvento())
                .local(eventoDtoIn.local())
                .capacidade(eventoDtoIn.capacidade())
                .ativo(eventoDtoIn.ativo())
                .build();
    }

    public static EventoDtoOut toDtoOut(EventoCoreEntity eventoCoreEntity) {
        return new EventoDtoOut(eventoCoreEntity);
    }

    private EventoDtoMapper() {}
}
