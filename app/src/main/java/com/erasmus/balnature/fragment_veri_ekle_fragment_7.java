package com.erasmus.balnature;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Locale;


public class fragment_veri_ekle_fragment_7 extends Fragment {

    Integer topat;
    Button btn,btn2;
    EditText ed,ed2,ed3,ed4,ed5;
    ProgressBar pr,pr2,pr3,pr4,pr5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff=inflater.inflate(R.layout.fragment_veri_ekle_fragment_7, container, false);
        btn = ff.findViewById(R.id.button14);btn2 = ff.findViewById(R.id.button13);veriaktarimi veri=(veriaktarimi) getArguments().getSerializable("key");
        topat=veri.getToplamatık();

        ed=ff.findViewById(R.id.editTextNumber3);
        ed2=ff.findViewById(R.id.editTextNumber2);
        ed3=ff.findViewById(R.id.editTextNumber4);
        ed4=ff.findViewById(R.id.editTextNumber5);

        pr=ff.findViewById(R.id. progressBar2);
        pr2=ff.findViewById(R.id.progressBar4);
        pr3=ff.findViewById(R.id.progressBar5);
        pr4=ff.findViewById(R.id.progressBar6);

        pr.setMax(veri.metala);
        pr2.setMax(veri.kağıta);
        pr3.setMax(veri.cama);
        pr4.setMax(veri.plastika);

