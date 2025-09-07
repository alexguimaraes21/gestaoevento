package br.com.cgtecnologia.gestaoevento.infrastructure.adapters.web;

import br.com.cgtecnologia.gestaoevento.application.services.EventoService;
import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;
import br.com.cgtecnologia.gestaoevento.infrastructure.adapters.web.resources.EventoResource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.List;

@WebMvcTest(controllers = EventoResource.class)
@ActiveProfiles("test")
public class EventoResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventoService eventoService;

    @Test
    void deveRetornarListaDeEventos() throws Exception {
        Mockito.when(eventoService.getAll())
                .thenReturn(List.of(EventoCoreEntity.builder()
                        .id(1L)
                        .nome("Evento Teste")
                        .ativo(true)
                        .dataHoraEvento(LocalDateTime.now())
                        .capacidade(100)
                        .descricao("Evento Teste")
                        .local("Local do Evento")
                        .build()));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/evento"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Evento Teste"));
    }
}
