package com.h2.h2.api.service;

import com.h2.h2.api.model.UserAccionsModel;

import java.util.List;

public interface UserAccionsService {
    List<UserAccionsModel> listados();

    UserAccionsModel getById(Integer id);

    List<UserAccionsModel> getByIdUser(String iduser);

    UserAccionsModel crear(UserAccionsModel eventsModel);

    UserAccionsModel update(UserAccionsModel eventsModel);

    UserAccionsModel delete (Integer id);

}
