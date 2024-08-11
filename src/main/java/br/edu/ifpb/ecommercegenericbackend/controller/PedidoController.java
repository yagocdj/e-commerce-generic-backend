package br.edu.ifpb.ecommercegenericbackend.controller;

import br.edu.ifpb.ecommercegenericbackend.models.DadosPedidoInserirDTO;
import br.edu.ifpb.ecommercegenericbackend.models.Pedido;
import br.edu.ifpb.ecommercegenericbackend.models.PedidoListagemDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PedidoController {
    @RestController
    @RequestMapping("/pedidos")
    public class PedidoController {

        private final PedidoService pedidoService;

        public PedidoController(PedidoService pedidoService) {
            this.pedidoService = pedidoService;
        }

        @GetMapping
        public List<PedidoListagemDTO> listar() {
            return this.pedidoService.listar();
        }

        @PostMapping
        public Pedido inserir(@RequestBody @Valid DadosPedidoInserirDTO pedido) {
            var pedidoASerInserido = new Pedido(
                pedido.cliente(),
                pedido.produtos(),
                pedido.valorTotal()
            );
            return this.pedidoService.inserirOuAtualizar(pedidoASerInserido);
        }

        @DeleteMapping("/{id}")
        public void apagar(@PathVariable("id") Long id) {
            this.pedidoService.apagar(id);
        }
    }
}
