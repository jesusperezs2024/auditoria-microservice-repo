package com.h2.h2.api.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usermodel")
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iduser;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String correo;
    private String compania;
    private String telefono;
    private String companiatelefono;
    private String detaits;
    private Date createDate;
    private Date updateDate;
}
