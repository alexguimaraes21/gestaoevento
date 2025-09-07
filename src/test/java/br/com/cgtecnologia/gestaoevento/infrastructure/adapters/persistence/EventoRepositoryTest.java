package br.com.cgtecnologia.gestaoevento.infrastructure.adapters.persistence;

import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.ports.out.IEventoRepositoryPort;
import br.com.cgtecnologia.gestaoevento.infrastructure.adapters.persistence.repositories.EventoJpaRepository;
import br.com.cgtecnologia.gestaoevento.infrastructure.adapters.persistence.repositories.EventoRepositoryPortImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
public class EventoRepositoryTest {

    @Autowired
    private EventoJpaRepository eventoJpaRepository;

    private EventoRepositoryPortImpl repository;

    @Test
    void deveSalvarEventoNoBanco() {
        // Inicializa o repository com o JpaRepository real
        repository = new EventoRepositoryPortImpl(eventoJpaRepository);

        EventoCoreEntity evento = EventoCoreEntity.builder()
                .nome("Evento Teste")
                .ativo(true)
                .dataHoraEvento(LocalDateTime.now())
                .capacidade(100)
                .descricao("Evento Teste")
                .local("Local do Evento")
                .build();

        // Salva
        EventoCoreEntity salvo = repository.save(evento);

        Assertions.assertNotNull(salvo.getId());
        Assertions.assertEquals("Evento Teste", salvo.getNome());
    }

    @Test
    void deveDeletarEvento() {
        repository = new EventoRepositoryPortImpl(eventoJpaRepository);

        EventoCoreEntity evento = EventoCoreEntity.builder()
                .nome("Evento Delete")
                .ativo(true)
                .dataHoraEvento(LocalDateTime.now())
                .capacidade(50)
                .descricao("Evento Delete")
                .local("Local Delete")
                .build();

        EventoCoreEntity salvo = repository.save(evento);

        // Deleta
        repository.deleteById(salvo.getId());

        Optional<EventoCoreEntity> recuperado = repository.getById(salvo.getId());
        Assertions.assertFalse(recuperado.isPresent());
    }
}
