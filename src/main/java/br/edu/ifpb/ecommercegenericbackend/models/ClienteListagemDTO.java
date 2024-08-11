package br.edu.ifpb.ecommercegenericbackend.models;

public record ClienteListagemDTO(
    Long id,
    String nome,
    String cpf,
    String email,
    String endereco,
    String telefone
) {
    public ClienteListagemDTO(Cliente cliente) {
        this(
            cliente.getId(),
            cliente.getNome(),
            cliente.getCpf(),
            cliente.getEmail(),
            cliente.getEndereco(),
            cliente.getTelefone()
        );
    }
}
