package br.edu.ifpb.ecommercegenericbackend.controller;

import br.edu.ifpb.ecommercegenericbackend.models.Admin;
import br.edu.ifpb.ecommercegenericbackend.models.AdminInserirDTO;
import br.edu.ifpb.ecommercegenericbackend.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administradores")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> listar() {
        return this.adminService.listar();
    }

    @PostMapping
    public Admin inserir(@RequestBody @Valid AdminInserirDTO admin) {
        var adminASerInserido = new Admin();

        adminASerInserido.setNome(admin.nome());
        adminASerInserido.setSenha(admin.senha());

        return this.adminService.inserir(adminASerInserido);
    }
}
