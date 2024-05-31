package com.erasmus.balnature;

import java.io.Serializable;
import java.util.Date;

public class oyungoster implements Serializable {


    String resim1;

    String kısaacık;
    String uzunacık;
    String resim2;
    String resim; String resim4;
    String resim3;

    public String getResim1() {
        return resim1;
    }

    public void setResim1(String resim1) {
        this.resim1 = resim1;
    }

    public String getKısaacık() {
        return kısaacık;
    }

    public void setKısaacık(String kısaacık) {
        this.kısaacık = kısaacık;
    }

    public String getUzunacık() {
        return uzunacık;
    }

    public void setUzunacık(String uzunacık) {
        this.uzunacık = uzunacık;
    }

    public String getResim2() {
        return resim2;
    }

    public void setResim2(String resim2) {
        this.resim2 = resim2;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public String getResim4() {
        return resim4;
    }

    public void setResim4(String resim4) {
        this.resim4 = resim4;
    }

    public String getResim3() {
        return resim3;
    }

    public void setResim3(String resim3) {
        this.resim3 = resim3;
    }

    public String getResim5() {
        return resim5;
    }

    public void setResim5(String resim5) {
        this.resim5 = resim5;
    }

    public String getResim6() {
        return resim6;
    }

    public void setResim6(String resim6) {
        this.resim6 = resim6;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getDosya() {
        return dosya;
    }

    public void setDosya(String dosya) {
        this.dosya = dosya;
    }

    public Integer getIndirilimi() {
        return indirilimi;
    }

    public void setIndirilimi(Integer indirilimi) {
        this.indirilimi = indirilimi;
    }

    public String getGeliştiren() {
        return Geliştiren;
    }

    public void setGeliştiren(String geliştiren) {
        Geliştiren = geliştiren;
    }

    public String getYayımlayan() {
        return Yayımlayan;
    }

    public void setYayımlayan(String yayımlayan) {
        Yayımlayan = yayımlayan;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public String getTür() {
        return tür;
    }

    public void setTür(String tür) {
        this.tür = tür;
    }

    public boolean isPc() {
        return pc;
    }

    public void setPc(boolean pc) {
        this.pc = pc;
    }

    public boolean isAndroid() {
        return android;
    }

    public void setAndroid(boolean android) {
        this.android = android;
    }

    public boolean isÇevrimdisi() {
        return çevrimdisi;
    }

    public void setÇevrimdisi(boolean çevrimdisi) {
        this.çevrimdisi = çevrimdisi;
    }

    public boolean isTekoyun() {
        return tekoyun;
    }

    public void setTekoyun(boolean tekoyun) {
        this.tekoyun = tekoyun;
    }

    public boolean isBalnature() {
        return balnature;
    }

    public void setBalnature(boolean balnature) {
        this.balnature = balnature;
    }

    public boolean isCabraz() {
        return cabraz;
    }

    public void setCabraz(boolean cabraz) {
        this.cabraz = cabraz;
    }

    public boolean isOturum() {
        return oturum;
    }

    public void setOturum(boolean oturum) {
        this.oturum = oturum;
    }

    public boolean isKayıt() {
        return kayıt;
    }

    public void setKayıt(boolean kayıt) {
        this.kayıt = kayıt;
    }

    public boolean isAvatar() {
        return avatar;
    }

    public void setAvatar(boolean avatar) {
        this.avatar = avatar;
    }

    public boolean isBasarım() {
        return basarım;
    }

    public void setBasarım(boolean basarım) {
        this.basarım = basarım;
    }

    public oyungoster(String resim1, String kısaacık, String uzunacık, String resim2, String resim, String resim4, String resim3, String resim5, String resim6, String isim, String dosya, Integer indirilimi, String geliştiren, String yayımlayan, String boyut, Date tarih, String tür, boolean pc, boolean android, boolean çevrimdisi, boolean tekoyun, boolean balnature, boolean cabraz, boolean oturum, boolean kayıt, boolean avatar, boolean basarım) {
        this.resim1 = resim1;
        this.kısaacık = kısaacık;
        this.uzunacık = uzunacık;
        this.resim2 = resim2;
        this.resim = resim;
        this.resim4 = resim4;
        this.resim3 = resim3;
        this.resim5 = resim5;
        this.resim6 = resim6;
        this.isim = isim;
        this.dosya = dosya;
        this.indirilimi = indirilimi;
        Geliştiren = geliştiren;
        Yayımlayan = yayımlayan;
        this.boyut = boyut;
        this.tarih = tarih;
        this.tür = tür;
        this.pc = pc;
        this.android = android;
        this.çevrimdisi = çevrimdisi;
        this.tekoyun = tekoyun;
        this.balnature = balnature;
        this.cabraz = cabraz;
        this.oturum = oturum;
        this.kayıt = kayıt;
        this.avatar = avatar;
        this.basarım = basarım;
    }

    public oyungoster() {
    }



    String resim5;
    String resim6;
    String isim;
    String dosya;
    Integer indirilimi;
    String Geliştiren;
    String Yayımlayan;
    String boyut;
    Date tarih;
    String tür;
    boolean pc;
    boolean android;
    boolean çevrimdisi;
    boolean tekoyun;
    boolean balnature;
    boolean cabraz;
    boolean oturum;
    boolean kayıt;
    boolean avatar;
    boolean basarım;
}
