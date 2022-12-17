package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Giftforuser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stt", nullable = false)
    private int stt;
    @Basic
    @Column(name = "idgift", nullable = true, length = 255)
    private String idgift;
    @Basic
    @Column(name = "noidunggift", nullable = true, length = 255)
    private String noidunggift;
    @Basic
    @Column(name = "hansudung", nullable = true)
    private Date hansudung;
    @Basic
    @Column(name = "foriduser", nullable = true, length = 255)
    private String foriduser;
    @Basic
    @Column(name = "sudung", nullable = true)
    private Integer sudung;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getIdgift() {
        return idgift;
    }

    public void setIdgift(String idgift) {
        this.idgift = idgift;
    }

    public String getNoidunggift() {
        return noidunggift;
    }

    public void setNoidunggift(String noidunggift) {
        this.noidunggift = noidunggift;
    }

    public Date getHansudung() {
        return hansudung;
    }

    public void setHansudung(Date hansudung) {
        this.hansudung = hansudung;
    }

    public String getForiduser() {
        return foriduser;
    }

    public void setForiduser(String foriduser) {
        this.foriduser = foriduser;
    }

    public Integer getSudung() {
        return sudung;
    }

    public void setSudung(Integer sudung) {
        this.sudung = sudung;
    }

    public String getGiatri() {
        return giatri;
    }

    public void setGiatri(String giatri) {
        this.giatri = giatri;
    }

    @Basic
    @Column(name = "giatri", nullable = true)
    private String giatri;
}
