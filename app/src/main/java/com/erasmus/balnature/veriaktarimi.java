package com.erasmus.balnature;

import java.io.Serializable;

public class veriaktarimi implements Serializable,  Cloneable  {
    String Ad;
    @Override
    public veriaktarimi clone() {
        try {
            return (veriaktarimi) super.clone();
        } catch (CloneNotSupportedException e) {
            // CloneNotSupportedException ile başa çıkmak için gereken işlemleri yapabilirsiniz
            e.printStackTrace();
            return null;
        }
    }
    String açiklama;
    Integer tur;
    Long Tarih;
    String faliyetalanı;
    Integer toplamatık;
    Integer metala;

    Integer cama;
    Integer kağıta;

    public float getKaydıdegerlendir() {
        return kaydıdegerlendir;
    }

    public void setKaydıdegerlendir(float kaydıdegerlendir) {
        this.kaydıdegerlendir = kaydıdegerlendir;
    }

    float kaydıdegerlendir;

    public veriaktarimi() {
    }

    public veriaktarimi( String ad, String açiklama, Integer tur, Long tarih, String faliyetalanı, Integer toplamatık, Integer metala, Integer cama, Integer kağıta, Integer plastika, Integer metalg, Integer camg, Integer kağıtg, Integer platikg,Float kaydıdegerlendir) {
        this.Ad = ad;
        this.açiklama = açiklama;
        this.tur = tur;
        this.kaydıdegerlendir=kaydıdegerlendir;
        this.Tarih = tarih;
        this.faliyetalanı = faliyetalanı;
        this.toplamatık = toplamatık;
        this.metala = metala;
        this.cama = cama;
        this.kağıta = kağıta;
        this.plastika = plastika;
        this.metalg = metalg;
        this.camg = camg;
        this.kağıtg = kağıtg;
        this.platikg = platikg;
    }

    Integer plastika;
    Integer metalg;

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getAçiklama() {
        return açiklama;
    }

    public void setAçiklama(String açiklama) {
        this.açiklama = açiklama;
    }

    public Integer getTur() {
        return tur;
    }

    public void setTur(Integer tur) {
        this.tur = tur;
    }

    public Long getTarih() {
        return Tarih;
    }

    public void setTarih(Long tarih) {
        Tarih = tarih;
    }

    public String getFaliyetalanı() {
        return faliyetalanı;
    }

    public void setFaliyetalanı(String faliyetalanı) {
        this.faliyetalanı = faliyetalanı;
    }

    public Integer getToplamatık() {
        return toplamatık;
    }

    public void setToplamatık(Integer toplamatık) {
        this.toplamatık = toplamatık;
    }

    public Integer getMetala() {
        return metala;
    }

    public void setMetala(Integer metala) {
        this.metala = metala;
    }

    public Integer getCama() {
        return cama;
    }

    public void setCama(Integer cama) {
        this.cama = cama;
    }

    public Integer getKağıta() {
        return kağıta;
    }

    public void setKağıta(Integer kağıta) {
        this.kağıta = kağıta;
    }

    public Integer getPlastika() {
        return plastika;
    }

    public void setPlastika(Integer plastika) {
        this.plastika = plastika;
    }

    public Integer getMetalg() {
        return metalg;
    }

    public void setMetalg(Integer metalg) {
        this.metalg = metalg;
    }

    public Integer getCamg() {
        return camg;
    }

    public void setCamg(Integer camg) {
        this.camg = camg;
    }

    public Integer getKağıtg() {
        return kağıtg;
    }

    public void setKağıtg(Integer kağıtg) {
        this.kağıtg = kağıtg;
    }

    public Integer getPlatikg() {
        return platikg;
    }

    public void setPlatikg(Integer platikg) {
        this.platikg = platikg;
    }

    Integer camg;
    Integer kağıtg;
    Integer platikg;



}
