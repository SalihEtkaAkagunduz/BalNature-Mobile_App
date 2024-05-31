package com.erasmus.balnature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;


public class fragment_veri_ekle_fragment_2 extends Fragment {

    RadioButton rd, rd2;
    Button btn, btn2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ff = inflater.inflate(R.layout.fragment_veri_ekle_fragment_2, container, false);
        veriaktarimi veri = (veriaktarimi) getArguments().getSerializable("key");
        rd = ff.findViewById(R.id.radioButton);
        rd2 = ff.findViewById(R.id.radioButton2);
        btn = ff.findViewById(R.id.button14);
        btn2 = ff.findViewById(R.id.button13);

        rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rd.setChecked(true);
                rd2.setChecked(false);
            }
        });

        rd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rd.setChecked(false);
                rd2.setChecked(true);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veri.setTur(1);
                Bundle bundle = new Bundle();
                bundle.putSerializable("key", veri);
                // NavController'ı bul ve ilkk eylemini gerçekleştir
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.üç, bundle);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("key", veri);                // NavController'ı bul ve ilkk eylemini gerçekleştir
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.üçt,bundle);
            }
        });

        return ff;
    }
}
