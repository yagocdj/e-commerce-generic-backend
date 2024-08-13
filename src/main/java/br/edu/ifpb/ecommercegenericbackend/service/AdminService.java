package br.edu.ifpb.ecommercegenericbackend.service;

import br.edu.ifpb.ecommercegenericbackend.models.Admin;
import br.edu.ifpb.ecommercegenericbackend.repository.IAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final IAdminRepository adminRepository;

    public AdminService(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> listar() {
        return this.adminRepository.findAll();
    }

    public Admin inserir(Admin admin) {
        return this.adminRepository.save(admin);
    }
}
