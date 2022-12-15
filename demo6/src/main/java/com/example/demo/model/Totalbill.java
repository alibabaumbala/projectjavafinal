package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Totalbill {
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
    @Column(name = "totalpricebill", nullable = false, length = 255)
    private String totalpricebill;
    @Basic
    @Column(name = "status", nullable = false, length = 255)
    private String status;

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

    public String getTotalpricebill() {
        return totalpricebill;
    }

    public void setTotalpricebill(String totalpricebill) {
        this.totalpricebill = totalpricebill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
