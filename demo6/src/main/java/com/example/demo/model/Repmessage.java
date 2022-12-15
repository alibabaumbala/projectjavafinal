package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Repmessage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stt", nullable = false)
    private int stt;
    @Basic
    @Column(name = "sttmessagesend", nullable = false)
    private int sttmessagesend;
    @Basic
    @Column(name = "repcontent", nullable = true, length = 1000)
    private String repcontent;
    @Basic
    @Column(name = "daterep", nullable = true)
    private Timestamp daterep;
    @Basic
    @Column(name = "userread", nullable = true)
    private Integer userread;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getSttmessagesend() {
        return sttmessagesend;
    }

    public void setSttmessagesend(int sttmessagesend) {
        this.sttmessagesend = sttmessagesend;
    }

    public String getRepcontent() {
        return repcontent;
    }

    public void setRepcontent(String repcontent) {
        this.repcontent = repcontent;
    }

    public Timestamp getDaterep() {
        return daterep;
    }

    public void setDaterep(Timestamp daterep) {
        this.daterep = daterep;
    }

    public Integer getUserread() {
        return userread;
    }

    public void setUserread(Integer userread) {
        this.userread = userread;
    }
}
