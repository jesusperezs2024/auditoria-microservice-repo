package com.h2.h2.api.controller;

import com.h2.h2.api.model.SecurityUserModel;
import com.h2.h2.api.model.UserAccionsModel;
import com.h2.h2.api.service.UserAccionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

import javax.sql.DataSource;

@RestController
@RequestMapping("api/v1/auditoria/UserAccions")
public class UserAccionsController {
    @Autowired
    private UserAccionsService securityUserService;

    @Autowired
    private DataSource dataSource;

    public void testConnection() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to the database!");
        }
    }

    @GetMapping("GetAll")
    public List<UserAccionsModel> listar() {
        return securityUserService.listados();
    }

        @GetMapping("{id}")
    public UserAccionsModel getById(@PathVariable Integer id) {
        return securityUserService.getById(id);
    }


    @GetMapping("user/{iduser}")
    public List<UserAccionsModel> getByUserId(@PathVariable("iduser") String iduser) {
        return securityUserService.getByIdUser(iduser);
    }

    @PostMapping("Create")
    public UserAccionsModel create(@RequestBody UserAccionsModel securityUserModel) {
        return securityUserService.crear(securityUserModel);
    }

    @PutMapping("{id}")
    public UserAccionsModel update(@PathVariable Integer id, @RequestBody UserAccionsModel securityUserModel) {
        securityUserModel.setIdaccions(id);
        return securityUserService.update(securityUserModel);
    }        

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        securityUserService.delete(id);
    }
}