        btn.setOnClickListener(new View.OnClickListener() {





            @Override
            public void onClick(View view) {
                // NavController'ı bul ve ilkk eylemini gerçekleştir
                if(ed.getText().toString().length()>0 && ed2.getText().toString().length()>0 && ed3.getText().toString().length()>0 && ed4.getText().toString().length()>0 ){
                    Bundle bundle = new Bundle();
                    veri.setMetalg(Integer.parseInt(ed.getText().toString()));
                    veri.setKağıtg(Integer.parseInt(ed2.getText().toString()));
                    veri.setCamg(Integer.parseInt(ed3.getText().toString()));
                    veri.setPlatikg(Integer.parseInt(ed4.getText().toString()));
                    bundle.putSerializable("key", veri);
                    NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.sekiz,bundle);
                }
                else{
                    Toast.makeText(ff.getContext(), "Lütfen Verilerin Hepsini Doldurun.", Toast.LENGTH_SHORT).show();
                }

            }
        });


        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer sayi1=0;

                if(ed.getText().toString().equals("")==false){
                    sayi1=Integer.parseInt(ed.getText().toString());
                }

                if(sayi1>veri.metala){;
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil

                    if (selectedLanguage.equals("es")) {
                        Toast.makeText(ff.getContext(), "No puedes reciclar más de la cantidad de residuos.", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("en")) {
                        Toast.makeText(ff.getContext(), "You can't recycle more than the waste amount.", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("tr")) {
                        Toast.makeText(ff.getContext(), "Atık Miktarından Fazlasını Geri Dönüştüremessin", Toast.LENGTH_SHORT).show();
                    } else {
                        Locale currentLocale = Locale.getDefault();
                        String currentLanguageCode = currentLocale.getLanguage();

                        if ("es".equals(currentLanguageCode)) {

                            Toast.makeText(ff.getContext(), "No puedes reciclar más de la cantidad de residuos.", Toast.LENGTH_SHORT).show();


                        } else if ("en".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "You can't recycle more than the waste amount.", Toast.LENGTH_SHORT).show();



                        } else if ("tr".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "Atık Miktarından Fazlasını Geri Dönüştüremessin", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ff.getContext(), "Atık Miktarından Fazlasını Geri Dönüştüremessin", Toast.LENGTH_SHORT).show();
                        }
                    }



                    pr.setProgress(0);ed.setText("");

                }
                else{

                    pr.setProgress(sayi1);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ed2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer sayi1=0;

                if(ed2.getText().toString().equals("")==false){
                    sayi1=Integer.parseInt(ed2.getText().toString());
                }
                if (sayi1 > veri.cama) {

                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil

                    if (selectedLanguage.equals("es")) {
                        // İspanyolca için özel işlemler
                        Toast.makeText(ff.getContext(), "No puedes reciclar más de la cantidad de residuos.", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("en")) {
                        Toast.makeText(ff.getContext(), "You can't recycle more than the waste amount.", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("tr")) {
                        Toast.makeText(ff.getContext(), "Atık Miktarından Fazlasını Geri Dönüştüremessin", Toast.LENGTH_SHORT).show();
                    } else {
                        Locale currentLocale = Locale.getDefault();
                        String currentLanguageCode = currentLocale.getLanguage();

                        if ("es".equals(currentLanguageCode)) {

                            Toast.makeText(ff.getContext(), "No puedes reciclar más de la cantidad de residuos.", Toast.LENGTH_SHORT).show();


                        } else if ("en".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "You can't recycle more than the waste amount.", Toast.LENGTH_SHORT).show();



                        } else if ("tr".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "Atık Miktarından Fazlasını Geri Dönüştüremessin", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ff.getContext(), "Atık Miktarından Fazlasını Geri Dönüştüremessin", Toast.LENGTH_SHORT).show();
                        }

                    }







                    pr2.setProgress(0);
                    ed2.setText("");

                } else {

                    pr2.setProgress(sayi1);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ed3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer sayi1=0;

                if(ed3.getText().toString().equals("")==false){
                    sayi1=Integer.parseInt(ed3.getText().toString());
                }                if(sayi1>veri.kağıta){;
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil

                    if (selectedLanguage.equals("es")) {
                        // İspanyolca için özel işlemler
                        Toast.makeText(ff.getContext(), "No puedes reciclar más de la cantidad de residuos.", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("en")) {
                        Toast.makeText(ff.getContext(), "You can't recycle more than the waste amount.", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("tr")) {
                        Toast.makeText(ff.getContext(), "Atık Miktarından Fazlasını Geri Dönüştüremessin", Toast.LENGTH_SHORT).show();
                    } else {
                        Locale currentLocale = Locale.getDefault();
                        String currentLanguageCode = currentLocale.getLanguage();

                        if ("es".equals(currentLanguageCode)) {

                            Toast.makeText(ff.getContext(), "No puedes reciclar más de la cantidad de residuos.", Toast.LENGTH_SHORT).show();


                        } else if ("en".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "You can't recycle more than the waste amount.", Toast.LENGTH_SHORT).show();



                        } else if ("tr".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "Atık Miktarından Fazlasını Geri Dönüştüremessin", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ff.getContext(), "Atık Miktarından Fazlasını Geri Dönüştüremessin", Toast.LENGTH_SHORT).show();
                        }

                    }
                    pr3.setProgress(0);ed3.setText("");

                }
                else{

                    pr3.setProgress(sayi1);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ed4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer sayi1=0;

                if(ed4.getText().toString().equals("")==false){
                    sayi1=Integer.parseInt(ed4.getText().toString());
                }
                if(sayi1>veri.plastika){;
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil

                    if (selectedLanguage.equals("es")) {
                        // İspanyolca için özel işlemler
                        Toast.makeText(ff.getContext(), "No puedes reciclar más de la cantidad de residuos.", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("en")) {
                        Toast.makeText(ff.getContext(), "You can't recycle more than the waste amount.", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("tr")) {
                        Toast.makeText(ff.getContext(), "Atık Miktarından Fazlasını Geri Dönüştüremessin", Toast.LENGTH_SHORT).show();
                    } else {
                        Locale currentLocale = Locale.getDefault();
                        String currentLanguageCode = currentLocale.getLanguage();

                        if ("es".equals(currentLanguageCode)) {

                            Toast.makeText(ff.getContext(), "No puedes reciclar más de la cantidad de residuos.", Toast.LENGTH_SHORT).show();


                        } else if ("en".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "You can't recycle more than the waste amount.", Toast.LENGTH_SHORT).show();



                        } else if ("tr".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "Atık Miktarından Fazlasını Geri Dönüştüremessin", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ff.getContext(), "Atık Miktarından Fazlasını Geri Dönüştüremessin", Toast.LENGTH_SHORT).show();
                        }

                    }
                    pr4.setProgress(0);ed4.setText("");

                }
                else{

                    pr4.setProgress(sayi1);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // NavController'ı bul ve ilkk eylemini gerçekleştir
                Bundle bundle = new Bundle();
                bundle.putSerializable("key", veri);
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.sekizt,bundle);
            }
        });
        return ff;
    }
}
