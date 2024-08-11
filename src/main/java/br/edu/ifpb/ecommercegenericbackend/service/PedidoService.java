package br.edu.ifpb.ecommercegenericbackend.service;

import br.edu.ifpb.ecommercegenericbackend.models.Cliente;
import br.edu.ifpb.ecommercegenericbackend.models.Pedido;
import br.edu.ifpb.ecommercegenericbackend.models.PedidoListagemDTO;
import br.edu.ifpb.ecommercegenericbackend.models.Produto;
import br.edu.ifpb.ecommercegenericbackend.repository.IClienteRepository;
import br.edu.ifpb.ecommercegenericbackend.repository.IPedidoRepository;
import br.edu.ifpb.ecommercegenericbackend.repository.IProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final IPedidoRepository pedidoRepository;
    private final IClienteRepository clienteRepository;
    private final IProdutoRepository produtoRepository;

    public PedidoService(
        IPedidoRepository pedidoRepository,
        IClienteRepository clienteRepository,
        IProdutoRepository produtoRepository
    ) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<PedidoListagemDTO> listar() {
        return this.pedidoRepository.findAll().stream().map(PedidoListagemDTO::new).toList();
    }

    @Transactional
    public Pedido inserirOuAtualizar(Pedido pedido) {
        if (pedido.getCliente() != null && pedido.getCliente().getId() != null) {
            Cliente clientePersistente = this.clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));
            pedido.setCliente(clientePersistente);
        }
        if (!pedido.getProdutos().isEmpty()) {
            List<Produto> produtosDoPedido = new ArrayList<>();
            for (Produto prod : pedido.getProdutos()) {
                Optional<Produto> produtoPersistido = this.produtoRepository.findById(prod.getId());
                produtoPersistido.ifPresent(produtosDoPedido::add);
            }
            pedido.setProdutos(produtosDoPedido);
        }
        return this.pedidoRepository.save(pedido);
    }

    @Transactional
    public void apagar(Long id) {
        this.pedidoRepository.deleteById(id);
    }
}
