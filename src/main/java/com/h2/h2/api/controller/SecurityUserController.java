package com.h2.h2.api.controller;

import com.h2.h2.api.model.SecurityUserModel;
import com.h2.h2.api.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@RestController
@RequestMapping("api/v1/auditoria/SecurityUser")
public class SecurityUserController {
    @Autowired
    private SecurityUserService securityUserService;

    @Autowired
    private DataSource dataSource;

    public void testConnection() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database!");
        }
    }

    @GetMapping("GetAll")
    public List<SecurityUserModel> listar() {
        return securityUserService.listados();
    }

    @PostMapping("Create")
    public SecurityUserModel create(@RequestBody SecurityUserModel securityUserModel, HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr(); // Captura la IP
        return securityUserService.crear(securityUserModel, ipAddress); // Pasa la IP correctamente
    }
    
    

    @PutMapping("{id}")
    public SecurityUserModel update(@PathVariable Integer id, @RequestBody SecurityUserModel securityUserModel) {
        securityUserModel.setIdsecurity(id);
        return securityUserService.update(securityUserModel);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        securityUserService.delete(id);
    }
}
