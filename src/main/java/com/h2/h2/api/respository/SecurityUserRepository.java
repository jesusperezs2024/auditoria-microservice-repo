package com.h2.h2.api.respository;


import com.h2.h2.api.model.SecurityUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SecurityUserRepository extends JpaRepository<SecurityUserModel, Integer> {
    List<SecurityUserModel> findByIduser(String iduser); // Corregido el nombre del método
}
