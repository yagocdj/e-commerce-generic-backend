package br.edu.ifpb.ecommercegenericbackend.repository;

import br.edu.ifpb.ecommercegenericbackend.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Long> {

    public Produto findProdutoByNome(String nome);

    public List<Produto> findProdutosByCategoria(String categoria);
}
