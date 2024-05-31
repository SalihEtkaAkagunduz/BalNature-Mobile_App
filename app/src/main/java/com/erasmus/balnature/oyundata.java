package com.erasmus.balnature;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class oyundata implements Serializable {

    üstoyun1 üstoyun1;
    üstoyun2 üstoyun2;



    üstoyun3 üstoyun3;
    üstoyun4 üstoyun4;
    üstoyun5 üstoyun5;

    public com.erasmus.balnature.üstoyun1 getÜstoyun1() {
        return üstoyun1;
    }

    public void setÜstoyun1(com.erasmus.balnature.üstoyun1 üstoyun1) {
        this.üstoyun1 = üstoyun1;
    }

    public com.erasmus.balnature.üstoyun2 getÜstoyun2() {
        return üstoyun2;
    }

    public void setÜstoyun2(com.erasmus.balnature.üstoyun2 üstoyun2) {
        this.üstoyun2 = üstoyun2;
    }

    public com.erasmus.balnature.üstoyun3 getÜstoyun3() {
        return üstoyun3;
    }

    public void setÜstoyun3(com.erasmus.balnature.üstoyun3 üstoyun3) {
        this.üstoyun3 = üstoyun3;
    }

    public com.erasmus.balnature.üstoyun4 getÜstoyun4() {
        return üstoyun4;
    }

    public void setÜstoyun4(com.erasmus.balnature.üstoyun4 üstoyun4) {
        this.üstoyun4 = üstoyun4;
    }

    public com.erasmus.balnature.üstoyun5 getÜstoyun5() {
        return üstoyun5;
    }

    public void setÜstoyun5(com.erasmus.balnature.üstoyun5 üstoyun5) {
        this.üstoyun5 = üstoyun5;
    }

    public com.erasmus.balnature.üstoyun6 getÜstoyun6() {
        return üstoyun6;
    }

    public void setÜstoyun6(com.erasmus.balnature.üstoyun6 üstoyun6) {
        this.üstoyun6 = üstoyun6;
    }

    public ArrayList<tümoy> getTümoyunlar() {
        return tümoyunlar;
    }

    public void setTümoyunlar(ArrayList<tümoy> tümoyunlar) {
        this.tümoyunlar = tümoyunlar;
    }

    public ArrayList<popülero> getPopuleroyunlar() {
        return populeroyunlar;
    }

    public void setPopuleroyunlar(ArrayList<popülero> populeroyunlar) {
        this.populeroyunlar = populeroyunlar;
    }

    public ArrayList<önerilero> getOnerilenoyunlar() {
        return onerilenoyunlar;
    }

    public void setOnerilenoyunlar(ArrayList<önerilero> onerilenoyunlar) {
        this.onerilenoyunlar = onerilenoyunlar;
    }

    public ArrayList<yenioyunlar> getYenioyun() {
        return yenioyun;
    }

    public void setYenioyun(ArrayList<yenioyunlar> yenioyun) {
        this.yenioyun = yenioyun;
    }

    public oyundata(com.erasmus.balnature.üstoyun1 üstoyun1, com.erasmus.balnature.üstoyun2 üstoyun2, com.erasmus.balnature.üstoyun3 üstoyun3, com.erasmus.balnature.üstoyun4 üstoyun4, com.erasmus.balnature.üstoyun5 üstoyun5, com.erasmus.balnature.üstoyun6 üstoyun6, ArrayList<tümoy> tümoyunlar, ArrayList<popülero> populeroyunlar, ArrayList<önerilero> onerilenoyunlar, ArrayList<yenioyunlar> yenioyun) {
        this.üstoyun1 = üstoyun1;
        this.üstoyun2 = üstoyun2;
        this.üstoyun3 = üstoyun3;
        this.üstoyun4 = üstoyun4;
        this.üstoyun5 = üstoyun5;
        this.üstoyun6 = üstoyun6;
        this.tümoyunlar = tümoyunlar;
        this.populeroyunlar = populeroyunlar;
        this.onerilenoyunlar = onerilenoyunlar;
        this.yenioyun = yenioyun;
    }

    üstoyun6 üstoyun6;

    public oyundata() {
    }

    ArrayList<tümoy> tümoyunlar;
    ArrayList<popülero> populeroyunlar;
    ArrayList<önerilero> onerilenoyunlar;
    ArrayList<yenioyunlar> yenioyun;


}
class tümoy{
    String resim1;


String kısaacık;
String uzunacık;
    String resim2;

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

    public String getResim3() {
        return resim3;
    }

