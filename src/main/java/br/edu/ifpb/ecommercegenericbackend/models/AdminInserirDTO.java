package br.edu.ifpb.ecommercegenericbackend.models;

import jakarta.validation.constraints.NotBlank;

public record AdminInserirDTO(
        @NotBlank String nome,
        @NotBlank String senha
) {
}
