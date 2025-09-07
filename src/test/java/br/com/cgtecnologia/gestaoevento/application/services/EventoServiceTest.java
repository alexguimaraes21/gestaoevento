package br.com.cgtecnologia.gestaoevento.application.services;

import br.com.cgtecnologia.gestaoevento.application.dtos.out.EventoDtoOut;
import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.ports.out.IEventoRepositoryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class EventoServiceTest {

    @Mock
    private IEventoRepositoryPort eventoRepositoryPort;

    @InjectMocks
    private EventoService eventoService;

    @Test
    void deveListarEventos() {
        Mockito.when(eventoRepositoryPort.getAll())
                .thenReturn(List.of(EventoCoreEntity.builder()
                        .id(1L)
                        .nome("Evento Teste")
                        .ativo(true)
                        .dataHoraEvento(LocalDateTime.now())
                        .capacidade(100)
                        .descricao("Evento Teste")
                        .local("Local do Evento")
                        .build()));

        List<EventoCoreEntity> eventos = eventoService.getAll();

        Assertions.assertEquals(1, eventos.size());
        Assertions.assertEquals("Evento Teste", eventos.get(0).getNome());

        Mockito.verify(eventoRepositoryPort, Mockito.times(1)).getAll();
    }
}
