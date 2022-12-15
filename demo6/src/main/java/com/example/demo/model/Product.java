package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sttproduct", nullable = false, length = 255)
    private String sttproduct;
    @Basic
    @Column(name = "nameproduct", nullable = false, length = 255)
    private String nameproduct;
    @Basic
    @Column(name = "priceduct", nullable = false, length = 255)
    private String priceduct;
    @Basic
    @Column(name = "imgproduct", nullable = false, length = 1000)
    private String imgproduct;

    public String getSttproduct() {
        return sttproduct;
    }

    public void setSttproduct(String sttproduct) {
        this.sttproduct = sttproduct;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public String getPriceduct() {
        return priceduct;
    }

    public void setPriceduct(String priceduct) {
        this.priceduct = priceduct;
    }

    public String getImgproduct() {
        return imgproduct;
    }

    public void setImgproduct(String imgproduct) {
        this.imgproduct = imgproduct;
    }
}
