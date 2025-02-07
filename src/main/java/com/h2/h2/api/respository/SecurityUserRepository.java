package com.h2.h2.api.respository;

import com.h2.h2.api.model.SecurityUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityUserRepository extends JpaRepository<SecurityUserModel, Integer> {
}
