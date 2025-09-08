package br.com.cgtecnologia.gestaoevento.application.dtos.in;

import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.entities.ParticipanteCoreEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record InscricaoDtoIn(
        @NotNull(message = "O atributo cdEvento é obrigatório")
        Long cdEvento,
        @NotNull
        @Valid
        ParticipanteDtoIn participante) {
}
