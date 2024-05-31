package com.erasmus.balnature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

import com.google.type.DateTime;


public class fragment_login_tarih extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff=inflater.inflate(R.layout.fragment_login_tarih, container, false);
        fragment_login_tarihArgs gg=fragment_login_tarihArgs.fromBundle(getArguments());
        String email=gg.getEmail();
String isim=gg.getAd();
        String soyisim=gg.getSoyisim();
        String metin=gg.getMetin();
        String parola=gg.getParola();
        Button btn=ff.findViewById(R.id.button6);
        CalendarView cc=ff.findViewById(R.id.calendarView2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_login_tarihDirections.ActionFragmentLoginTarihToFragmentLoginSon g= fragment_login_tarihDirections.actionFragmentLoginTarihToFragmentLoginSon();
                g.setEmail(email);
g.setAd(isim);
                g.setSoyisim(soyisim);
                g.setMetin(metin);
                g.setTarih(cc.getDate());
                g.setParola(parola);
                Navigation.findNavController(ff).navigate(g);
            }
        });
        return ff;
    }
}