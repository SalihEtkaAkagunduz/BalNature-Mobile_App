package com.erasmus.balnature;

import com.google.type.DateTime;

import java.io.Serializable;
import java.util.ArrayList;

public class Kullanici implements Serializable {
    public ArrayList<veriaktarimi> getVeriListesi() {
        return veriListesi;
    }
    ArrayList<veriaktarimi> veriListesi;
    ArrayList<bild> bildirim;
    public void setVeriListesi(ArrayList<veriaktarimi> veriListesi) {
        this.veriListesi = veriListesi;
    }
    public ArrayList<bild> getbildirim() {
        return bildirim;
    }

    public void setbildirim(ArrayList<bild> bildirim) {
        this.bildirim = bildirim;
    }
    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getOlusturmazamani() {
        return olusturmazamani;
    }

    public void setOlusturmazamani(String olusturmazamani) {
        this.olusturmazamani = olusturmazamani;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTarih() {
        return tarih;
    }

    public void setTarih(Long tarih) {
        this.tarih = tarih;
    }

    public Integer getKayitsayisi() {
        return kayitsayisi;
    }

    public void setKayitsayisi(Integer kayitsayisi) {
        this.kayitsayisi = kayitsayisi;
    }

    public Integer getToplamortalama() {
        return toplamortalama;
    }

    public void setToplamortalama(Integer toplamortalama) {
        this.toplamortalama = toplamortalama;
    }

    public Integer getMetalortlama() {
        return metalortlama;
    }

    public void setMetalortlama(Integer metalortlama) {
        this.metalortlama = metalortlama;
    }

    public Integer getKagitortalama() {
        return kagitortalama;
    }

    public void setKagitortalama(Integer kagitortalama) {
        this.kagitortalama = kagitortalama;
    }

    public Integer getCamortalama() {
        return camortalama;
    }

    public void setCamortalama(Integer camortalama) {
        this.camortalama = camortalama;
    }

    public Integer getPlastikortalama() {
        return plastikortalama;
    }

    public void setPlastikortalama(Integer plastikortalama) {
        this.plastikortalama = plastikortalama;
    }




    public Kullanici(ArrayList<veriaktarimi> veriListesi,ArrayList<bild> bildirim, String isim, String soyisim, String aciklama, String olusturmazamani, String web, String twitter, String facebook, String linkedin, String instagram, String email, Long tarih, Integer kayitsayisi, Integer toplamortalama, Integer metalortlama, Integer kagitortalama, Integer camortalama, Integer plastikortalama) {
        this.bildirim = bildirim;
        this.veriListesi = veriListesi;
        this.isim = isim;
        this.soyisim = soyisim;
        this.aciklama = aciklama;
        this.olusturmazamani = olusturmazamani;
        this.web = web;
        this.twitter = twitter;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.instagram = instagram;
        this.email = email;
        this.tarih = tarih;
        this.kayitsayisi = kayitsayisi;
        this.toplamortalama = toplamortalama;
        this.metalortlama = metalortlama;
        this.kagitortalama = kagitortalama;
        this.camortalama = camortalama;
        this.plastikortalama = plastikortalama;

    }

    String isim,soyisim,aciklama,olusturmazamani,web,twitter,facebook,linkedin,instagram;
    String email;
    Long tarih;
    Integer kayitsayisi,toplamortalama,metalortlama,kagitortalama,camortalama,plastikortalama;




    public Kullanici() {
    }


}
