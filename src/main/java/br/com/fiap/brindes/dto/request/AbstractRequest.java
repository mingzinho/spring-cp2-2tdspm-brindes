package br.com.fiap.brindes.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AbstractRequest (
        @Positive(message = "id inválido!")
        @NotNull(message = "id obrigatório")
        Long id
) {

}