    public void setResim3(String resim3) {
        this.resim3 = resim3;
    }

    public String getResim4() {
        return resim4;
    }

    public void setResim4(String resim4) {
        this.resim4 = resim4;
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

    String resim;

    public tümoy(String resim1, String kısaacık, String uzunacık, String resim2, String resim, String resim3, String resim4, String resim5, String resim6, String isim, String dosya, Integer indirilimi, String geliştiren, String yayımlayan, String boyut, Date tarih, String tür, boolean pc, boolean android, boolean çevrimdisi, boolean tekoyun, boolean balnature, boolean cabraz, boolean oturum, boolean kayıt, boolean avatar, boolean basarım) {
        this.resim1 = resim1;
        this.kısaacık = kısaacık;
        this.uzunacık = uzunacık;
        this.resim2 = resim2;
        this.resim = resim;
        this.resim3 = resim3;
        this.resim4 = resim4;
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

    public tümoy() {
    }

    String resim3;
    String resim4;
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
class popülero{


    String resim1;
    String kısaacık;
    String uzunacık;


    String resim2;
    String resim;

    public popülero(String resim1, String kısaacık, String uzunacık, String resim2, String resim, String resim3, String resim4, String resim5, String resim6, String isim, String dosya, Integer indirilimi, String geliştiren, String yayımlayan, String boyut, Date tarih, String tür, boolean pc, boolean android, boolean çevrimdisi, boolean tekoyun, boolean balnature, boolean cabraz, boolean oturum, boolean kayıt, boolean avatar, boolean basarım) {
        this.resim1 = resim1;
        this.kısaacık = kısaacık;
        this.uzunacık = uzunacık;
        this.resim2 = resim2;
        this.resim = resim;
        this.resim3 = resim3;
        this.resim4 = resim4;
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

    public popülero() {
    }

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

    public String getResim3() {
        return resim3;
    }

    public void setResim3(String resim3) {
        this.resim3 = resim3;
    }

    public String getResim4() {
        return resim4;
    }

    public void setResim4(String resim4) {
        this.resim4 = resim4;
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

    String resim3;
    String resim4;
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
class önerilero{
    String resim1;
    String resim2;
    String resim;
    String resim3;
    String resim4;
    String kısaacık;
    String uzunacık;


    String resim5;
    String resim6;
    String isim;

    public String getResim1() {
        return resim1;
    }

    public void setResim1(String resim1) {
        this.resim1 = resim1;
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

    public String getResim3() {
        return resim3;
    }

    public void setResim3(String resim3) {
        this.resim3 = resim3;
    }

    public String getResim4() {
        return resim4;
    }

    public void setResim4(String resim4) {
        this.resim4 = resim4;
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

    public önerilero(String resim1, String resim2, String resim, String resim3, String resim4, String kısaacık, String uzunacık, String resim5, String resim6, String isim, String dosya, Integer indirilimi, String geliştiren, String yayımlayan, String boyut, Date tarih, String tür, boolean pc, boolean android, boolean çevrimdisi, boolean tekoyun, boolean balnature, boolean cabraz, boolean oturum, boolean kayıt, boolean avatar, boolean basarım) {
        this.resim1 = resim1;
        this.resim2 = resim2;
        this.resim = resim;
        this.resim3 = resim3;
        this.resim4 = resim4;
        this.kısaacık = kısaacık;
        this.uzunacık = uzunacık;
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

    String dosya;

    public önerilero() {
    }

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
class yenioyunlar{
    String resim1;

    public yenioyunlar() {
    }

    public String getResim1() {
        return resim1;
    }

    public void setResim1(String resim1) {
        this.resim1 = resim1;
    }

    public String getResim2() {
        return resim2;
    }

    public void setResim2(String resim2) {
        this.resim2 = resim2;
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

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public String getResim3() {
        return resim3;
    }

    public void setResim3(String resim3) {
        this.resim3 = resim3;
    }

    public String getResim4() {
        return resim4;
    }

    public void setResim4(String resim4) {
        this.resim4 = resim4;
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

    String resim2;

    public yenioyunlar(String resim1, String resim2, String kısaacık, String uzunacık, String resim, String resim3, String resim4, String resim5, String resim6, String isim, String dosya, Integer indirilimi, String geliştiren, String yayımlayan, String boyut, Date tarih, String tür, boolean pc, boolean android, boolean çevrimdisi, boolean tekoyun, boolean balnature, boolean cabraz, boolean oturum, boolean kayıt, boolean avatar, boolean basarım) {
        this.resim1 = resim1;
        this.resim2 = resim2;
        this.kısaacık = kısaacık;
        this.uzunacık = uzunacık;
        this.resim = resim;
        this.resim3 = resim3;
        this.resim4 = resim4;
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

    String kısaacık;
    String uzunacık;

    String resim;
    String resim3;
    String resim4;


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
class üstoyun1{
    String kısaacık;
    String uzunacık;
    String resim1;
    String resim2;
    String resim;
    String resim3;
    String resim4;


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

    public String getResim1() {
        return resim1;
    }

    public void setResim1(String resim1) {
        this.resim1 = resim1;
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

    public String getResim3() {
        return resim3;
    }

    public void setResim3(String resim3) {
        this.resim3 = resim3;
    }

    public String getResim4() {
        return resim4;
    }

    public void setResim4(String resim4) {
        this.resim4 = resim4;
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

    public üstoyun1(String kısaacık, String uzunacık, String resim1, String resim2, String resim, String resim3, String resim4, String resim5, String resim6, String isim, String dosya, Integer indirilimi, String geliştiren, String yayımlayan, String boyut, Date tarih, String tür, boolean pc, boolean android, boolean çevrimdisi, boolean tekoyun, boolean balnature, boolean cabraz, boolean oturum, boolean kayıt, boolean avatar, boolean basarım) {
        this.kısaacık = kısaacık;
        this.uzunacık = uzunacık;
        this.resim1 = resim1;
        this.resim2 = resim2;
        this.resim = resim;
        this.resim3 = resim3;
        this.resim4 = resim4;
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

    public üstoyun1() {
    }

    boolean cabraz;
    boolean oturum;
    boolean kayıt;
    boolean avatar;
    boolean basarım;

}
class üstoyun2{
    String resim1;

    String kısaacık;
    String uzunacık;

    String resim2;
    String resim;
    String resim3;
    String resim4;

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

    public String getResim3() {
        return resim3;
    }

    public void setResim3(String resim3) {
        this.resim3 = resim3;
    }

    public String getResim4() {
        return resim4;
    }

    public void setResim4(String resim4) {
        this.resim4 = resim4;
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

    public üstoyun2(String resim1, String kısaacık, String uzunacık, String resim2, String resim, String resim3, String resim4, String resim5, String resim6, String isim, String dosya, Integer indirilimi, String geliştiren, String yayımlayan, String boyut, Date tarih, String tür, boolean pc, boolean android, boolean çevrimdisi, boolean tekoyun, boolean balnature, boolean cabraz, boolean oturum, boolean kayıt, boolean avatar, boolean basarım) {
        this.resim1 = resim1;
        this.kısaacık = kısaacık;
        this.uzunacık = uzunacık;
        this.resim2 = resim2;
        this.resim = resim;
        this.resim3 = resim3;
        this.resim4 = resim4;
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

    public üstoyun2() {
    }

    boolean tekoyun;
    boolean balnature;
    boolean cabraz;
    boolean oturum;
    boolean kayıt;
    boolean avatar;
    boolean basarım;

}
class üstoyun3{

    String kısaacık;
    String uzunacık;
    String resim1;
    String resim2;
    String resim;
    String resim3;
    String resim4;
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

    public üstoyun3() {
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

    public String getResim1() {
        return resim1;
    }

    public void setResim1(String resim1) {
        this.resim1 = resim1;
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

    public String getResim3() {
        return resim3;
    }

    public void setResim3(String resim3) {
        this.resim3 = resim3;
    }

    public String getResim4() {
        return resim4;
    }

    public void setResim4(String resim4) {
        this.resim4 = resim4;
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

    boolean pc;
    boolean android;

    public üstoyun3(String kısaacık, String uzunacık, String resim1, String resim2, String resim, String resim3, String resim4, String resim5, String resim6, String isim, String dosya, Integer indirilimi, String geliştiren, String yayımlayan, String boyut, Date tarih, String tür, boolean pc, boolean android, boolean çevrimdisi, boolean tekoyun, boolean balnature, boolean cabraz, boolean oturum, boolean kayıt, boolean avatar, boolean basarım) {
        this.kısaacık = kısaacık;
        this.uzunacık = uzunacık;
        this.resim1 = resim1;
        this.resim2 = resim2;
        this.resim = resim;
        this.resim3 = resim3;
        this.resim4 = resim4;
        this.resim5 = resim5;
        this.resim6 = resim6;

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

    boolean çevrimdisi;
    boolean tekoyun;
    boolean balnature;
    boolean cabraz;
    boolean oturum;
    boolean kayıt;
    boolean avatar;
    boolean basarım;

}
class üstoyun4{
    String kısaacık;
    String uzunacık;

    String resim1;
    String resim2;

    public üstoyun4() {
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

    public String getResim1() {
        return resim1;
    }

    public void setResim1(String resim1) {
        this.resim1 = resim1;
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

    public String getResim3() {
        return resim3;
    }

    public void setResim3(String resim3) {
        this.resim3 = resim3;
    }

    public String getResim4() {
        return resim4;
    }

    public void setResim4(String resim4) {
        this.resim4 = resim4;
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

    public üstoyun4(String kısaacık, String uzunacık, String resim1, String resim2, String resim, String resim3, String resim4, String resim5, String resim6, String isim, String dosya, Integer indirilimi, String geliştiren, String yayımlayan, String boyut, Date tarih, String tür, boolean pc, boolean android, boolean çevrimdisi, boolean tekoyun, boolean balnature, boolean cabraz, boolean oturum, boolean kayıt, boolean avatar, boolean basarım) {
        this.kısaacık = kısaacık;
        this.uzunacık = uzunacık;
        this.resim1 = resim1;
        this.resim2 = resim2;
        this.resim = resim;
        this.resim3 = resim3;
        this.resim4 = resim4;
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

    String resim;
    String resim3;
    String resim4;
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
class üstoyun5{
    String resim1;
    String resim2;
    String kısaacık;
    String uzunacık;

    String resim;
    String resim3;
    String resim4;
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

    public üstoyun5() {
    }

    boolean tekoyun;

    public String getResim1() {
        return resim1;
    }

    public void setResim1(String resim1) {
        this.resim1 = resim1;
    }

    public String getResim2() {
        return resim2;
    }

    public void setResim2(String resim2) {
        this.resim2 = resim2;
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

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public String getResim3() {
        return resim3;
    }

    public void setResim3(String resim3) {
        this.resim3 = resim3;
    }

    public String getResim4() {
        return resim4;
    }

    public void setResim4(String resim4) {
        this.resim4 = resim4;
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

    public üstoyun5(String resim1, String resim2, String kısaacık, String uzunacık, String resim, String resim3, String resim4, String resim5, String resim6, String isim, String dosya, Integer indirilimi, String geliştiren, String yayımlayan, String boyut, Date tarih, String tür, boolean pc, boolean android, boolean çevrimdisi, boolean tekoyun, boolean balnature, boolean cabraz, boolean oturum, boolean kayıt, boolean avatar, boolean basarım) {
        this.resim1 = resim1;
        this.resim2 = resim2;
        this.kısaacık = kısaacık;
        this.uzunacık = uzunacık;
        this.resim = resim;
        this.resim3 = resim3;
        this.resim4 = resim4;
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

    boolean balnature;
    boolean cabraz;
    boolean oturum;
    boolean kayıt;
    boolean avatar;
    boolean basarım;

}
class üstoyun6{

    String resim1;
    String resim2;
    String kısaacık;
    String uzunacık;

    String resim;
    String resim3;
    String resim4;
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

    public üstoyun6() {
    }

    boolean tekoyun;

    public String getResim1() {
        return resim1;
    }

    public void setResim1(String resim1) {
        this.resim1 = resim1;
    }

    public String getResim2() {
        return resim2;
    }

    public void setResim2(String resim2) {
        this.resim2 = resim2;
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

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public String getResim3() {
        return resim3;
    }

    public void setResim3(String resim3) {
        this.resim3 = resim3;
    }

    public String getResim4() {
        return resim4;
    }

    public void setResim4(String resim4) {
        this.resim4 = resim4;
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

    public üstoyun6(String resim1, String resim2, String kısaacık, String uzunacık, String resim, String resim3, String resim4, String resim5, String resim6, String isim, String dosya, Integer indirilimi, String geliştiren, String yayımlayan, String boyut, Date tarih, String tür, boolean pc, boolean android, boolean çevrimdisi, boolean tekoyun, boolean balnature, boolean cabraz, boolean oturum, boolean kayıt, boolean avatar, boolean basarım) {
        this.resim1 = resim1;
        this.resim2 = resim2;
        this.kısaacık = kısaacık;
        this.uzunacık = uzunacık;
        this.resim = resim;
        this.resim3 = resim3;
        this.resim4 = resim4;
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

    boolean balnature;
    boolean cabraz;
    boolean oturum;
    boolean kayıt;
    boolean avatar;
    boolean basarım;
}
