package com.h2.h2.api.controller;

import com.h2.h2.api.model.SystemEventsModel;
import com.h2.h2.api.service.SystemEventsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

import javax.sql.DataSource;

@RestController
@RequestMapping("api/v1/auditoria/SystemEvents")
public class SystemEventsController {
    @Autowired
    private SystemEventsService securityUserService;

    @Autowired
    private DataSource dataSource;

    public void testConnection() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database!");
        }
    }

    @GetMapping("GetAll")
    public List<SystemEventsModel> listar() {
        return securityUserService.listados();
    }

    @PostMapping("Create")
    public SystemEventsModel create(@RequestBody SystemEventsModel securityUserModel) {
        return securityUserService.crear(securityUserModel);
    }

    @PutMapping("{id}")
    public SystemEventsModel update(@PathVariable Integer id, @RequestBody SystemEventsModel securityUserModel) {
        securityUserModel.setIdaccions(id);
        return securityUserService.update(securityUserModel);
    }    
    

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        securityUserService.delete(id);
    }
}
