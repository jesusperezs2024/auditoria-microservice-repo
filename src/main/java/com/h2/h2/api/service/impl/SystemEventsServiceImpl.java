package com.h2.h2.api.service.impl;

import com.h2.h2.api.model.SecurityUserModel;
import com.h2.h2.api.model.SystemEventsModel;
import com.h2.h2.api.respository.SystemEventsRepository;
import com.h2.h2.api.service.SystemEventsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class SystemEventsServiceImpl implements SystemEventsService {

    @Autowired
    private SystemEventsRepository eventsRepository;

    @Override
    public List<SystemEventsModel> listados() {
        return eventsRepository.findAll();
    }

    @Override
    public SystemEventsModel crear(SystemEventsModel eventsModel) {
        eventsModel.setStatus("A");
        eventsModel.setCreateDate(new Date());
        return eventsRepository.save(eventsModel);
    }

    @Override
    public SystemEventsModel update(SystemEventsModel eventsModel) {
        return eventsRepository.findById(eventsModel.getIdaccions())
            .map(existingEvent -> {
                existingEvent.setEventType(eventsModel.getEventType());
                existingEvent.setSource(eventsModel.getSource());
                existingEvent.setSeverity(eventsModel.getSeverity());
                existingEvent.setDetaits(eventsModel.getDetaits());
                existingEvent.setCreateDate(eventsModel.getCreateDate());
                existingEvent.setUpdateDate(new Date());
                return eventsRepository.save(existingEvent);
            }).orElseThrow(() -> new EntityNotFoundException(
                "SystemEventsLog con id " + eventsModel.getIdaccions() + " no encontrada."
            ));
    }
    

    

    @Override
    public SystemEventsModel delete(Integer id) {
        SystemEventsModel unidadbusca = eventsRepository.findById(id).get();
        unidadbusca.setStatus("I");
        return eventsRepository.save(unidadbusca);
    }

        @Override
    public SystemEventsModel getById(Integer id) {
            Optional<SystemEventsModel> user = eventsRepository.findById(id);
            return user.orElse(null);
    }

    @Override
    public List<SystemEventsModel> getByIdUser(String iduser) {
            return eventsRepository.findByIduser(iduser);   
    }

}
