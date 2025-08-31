package br.com.cgtecnologia.gestaoevento.application.dtos.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record EventoDtoIn(
        @NotNull(message = "O atributo nome é obrigatório")
        @Size(min = 5, max = 255, message = "O atributo nome deve ter no mínimo {min} e no máximo {max} caracteres")
        String nome,
        @NotNull(message = "O atributo descricap é obrigatório")
        @Size(min = 5, max = 4000, message = "O atributo descricao deve ter no mínimo {min} e no máximo {max} caracteres")
        String descricao,
        @NotNull(message = "O atributo dataEvento é obrigatório")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @FutureOrPresent(message = "O atributo dataEVento não pode ser uma data passada")
        LocalDateTime dataHoraEvento,
        @NotNull(message = "O atributo local é obrigatório")
        @Size(min = 5, max = 255, message = "O atributo local deve ter no mínimo {min} e no máximo {max} caracteres")
        String local,
        @Min(value = 10, message = "O atributo capacidade deve ser no mínimo 10")
        @Max(value = 100, message = "O atributo capacidade deve ser no máximo 100")
        Integer capacidade,
        @NotNull(message = "O atributo ativo é obrigatorio")
        boolean ativo) {
}
