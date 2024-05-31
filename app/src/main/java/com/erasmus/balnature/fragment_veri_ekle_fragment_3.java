package com.erasmus.balnature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

public class fragment_veri_ekle_fragment_3 extends Fragment {
    Button btn,btn2;
    CalendarView dt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff=inflater.inflate(R.layout.fragment_veri_ekle_fragment_3, container, false);
        btn = ff.findViewById(R.id.button14);btn2 = ff.findViewById(R.id.button13);
        dt=ff.findViewById(R.id.calendarView3);
        veriaktarimi veri=(veriaktarimi) getArguments().getSerializable("key");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veri.setTarih(dt.getDate());
                Bundle bundle = new Bundle();


                bundle.putSerializable("key", veri);
                // NavController'ı bul ve ilkk eylemini gerçekleştir
                // NavController'ı bul ve ilkk eylemini gerçekleştir
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.dört,bundle);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Bundle bundle = new Bundle();
                bundle.putSerializable("key", veri);
                // NavController'ı bul ve ilkk eylemini gerçekleştir
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.dörtt,bundle);
            }
        });
        return ff;
    }
}