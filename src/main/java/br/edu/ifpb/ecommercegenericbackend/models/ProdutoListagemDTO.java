package br.edu.ifpb.ecommercegenericbackend.models;

public record ProdutoListagemDTO(
    Long id,
    String nome,
    Double preco,
    String categoria,
    Integer quantidade,
    String urlDaImagem
) {
    public ProdutoListagemDTO(Produto produto) {
        this(
            produto.getId(),
            produto.getNome(),
            produto.getPreco(),
            produto.getCategoria(),
            produto.getQuantidade(),
            produto.getUrlDaImagem()
        );
    }
}
