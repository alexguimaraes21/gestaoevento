package br.com.cgtecnologia.gestaoevento.application.services;

import br.com.cgtecnologia.gestaoevento.core.entities.InscricaoCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.ports.in.IInscricaoService;
import br.com.cgtecnologia.gestaoevento.core.ports.out.IInscricaoRepositoryPort;

public class InscricaoService extends GenericService<InscricaoCoreEntity, Long, IInscricaoRepositoryPort> implements IInscricaoService {
}
