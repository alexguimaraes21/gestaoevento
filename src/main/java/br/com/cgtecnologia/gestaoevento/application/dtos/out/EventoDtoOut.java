package br.com.cgtecnologia.gestaoevento.application.dtos.out;

import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;

import java.time.LocalDateTime;

public record EventoDtoOut(
        long id,
        String nome,
        String descricao,
        LocalDateTime dataEvento,
        String local,
        Integer capacidade,
        boolean ativo) {

    public EventoDtoOut(EventoCoreEntity entity) {
        this(entity.getId(), entity.getNome(), entity.getDescricao(), entity.getDataHoraEvento(), entity.getLocal(),
                entity.getCapacidade(), entity.isAtivo());
    }
}
