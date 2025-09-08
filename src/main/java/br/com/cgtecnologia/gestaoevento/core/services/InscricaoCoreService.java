package br.com.cgtecnologia.gestaoevento.core.services;

import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;

public class InscricaoCoreService {

    public boolean temVagasDisponiveisEvento(EventoCoreEntity eventoCoreEntity, int totalInscritos) {
        if (totalInscritos >= eventoCoreEntity.getCapacidade()) {
            return false;
        }
        return true;
    }
}
