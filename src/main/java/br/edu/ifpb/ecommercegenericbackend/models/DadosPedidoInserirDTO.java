package br.edu.ifpb.ecommercegenericbackend.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record DadosPedidoInserirDTO(
    @NotNull Cliente cliente,
    @NotEmpty List<Produto> produtos,
    @Positive(message = "O valor total deve ser maior do que zero.")
    Double valorTotal
) {
}
