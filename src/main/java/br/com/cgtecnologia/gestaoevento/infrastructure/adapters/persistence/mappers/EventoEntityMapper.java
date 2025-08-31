package br.com.cgtecnologia.gestaoevento.infrastructure.adapters.persistence.mappers;

import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;
import br.com.cgtecnologia.gestaoevento.infrastructure.adapters.persistence.entities.EventoJpaEntity;

public class EventoEntityMapper {

    public static EventoJpaEntity toJpaEntity(EventoCoreEntity coreEntity) {
        return EventoJpaEntity.builder()
                .id(coreEntity.getId())
                .nome(coreEntity.getNome())
                .descricao(coreEntity.getDescricao())
                .dataEvento(coreEntity.getDataHoraEvento())
                .local(coreEntity.getLocal())
                .capacidade(coreEntity.getCapacidade())
                .ativo(coreEntity.isAtivo())
                .build();
    }

    public static EventoCoreEntity toCoreEntity(EventoJpaEntity jpaEntity) {
        return EventoCoreEntity.builder()
                .id(jpaEntity.getId())
                .nome(jpaEntity.getNome())
                .descricao(jpaEntity.getDescricao())
                .dataHoraEvento(jpaEntity.getDataEvento())
                .local(jpaEntity.getLocal())
                .capacidade(jpaEntity.getCapacidade())
                .ativo(jpaEntity.isAtivo())
                .build();
    }

    private EventoEntityMapper() {}
}
