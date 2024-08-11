package br.edu.ifpb.ecommercegenericbackend.repository;

import br.edu.ifpb.ecommercegenericbackend.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Long> {

}
