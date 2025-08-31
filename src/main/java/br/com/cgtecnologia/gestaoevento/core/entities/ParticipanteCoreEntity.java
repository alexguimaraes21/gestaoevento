package br.com.cgtecnologia.gestaoevento.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ParticipanteCoreEntity {
    private UUID id;
    private String nome;
    private String email;
}
