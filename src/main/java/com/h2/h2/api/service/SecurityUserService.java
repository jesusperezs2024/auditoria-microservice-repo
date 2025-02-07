package com.h2.h2.api.service;

import com.h2.h2.api.model.SecurityUserModel;

import java.util.List;


public interface SecurityUserService {
    List<SecurityUserModel> listados();

    SecurityUserModel crear(SecurityUserModel securityUserModel, String ipAddress); 

    SecurityUserModel update(SecurityUserModel faqModel);

    SecurityUserModel delete (Integer id);

}
