package com.example.demo.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idemp", nullable = false, length = 255)
    private String idemp;
    @Basic
    @Column(name = "tenemp", nullable = false, length = 255)
    private String tenemp;
    @Basic
    @Column(name = "sdtemp", nullable = false, length = 255)
    private String sdtemp;
    @Basic
    @Column(name = "emailemp", nullable = false, length = 255)
    private String emailemp;
    @Basic
    @Column(name = "genderemp", nullable = false, length = 255)
    private String genderemp;
    @Basic
    @Column(name = "positionemp", nullable = false, length = 255)
    private String positionemp;
    @Basic
    @Column(name = "passemp", nullable = false, length = 255)
    private String passemp;
    @Basic
    @Column(name = "createemp", nullable = true)
    private Timestamp createemp;
    @Basic
    @Column(name = "avatar", nullable = true, length = 1000)
    private String avatar;

    public String getIdemp() {
        return idemp;
    }

    public void setIdemp(String idemp) {
        this.idemp = idemp;
    }

    public String getTenemp() {
        return tenemp;
    }

    public void setTenemp(String tenemp) {
        this.tenemp = tenemp;
    }

    public String getSdtemp() {
        return sdtemp;
    }

    public void setSdtemp(String sdtemp) {
        this.sdtemp = sdtemp;
    }

    public String getEmailemp() {
        return emailemp;
    }

    public void setEmailemp(String emailemp) {
        this.emailemp = emailemp;
    }

    public String getGenderemp() {
        return genderemp;
    }

    public void setGenderemp(String genderemp) {
        this.genderemp = genderemp;
    }

    public String getPositionemp() {
        return positionemp;
    }

    public void setPositionemp(String positionemp) {
        this.positionemp = positionemp;
    }

    public String getPassemp() {
        return passemp;
    }

    public void setPassemp(String passemp) {
        this.passemp = passemp;
    }

    public Timestamp getCreateemp() {
        return createemp;
    }

    public void setCreateemp(Timestamp createemp) {
        this.createemp = createemp;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Transient
    private MultipartFile file;

}
