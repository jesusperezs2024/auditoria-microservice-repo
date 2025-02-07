package com.h2.h2.api.service.impl;

import com.h2.h2.api.model.SecurityUserModel;
import com.h2.h2.api.respository.SecurityUserRepository;
import com.h2.h2.api.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityNotFoundException;

@Service
public class SecurityUserServiceImpl implements SecurityUserService {



    @Autowired
    private SecurityUserRepository securityUserRepository;

    @Override
    public List<SecurityUserModel> listados() {
        return securityUserRepository.findAll();
    }

    @Override
    public SecurityUserModel crear(SecurityUserModel unidadOperativa, String ipAddress) {
        unidadOperativa.setStatus("A");
        unidadOperativa.setCreateDate(new Date());
        unidadOperativa.setIpaddres(ipAddress);
        return securityUserRepository.save(unidadOperativa);
    }
    

    @Override
    public SecurityUserModel update(SecurityUserModel unidadOperativa) {
        return securityUserRepository.findById(unidadOperativa.getIdsecurity())
            .map(existingRecord -> {
                // Solo actualiza los valores no nulos
                if (unidadOperativa.getIduser() != null) {
                    existingRecord.setIduser(unidadOperativa.getIduser());
                }
                if (unidadOperativa.getEventype() != null) {
                    existingRecord.setEventype(unidadOperativa.getEventype());
                }
                if (unidadOperativa.getSource() != null) {
                    existingRecord.setSource(unidadOperativa.getSource());
                }
                if (unidadOperativa.getDetaits() != null) {
                    existingRecord.setDetaits(unidadOperativa.getDetaits());
                }
                if (unidadOperativa.getIpaddres() != null) {
                    existingRecord.setIpaddres(unidadOperativa.getIpaddres());
                }
                if (unidadOperativa.getStatus() != null) {
                    existingRecord.setStatus(unidadOperativa.getStatus());
                }
                if (unidadOperativa.getCreateDate() != null) {
                    existingRecord.setCreateDate(unidadOperativa.getCreateDate());
                }
                // Actualiza la fecha de modificación
                existingRecord.setUpdateDate(new Date());
    
                return securityUserRepository.save(existingRecord);
            })
            .orElseThrow(() -> new EntityNotFoundException("SecurityLog con id " + unidadOperativa.getIdsecurity() + " no encontrada."));
    }
    

    @Override
    public SecurityUserModel delete(Integer id) {
        SecurityUserModel unidadbusca = securityUserRepository.findById(id).get();
        unidadbusca.setStatus("I");
        return securityUserRepository.save(unidadbusca);
    }

}
