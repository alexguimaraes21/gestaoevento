package br.com.cgtecnologia.gestaoevento.application.services;


import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.ports.in.IEventoService;
import br.com.cgtecnologia.gestaoevento.core.ports.out.IEventoRepository;

public class EventoService extends GenericService<EventoCoreEntity, Long, IEventoRepository> implements IEventoService {

    public EventoService (IEventoRepository repository) {
        super(repository);
    }
}
