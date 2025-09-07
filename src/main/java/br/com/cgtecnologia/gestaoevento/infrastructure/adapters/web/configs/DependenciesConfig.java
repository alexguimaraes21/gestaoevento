package br.com.cgtecnologia.gestaoevento.infrastructure.adapters.web.configs;

import br.com.cgtecnologia.gestaoevento.application.services.EventoService;
import br.com.cgtecnologia.gestaoevento.core.ports.out.IEventoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependenciesConfig {

    private final IEventoRepositoryPort eventoRepository;

    public DependenciesConfig(IEventoRepositoryPort eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Bean
    public EventoService getEventoService(IEventoRepositoryPort eventoRepository) {
        return new EventoService(eventoRepository);
    }
}
