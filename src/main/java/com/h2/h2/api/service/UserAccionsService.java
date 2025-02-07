package com.h2.h2.api.service;

import com.h2.h2.api.model.UserAccionsModel;

import java.util.List;

public interface UserAccionsService {
    List<UserAccionsModel> listados();

    UserAccionsModel crear(UserAccionsModel eventsModel);

    UserAccionsModel update(UserAccionsModel eventsModel);

    UserAccionsModel delete (Integer id);

}
