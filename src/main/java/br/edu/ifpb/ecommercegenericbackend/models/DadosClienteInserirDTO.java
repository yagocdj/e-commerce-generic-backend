package br.edu.ifpb.ecommercegenericbackend.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosClienteInserirDTO(
    @NotBlank String nome,
    @NotBlank String cpf,
    @Email(message = "Email inválido!") String email,
    @NotBlank String endereco,
    @NotBlank String telefone,
    @NotBlank String senha
) { }
