package br.com.fiap.brindes.dto.response;

import lombok.Builder;

@Builder
public record ProdutoResponse(

        Long id,
        String nome,
        Double preco,
        CategoriaResponse categoria

) {
}
