package com.h2.h2.api.service.impl;

import com.h2.h2.api.model.UserAccionsModel;
import com.h2.h2.api.respository.UserAccionsRepository;
import com.h2.h2.api.service.UserAccionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
public class UserAccionsServiceImpl implements UserAccionsService {

    @Autowired
    private UserAccionsRepository accionsRepository;

    @Override
    public List<UserAccionsModel> listados() {
        return accionsRepository.findAll();
    }

    @Override
    public UserAccionsModel crear(UserAccionsModel userAccionsModel) {
        userAccionsModel.setStatus("A");
        userAccionsModel.setCreateDate(new Date());
        return accionsRepository.save(userAccionsModel);
    }

    @Override
    public UserAccionsModel update(UserAccionsModel userAccionsModel) {
        return accionsRepository.findById(userAccionsModel.getIdaccions())
            .map(existingAccion -> {
                // Solo actualizar los campos que vienen con valores
                if (userAccionsModel.getIduser() != null) existingAccion.setIduser(userAccionsModel.getIduser());
                if (userAccionsModel.getAccion() != null) existingAccion.setAccion(userAccionsModel.getAccion());
                if (userAccionsModel.getScreen() != null) existingAccion.setScreen(userAccionsModel.getScreen());
                if (userAccionsModel.getClassJava() != null) existingAccion.setClassJava(userAccionsModel.getClassJava());
                if (userAccionsModel.getDetaits() != null) existingAccion.setDetaits(userAccionsModel.getDetaits());
                if (userAccionsModel.getStatus() != null) existingAccion.setStatus(userAccionsModel.getStatus());
                
                // Mantener createDate y solo actualizar updateDate
                existingAccion.setUpdateDate(new Date());
    
                return accionsRepository.save(existingAccion); // Guardar cambios
            }).orElseThrow(() -> new EntityNotFoundException(
                "UserAccionLog con id " + userAccionsModel.getIdaccions() + " no encontrada."
            ));
    }
    

    @Override
    public UserAccionsModel delete(Integer id) {
        UserAccionsModel unidadbusca = accionsRepository.findById(id).get();
        unidadbusca.setStatus("I");
        return accionsRepository.save(unidadbusca);
    }

}
