package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Voucher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idvoucher", nullable = false, length = 255)
    private String idvoucher;
    @Basic
    @Column(name = "discount", nullable = false, length = 255)
    private String discount;
    @Basic
    @Column(name = "soluong", nullable = false)
    private int soluong;

    public String getIdvoucher() {
        return idvoucher;
    }

    public void setIdvoucher(String idvoucher) {
        this.idvoucher = idvoucher;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Basic
    @Column(name = "sudung", nullable = true,length = 255)
    private int sudung;

    public int getSudung() {
        return sudung;
    }

    public void setSudung(int sudung) {
        this.sudung = sudung;
    }
}
