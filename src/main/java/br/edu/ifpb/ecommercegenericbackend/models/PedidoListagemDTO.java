package br.edu.ifpb.ecommercegenericbackend.models;

import java.util.List;

public record PedidoListagemDTO(
    Long id,
    Cliente cliente,
    List<Produto> produtos,
    Double valorTotal
) {
    public PedidoListagemDTO(Pedido pedido) {
        this(
            pedido.getId(),
            pedido.getCliente(),
            pedido.getProdutos(),
            pedido.getValorTotal()
        );
    }
}
