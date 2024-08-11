package br.edu.ifpb.ecommercegenericbackend.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record ClienteAutenticaDTO(
    @NotEmpty String email,
    @NotEmpty @Size(min = 5, max = 25) String senha
) {
}
