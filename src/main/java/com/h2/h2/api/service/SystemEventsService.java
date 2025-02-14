package com.h2.h2.api.service;

import com.h2.h2.api.model.SecurityUserModel;
import com.h2.h2.api.model.SystemEventsModel;

import java.util.List;

public interface SystemEventsService {
    List<SystemEventsModel> listados();

    SystemEventsModel getById(Integer id);

    List<SystemEventsModel> getByIdUser(String iduser);

    SystemEventsModel crear(SystemEventsModel eventsModel);

    SystemEventsModel update(SystemEventsModel eventsModel);    

    SystemEventsModel delete (Integer id);

}
