package br.com.cgtecnologia.gestaoevento.application.services;

import br.com.cgtecnologia.gestaoevento.core.entities.ParticipanteCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.ports.in.IParticipanteService;
import br.com.cgtecnologia.gestaoevento.core.ports.out.IParticipanteRepositoryPort;

public class ParticipanteService extends GenericService<ParticipanteCoreEntity, Long, IParticipanteRepositoryPort> implements IParticipanteService {
}
