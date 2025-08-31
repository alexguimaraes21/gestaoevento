package br.com.cgtecnologia.gestaoevento.infrastructure.adapters.web.configs;

import br.com.cgtecnologia.gestaoevento.application.services.EventoService;
import br.com.cgtecnologia.gestaoevento.core.ports.out.IEventoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependenciesConfig {

    private final IEventoRepository eventoRepository;

    public DependenciesConfig(IEventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Bean
    public EventoService getEventoService(IEventoRepository eventoRepository) {
        return new EventoService(eventoRepository);
    }
}
