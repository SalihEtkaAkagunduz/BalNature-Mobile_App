package com.erasmus.balnature;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class fragment_veri_ekle_fragment_4 extends Fragment {
ImageView im,im2,im3,im4;
TextView tx,tx2,tx3,tx4;
ConstraintLayout c,c2,c3,c4;
ConstraintLayout d,d2,d3,d4;
EditText edt;
int tıklı=1;
    Button btn,btn2;View ff;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ff=inflater.inflate(R.layout.fragment_veri_ekle_fragment_4, container, false);
        btn = ff.findViewById(R.id.button14);btn2 = ff.findViewById(R.id.button13);
        im=ff.findViewById(R.id.imageView48w);
        im2=ff.findViewById(R.id.imageView4y8);
        im3=ff.findViewById(R.id.imapgeView48);
        im4=ff.findViewById(R.id.imageView48);
        veriaktarimi veri=(veriaktarimi) getArguments().getSerializable("key");

        c=ff.findViewById(R.id.constraintLayout33q);
        c2=ff.findViewById(R.id.constraintLayout3t3);
        c3=ff.findViewById(R.id.constroaintLayout33);
        c4=ff.findViewById(R.id.constraintLayout33);


        d=ff.findViewById(R.id.constraintLayout3e5);
        d2=ff.findViewById(R.id.constraintLayuout35);
        d3=ff.findViewById(R.id.constraintLayoğut35);
        d4=ff.findViewById(R.id.constraintLayout35);


        tx=ff.findViewById(R.id.textView83r);
        tx2=ff.findViewById(R.id.textVieıw83);
        tx3=ff.findViewById(R.id.textView83);
        edt=ff.findViewById(R.id.editTextText3);






        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklı=1;
                tıklama();
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklı=2;
                tıklama();
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklı=3;
                tıklama();
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklı=4;
                tıklama();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklı=1;
                tıklama();
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklı=2;
                tıklama();
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklı=3;
                tıklama();
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklı=4;
                tıklama();
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklı=1;
                tıklama();
            }
        });
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklı=2;
                tıklama();
            }
        });
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklı=3;
                tıklama();
            }
        });
        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıklı=4;
                tıklama();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tıklı==4 ){
                    if(edt.getText().toString().length()>0){
                        String h="";
                        if(tıklı==1){
                            h="Ev";
                        }
                        if(tıklı==2){
                            h="İş Yeri";
                        }
                        if(tıklı==3){
                            h="Okul";
                        }
                        if(tıklı==4){
                            h=edt.getText().toString();
                        }
                        veri.setFaliyetalanı(h);
                        Bundle bundle = new Bundle();


                        bundle.putSerializable("key", veri);
                        NavController navController = Navigation.findNavController(view);
                        navController.navigate(R.id.bes,bundle);
                    }
                    else{

                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                        String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                        if (selectedLanguage.equals("es")) {
                            // İspanyolca için özel işlemler
                            Toast.makeText(ff.getContext(), "Por favor, ingrese el campo seleccionado", Toast.LENGTH_SHORT).show();
                        } else if (selectedLanguage.equals("en")) {
                            // İngilizce için özel işlemler
                            Toast.makeText(ff.getContext(), "Please enter the selected field", Toast.LENGTH_SHORT).show();
                        } else if (selectedLanguage.equals("tr")) {
                            // Türkçe için özel işlemler
                            Toast.makeText(ff.getContext(), "Lütfen Seçtiğiniz Alanı Giriniz.", Toast.LENGTH_SHORT).show();
                        } else {
                            Locale currentLocale = Locale.getDefault();
                            String currentLanguageCode = currentLocale.getLanguage();

                            if ("es".equals(currentLanguageCode)) {
                                Toast.makeText(ff.getContext(), "Por favor, ingrese el campo seleccionado", Toast.LENGTH_SHORT).show();


                            } else if ("en".equals(currentLanguageCode)) {
                                Toast.makeText(ff.getContext(), "Please enter the selected field", Toast.LENGTH_SHORT).show();


                            } else if ("tr".equals(currentLanguageCode)) {
                                Toast.makeText(ff.getContext(), "Lütfen Seçtiğiniz Alanı Giriniz.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ff.getContext(), "Lütfen Seçtiğiniz Alanı Giriniz.", Toast.LENGTH_SHORT).show();
                            }
                        }





                    }
                }
                else{
                    String h="";
                    if(tıklı==1){
                        h="Ev";
                    }
                    if(tıklı==2){
                        h="İş";
                    }
                    if(tıklı==3){
                        h="Okul";
                    }
                    if(tıklı==4){
                        h=edt.getText().toString();
                    }
                    veri.setFaliyetalanı(h);
                    Bundle bundle = new Bundle();


                    bundle.putSerializable("key", veri);
                    NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.bes,bundle);
                }
                // NavController'ı bul ve ilkk eylemini gerçekleştir


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("key", veri);
                // NavController'ı bul ve ilkk eylemini gerçekleştir
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.beşt,bundle);
            }
        });
        return ff;
    }
    void tıklama(){
        if(tıklı==1){
            im.setImageResource(R.drawable.fragment_veri_ekle_home_dolu);
            tx.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.black));
            tx2.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.white));
            tx3.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.white));
            edt.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.white));
            im2.setImageResource(R.drawable.fragment_veri_ekle_work_bos);
            im3.setImageResource(R.drawable.fragment_veri_ekle_school_bos);
            im4.setImageResource(R.drawable.fragment_veri_ekle_other_bos);

        }
        else if(tıklı==2){
            im.setImageResource(R.drawable.outline_home_24);
            tx.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.white));
            tx2.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.black));
            tx3.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.white));
            edt.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.white));
            im2.setImageResource(R.drawable.fragment_veri_ekle_work_dolu);
            im3.setImageResource(R.drawable.fragment_veri_ekle_school_bos);
            im4.setImageResource(R.drawable.fragment_veri_ekle_other_bos);
        }
        else if(tıklı==3){
            im.setImageResource(R.drawable.outline_home_24);
            tx.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.white));
            tx2.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.white));
            tx3.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.black));
            edt.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.white));
            im2.setImageResource(R.drawable.fragment_veri_ekle_work_bos);
            im3.setImageResource(R.drawable.fragment_veri_ekle_school_dolu);
            im4.setImageResource(R.drawable.fragment_veri_ekle_other_bos);
        }
        else if(tıklı==4){
            im.setImageResource(R.drawable.outline_home_24);
            tx.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.white));
            tx2.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.white));
            tx3.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.white));
edt.setTextColor(ContextCompat.getColor(ff.getContext(), R.color.black));
            im2.setImageResource(R.drawable.fragment_veri_ekle_work_bos);
            im3.setImageResource(R.drawable.fragment_veri_ekle_school_bos);
            im4.setImageResource(R.drawable.fragment_veri_ekle_other_dolu);
        }
    }

}