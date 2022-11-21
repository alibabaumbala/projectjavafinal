package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Feedback {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfeedback", nullable = false)
    private int idfeedback;
    @Basic
    @Column(name = "idbooking", nullable = false, length = 255)
    private String idbooking;
    @Basic
    @Column(name = "iduser", nullable = false, length = 255)
    private String iduser;
    @Basic
    @Column(name = "location", nullable = false, length = 255)
    private String location;
    @Basic
    @Column(name = "idhotel", nullable = false, length = 255)
    private String idhotel;
    @Basic
    @Column(name = "idroom", nullable = false, length = 255)
    private String idroom;
    @Basic
    @Column(name = "star", nullable = false)
    private int star;
    @Basic
    @Column(name = "contentfeedback", nullable = true, length = 1000)
    private String contentfeedback;
    @Basic
    @Column(name = "datefeedback", nullable = true)
    private Timestamp datefeedback;

    public int getIdfeedback() {
        return idfeedback;
    }

    public void setIdfeedback(int idfeedback) {
        this.idfeedback = idfeedback;
    }

    public String getIdbooking() {
        return idbooking;
    }

    public void setIdbooking(String idbooking) {
        this.idbooking = idbooking;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(String idhotel) {
        this.idhotel = idhotel;
    }

    public String getIdroom() {
        return idroom;
    }

    public void setIdroom(String idroom) {
        this.idroom = idroom;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getContentfeedback() {
        return contentfeedback;
    }

    public void setContentfeedback(String contentfeedback) {
        this.contentfeedback = contentfeedback;
    }

    public Timestamp getDatefeedback() {
        return datefeedback;
    }

    public void setDatefeedback(Timestamp datefeedback) {
        this.datefeedback = datefeedback;
    }
}
