package br.edu.ifpb.ecommercegenericbackend.controller;

import br.edu.ifpb.ecommercegenericbackend.models.Cliente;
import br.edu.ifpb.ecommercegenericbackend.models.ClienteAutenticaDTO;
import br.edu.ifpb.ecommercegenericbackend.models.ClienteListagemDTO;
import br.edu.ifpb.ecommercegenericbackend.models.DadosClienteInserirDTO;
import br.edu.ifpb.ecommercegenericbackend.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteListagemDTO> listar(@RequestParam(value = "email", required = false) String email,
                                           @RequestParam(value = "cpf", required = false) String cpf) {

        boolean temEmail = email != null && !email.isBlank();
        boolean temCpf = (cpf != null && !cpf.isBlank()) && cpf.length() == 11;

        if (temEmail) {
            var clientePesquisado = this.clienteService.getClientePorEmail(email);
            if (clientePesquisado != null) {
                return Collections.singletonList(clientePesquisado);
            }
            return null;
        }
        if (temCpf) {
            var clientePesquisado = this.clienteService.getClienteByCpf(cpf);
            if (clientePesquisado != null) {
                return Collections.singletonList(clientePesquisado);
            }
            return null;
        }
        return this.clienteService.listar();
    }

    @GetMapping("/{id}")
    public Cliente getClientePorId(@PathVariable("id") Long idCliente) {
        return this.clienteService.getClienteById(idCliente);
    }

    @GetMapping("/email/{email}")
    public ClienteListagemDTO getClientePorEmail(@PathVariable("email") String email) {
        return this.clienteService.getClientePorEmail(email);
    }

    @PostMapping
    public Cliente inserir(@RequestBody @Valid DadosClienteInserirDTO cliente) {
        var clienteASerInserido = new Cliente(
                cliente.nome(),
                cliente.cpf(),
                cliente.email(),
                cliente.endereco(),
                cliente.telefone(),
                cliente.senha()
        );
        return this.clienteService.inserirOuAtualizar(clienteASerInserido);
    }

    @PostMapping("/auth")
    public boolean auth(@RequestBody @Valid ClienteAutenticaDTO cliente) {
        return this.clienteService.autenticar(cliente.email(), cliente.senha());
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@RequestBody @Valid DadosClienteInserirDTO cliente, @PathVariable("id") Long id) {
        return this.clienteService.atualizar(cliente, id);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable("id") Long id) {
        this.clienteService.apagar(id);
    }
}
