package br.edu.ifpb.ecommercegenericbackend.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER,
        cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Cliente cliente;
    @ManyToMany(fetch = FetchType.EAGER,
        cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "tb_pedido_produto",
        joinColumns = @JoinColumn(name = "pedido_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id", referencedColumnName = "id")
    )
    private List<Produto> produtos;
    private Double valorTotal;

    public Pedido() {
    }

    public Pedido(
        Cliente cliente,
        List<Produto> produtos,
        Double valorTotal
    ) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }
}
