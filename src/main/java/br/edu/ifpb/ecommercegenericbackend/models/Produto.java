package br.edu.ifpb.ecommercegenericbackend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    private String categoria;
    private Integer quantidade;
    private String urlDaImagem;

    public Produto() {
    }

    public Produto(
        String nome,
        Double preco,
        String categoria,
        String urlDaImagem
    ) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.quantidade = 0;
        this.urlDaImagem = urlDaImagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getUrlDaImagem() {
        return urlDaImagem;
    }

    public void setUrlDaImagem(String imageUrl) {
        this.urlDaImagem = imageUrl;
    }
}
