package br.com.cgtecnologia.gestaoevento.application.services;


import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.ports.in.IEventoService;
import br.com.cgtecnologia.gestaoevento.core.ports.out.IEventoRepositoryPort;

public class EventoService extends GenericService<EventoCoreEntity, Long, IEventoRepositoryPort> implements IEventoService {

    public EventoService (IEventoRepositoryPort repository) {
        super(repository);
    }
}
