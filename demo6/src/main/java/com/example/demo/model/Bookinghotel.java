package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Bookinghotel {
    @Basic
    @Column(name = "iduser", nullable = false, length = 255)
    private String iduser;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idbooking", nullable = false, length = 255)
    private String idbooking;
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
    @Column(name = "checkin", nullable = false, length = 255)
    private String checkin;
    @Basic
    @Column(name = "checkout", nullable = false, length = 255)
    private String checkout;
    @Basic
    @Column(name = "adult", nullable = true)
    private Integer adult;
    @Basic
    @Column(name = "child", nullable = true)
    private Integer child;
    @Basic
    @Column(name = "sophong", nullable = false)
    private int sophong;
    @Basic
    @Column(name = "totalprice", nullable = false, length = 255)
    private String totalprice;
    @Basic
    @Column(name = "statusbooking", nullable = true, length = 255)
    private String statusbooking;
    @Basic
    @Column(name = "datebooking", nullable = false)
    private Timestamp datebooking;
    @Basic
    @Column(name = "representative", nullable = false, length = 255)
    private String representative;
    @Basic
    @Column(name = "phonecontact", nullable = false, length = 255)
    private String phonecontact;
    @Basic
    @Column(name = "emailcontact", nullable = false, length = 255)
    private String emailcontact;
    @Basic
    @Column(name = "review", nullable = true)
    private Integer review;

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

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public Integer getAdult() {
        return adult;
    }

    public void setAdult(Integer adult) {
        this.adult = adult;
    }

    public Integer getChild() {
        return child;
    }

    public void setChild(Integer child) {
        this.child = child;
    }

    public int getSophong() {
        return sophong;
    }

    public void setSophong(int sophong) {
        this.sophong = sophong;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getStatusbooking() {
        return statusbooking;
    }

    public void setStatusbooking(String statusbooking) {
        this.statusbooking = statusbooking;
    }

    public Timestamp getDatebooking() {
        return datebooking;
    }

    public void setDatebooking(Timestamp datebooking) {
        this.datebooking = datebooking;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getPhonecontact() {
        return phonecontact;
    }

    public void setPhonecontact(String phonecontact) {
        this.phonecontact = phonecontact;
    }

    public String getEmailcontact() {
        return emailcontact;
    }

    public void setEmailcontact(String emailcontact) {
        this.emailcontact = emailcontact;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }
}
