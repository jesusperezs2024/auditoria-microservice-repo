package com.h2.h2.api.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "securityevents")
@Data
public class SecurityUserModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idsecurity;
        private String iduser;
        private String eventype;
        private String source;
        private String detaits;
        private String ipaddres;
        private String status;
        @Column(name = "createDate")
        private Date createDate;
        @Column(name = "updateDate")
        private Date updateDate;
}
