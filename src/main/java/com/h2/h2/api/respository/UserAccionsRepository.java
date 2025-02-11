package com.h2.h2.api.respository;

import com.h2.h2.api.model.UserAccionsModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccionsRepository extends JpaRepository<UserAccionsModel, Integer> {
    List<UserAccionsModel> findByIduser(String iduser); // Corregido el nombre del método
}
