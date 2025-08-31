package br.com.cgtecnologia.gestaoevento.infrastructure.adapters.persistence.repositories;

import br.com.cgtecnologia.gestaoevento.infrastructure.adapters.persistence.entities.EventoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoJpaRepository extends JpaRepository<EventoJpaEntity, Long> {
}
