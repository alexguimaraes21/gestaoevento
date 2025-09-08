package br.com.cgtecnologia.gestaoevento.application.dtos.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ParticipanteDtoIn(
        @NotNull(message = "O atributo nome é obrigatório")
        @Size(min = 3, max = 200, message = "O atributo nome deve ter no mínimo {min} e no máximo {max} caracteres")
        String nome,
        @NotNull(message = "O atributo email é obrigatório")
        @Email(message = "O email informado não é um endereço de email várlido")
        @Size(max = 255, message = "O atributo email deve ter no máximo {max} caracteres")
        String email) {
}
