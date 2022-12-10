package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Service {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stt", nullable = false)
    private int stt;
    @Basic
    @Column(name = "name_service", nullable = true, length = 255)
    private String nameService;
    @Basic
    @Column(name = "price", nullable = false, length = 255)
    private String price;
    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;
    @Basic
    @Column(name = "img_service", nullable = false, length = 1000)
    private String imgService;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImgService() {
        return imgService;
    }

    public void setImgService(String imgService) {
        this.imgService = imgService;
    }
}
