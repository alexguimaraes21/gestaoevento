package br.com.cgtecnologia.gestaoevento.infrastructure.adapters.persistence.repositories;

import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.ports.out.IEventoRepositoryPort;
import br.com.cgtecnologia.gestaoevento.infrastructure.adapters.persistence.entities.EventoJpaEntity;
import br.com.cgtecnologia.gestaoevento.infrastructure.adapters.persistence.mappers.EventoEntityMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EventoRepositoryPortImpl extends GenericRepositoryPort<EventoCoreEntity, Long, EventoJpaEntity> implements IEventoRepositoryPort {

    private final EventoJpaRepository eventoJpaRepository;

    public EventoRepositoryPortImpl(EventoJpaRepository eventoJpaRepository) {
        this.eventoJpaRepository = eventoJpaRepository;
    }

    @Override
    protected JpaRepository<EventoJpaEntity, Long> getJpaRepository() {
        return this.eventoJpaRepository;
    }

    @Override
    protected EventoJpaEntity toJpaEntity(EventoCoreEntity coreEntity) {
        return EventoEntityMapper.toJpaEntity(coreEntity);
    }

    @Override
    protected EventoCoreEntity toCoreEntity(EventoJpaEntity jpaEntity) {
        return EventoEntityMapper.toCoreEntity(jpaEntity);
    }
}
