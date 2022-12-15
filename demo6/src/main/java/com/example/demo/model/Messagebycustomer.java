package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Messagebycustomer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stt", nullable = false)
    private int stt;
    @Basic
    @Column(name = "iduser", nullable = false, length = 255)
    private String iduser;
    @Basic
    @Column(name = "message", nullable = false, length = 1000)
    private String message;
    @Basic
    @Column(name = "rep", nullable = true)
    private Integer rep;
    @Basic
    @Column(name = "datesend", nullable = true)
    private Timestamp datesend;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRep() {
        return rep;
    }

    public void setRep(Integer rep) {
        this.rep = rep;
    }

    public Timestamp getDatesend() {
        return datesend;
    }

    public void setDatesend(Timestamp datesend) {
        this.datesend = datesend;
    }
}
