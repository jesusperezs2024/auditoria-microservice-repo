package com.h2.h2.api.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;





@Entity
@Table(name = "eventaccions")
@Data
public class UserAccionsModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idaccions;
        private String iduser;
        private String accion;
        private String screen;
        private String classJava;
        private String detaits;
        private String status;
        private Date createDate;
        private Date updateDate;
}
