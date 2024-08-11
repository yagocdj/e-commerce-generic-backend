package br.edu.ifpb.ecommercegenericbackend.controller;

import br.edu.ifpb.ecommercegenericbackend.models.Admin;
import br.edu.ifpb.ecommercegenericbackend.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
