package br.edu.ifpb.ecommercegenericbackend.repository;

import br.edu.ifpb.ecommercegenericbackend.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {

}
