package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Buyservice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stt", nullable = false)
    private int stt;
    @Basic
    @Column(name = "iduser", nullable = false, length = 255)
    private String iduser;
    @Basic
    @Column(name = "idbooking", nullable = false, length = 255)
    private String idbooking;
    @Basic
    @Column(name = "stt_service", nullable = false, length = 255)
    private String sttService;
    @Basic
    @Column(name = "dongia", nullable = false, length = 255)
    private String dongia;
    @Basic
    @Column(name = "soluong", nullable = false)
    private int soluong;
    @Basic
    @Column(name = "thanhtien", nullable = false, length = 255)
    private String thanhtien;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "img", nullable = false, length = 255)
    private String img;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getIdbooking() {
        return idbooking;
    }

    public void setIdbooking(String idbooking) {
        this.idbooking = idbooking;
    }

    public String getSttService() {
        return sttService;
    }

    public void setSttService(String sttService) {
        this.sttService = sttService;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(String thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
