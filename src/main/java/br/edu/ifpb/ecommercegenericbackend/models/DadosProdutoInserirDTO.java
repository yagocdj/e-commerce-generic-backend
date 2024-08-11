package br.edu.ifpb.ecommercegenericbackend.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosProdutoInserirDTO(
    @NotBlank String nome,
    @Positive(message = "O preço deve ser maior do que zero.")
    Double preco,
    @NotBlank String categoria,
    @PositiveOrZero Integer quantidade,
    @NotBlank String urlDaImagem
) { }
