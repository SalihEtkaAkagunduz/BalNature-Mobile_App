package com.erasmus.balnature;

import com.google.type.DateTime;

import java.io.Serializable;

import java.util.Date;

public class bild  {
    Integer id;
    String açıklama;

    public bild(Integer id, String açıklama, String kısaaçıklama, String konu, String tarih, Integer tür, Integer dururm, Integer sil) {
        this.id = id;
        this.açıklama = açıklama;
        this.kısaaçıklama = kısaaçıklama;
        this.konu = konu;
        this.tarih = tarih;
        this.tür = tür;
        this.dururm = dururm;
        this.sil = sil;
    }

    public bild() {
    }

    String kısaaçıklama;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAçıklama() {
        return açıklama;
    }

    public void setAçıklama(String açıklama) {
        this.açıklama = açıklama;
    }

    public String getKısaaçıklama() {
        return kısaaçıklama;
    }

    public void setKısaaçıklama(String kısaaçıklama) {
        this.kısaaçıklama = kısaaçıklama;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public Integer getTür() {
        return tür;
    }

    public void setTür(Integer tür) {
        this.tür = tür;
    }

    public Integer getDururm() {
        return dururm;
    }

    public void setDururm(Integer dururm) {
        this.dururm = dururm;
    }

    public Integer getSil() {
        return sil;
    }

    public void setSil(Integer sil) {
        this.sil = sil;
    }

    String konu;
    String tarih;
    Integer tür;



    Integer dururm;
    Integer sil;
}
