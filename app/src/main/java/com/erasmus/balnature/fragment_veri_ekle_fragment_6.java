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


public class fragment_veri_ekle_fragment_6 extends Fragment {
Integer topat;
    Button btn,btn2;
    EditText ed,ed2,ed3,ed4,ed5;
    ProgressBar pr,pr2,pr3,pr4,pr5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff=inflater.inflate(R.layout.fragment_veri_ekle_fragment_6, container, false);
        btn = ff.findViewById(R.id.button14);btn2 = ff.findViewById(R.id.button13);veriaktarimi veri=(veriaktarimi) getArguments().getSerializable("key");
        topat=veri.getToplamatık();ed5=ff.findViewById(R.id.editTextNumber6o);
        ed=ff.findViewById(R.id.editTextNumber3);
        ed2=ff.findViewById(R.id.editTextNumber2);
        ed3=ff.findViewById(R.id.editTextNumber4);
        ed4=ff.findViewById(R.id.editTextNumber5);

        pr=ff.findViewById(R.id. progressBar2);
        pr2=ff.findViewById(R.id.progressBar4);
        pr3=ff.findViewById(R.id.progressBar5);
        pr4=ff.findViewById(R.id.progressBar6);
        pr5=ff.findViewById(R.id.progressBar7);
        pr.setMax(topat);
        pr2.setMax(topat);
        pr3.setMax(topat);
        pr4.setMax(topat);
        pr5.setMax(topat);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // NavController'ı bul ve ilkk eylemini gerçekleştir
                if(ed.getText().toString().length()>0 && ed2.getText().toString().length()>0 && ed3.getText().toString().length()>0 && ed4.getText().toString().length()>0 ){
                    Bundle bundle = new Bundle();
                    veri.setMetala(Integer.parseInt(ed.getText().toString()));
                    veri.setKağıta(Integer.parseInt(ed2.getText().toString()));
                    veri.setCama(Integer.parseInt(ed3.getText().toString()));
                    veri.setPlastika(Integer.parseInt(ed4.getText().toString()));
                    bundle.putSerializable("key", veri);
                    NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.yedi,bundle);
                }
                else{
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                    if (selectedLanguage.equals("es")) {
                        // İspanyolca için özel işlemler
                        Toast.makeText(ff.getContext(), "Por favor, complete todos los datos.", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("en")) {
                        // İngilizce için özel işlemler
                        Toast.makeText(ff.getContext(), "Please fill in all the data.", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("tr")) {
                        // Türkçe için özel işlemler
                        Toast.makeText(ff.getContext(), "Lütfen Verilerin Hepsini Doldurun.", Toast.LENGTH_SHORT).show();
                    } else {
                        Locale currentLocale = Locale.getDefault();
                        String currentLanguageCode = currentLocale.getLanguage();

                        if ("es".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "Por favor, complete todos los datos.", Toast.LENGTH_SHORT).show();


                        } else if ("en".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "Please fill in all the data.", Toast.LENGTH_SHORT).show();


                        } else if ("tr".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "Lütfen Verilerin Hepsini Doldurun.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ff.getContext(), "Lütfen Verilerin Hepsini Doldurun.", Toast.LENGTH_SHORT).show();
                        }
                    }








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
                Integer sayi2=0;
                Integer sayi3=0;
                Integer sayi4=0;

                 if(ed.getText().toString().equals("")==false){
                     sayi1=Integer.parseInt(ed.getText().toString());
                 }
                if(ed2.getText().toString().equals("")==false){
                    sayi2=Integer.parseInt(ed2.getText().toString());
                }
                if(ed3.getText().toString().equals("")==false){
                    sayi3=Integer.parseInt(ed3.getText().toString());
                }
                if(ed4.getText().toString().equals("")==false){
                    sayi4=Integer.parseInt(ed4.getText().toString());
                }
 if(sayi1+sayi2+sayi3+sayi4>topat){;
     SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
     String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil

     if (selectedLanguage.equals("es")) {
         // İspanyolca için özel işlemler
         Toast.makeText(ff.getContext(), "Has superado la cantidad total de residuos.", Toast.LENGTH_SHORT).show();
     } else if (selectedLanguage.equals("en")) {
         // İngilizce için özel işlemler
         Toast.makeText(ff.getContext(), "You have exceeded the total waste amount.", Toast.LENGTH_SHORT).show();
     } else if (selectedLanguage.equals("tr")) {
         // Türkçe için özel işlemler
         Toast.makeText(ff.getContext(), "Toplam Atık Miktarını Geçtin", Toast.LENGTH_SHORT).show();
     } else {
         Locale currentLocale = Locale.getDefault();
         String currentLanguageCode = currentLocale.getLanguage();


         if ("es".equals(currentLanguageCode)) {
             Toast.makeText(ff.getContext(), "Has superado la cantidad total de residuos.", Toast.LENGTH_SHORT).show();



         } else if ("en".equals(currentLanguageCode)) {
             Toast.makeText(ff.getContext(), "You have exceeded the total waste amount.", Toast.LENGTH_SHORT).show();



         } else if ("tr".equals(currentLanguageCode)) {
             Toast.makeText(ff.getContext(), "Toplam Atık Miktarını Geçtin", Toast.LENGTH_SHORT).show();
         } else {
             Toast.makeText(ff.getContext(), "Toplam Atık Miktarını Geçtin", Toast.LENGTH_SHORT).show();
         }
     }









     pr.setProgress(0);ed.setText("");

}
else{
     ed5.setText(String.valueOf(topat-(sayi1+sayi2+sayi3+sayi4)));
    pr.setProgress(sayi1);
    pr5.setProgress(topat-(sayi1+sayi2+sayi3+sayi4));
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
                Integer sayi2=0;
                Integer sayi3=0;
                Integer sayi4=0;

                if(ed.getText().toString().equals("")==false){
                    sayi1=Integer.parseInt(ed.getText().toString());
                }
                if(ed2.getText().toString().equals("")==false){
                    sayi2=Integer.parseInt(ed2.getText().toString());
                }
                if(ed3.getText().toString().equals("")==false){
                    sayi3=Integer.parseInt(ed3.getText().toString());
                }
                if(ed4.getText().toString().equals("")==false){
                    sayi4=Integer.parseInt(ed4.getText().toString());
                }
               if(sayi1+sayi2+sayi3+sayi4>topat){
                     pr2.setProgress(0);
                   SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                   String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil

                   if (selectedLanguage.equals("es")) {
                       // İspanyolca için özel işlemler
                       Toast.makeText(ff.getContext(), "Has superado la cantidad total de residuos.", Toast.LENGTH_SHORT).show();
                   } else if (selectedLanguage.equals("en")) {
                       // İngilizce için özel işlemler
                       Toast.makeText(ff.getContext(), "You have exceeded the total waste amount.", Toast.LENGTH_SHORT).show();
                   } else if (selectedLanguage.equals("tr")) {
                       // Türkçe için özel işlemler
                       Toast.makeText(ff.getContext(), "Toplam Atık Miktarını Geçtin", Toast.LENGTH_SHORT).show();
                   } else {
                       Locale currentLocale = Locale.getDefault();
                       String currentLanguageCode = currentLocale.getLanguage();

                       if ("es".equals(currentLanguageCode)) {
                           Toast.makeText(ff.getContext(), "Toplam Atık Miktarını Geçtin", Toast.LENGTH_SHORT).show();ed2.setText("");
                           ed2.setText("");



                       } else if ("en".equals(currentLanguageCode)) {
                           Toast.makeText(ff.getContext(), "You have exceeded the total waste amount.", Toast.LENGTH_SHORT).show();
                           ed2.setText("");



                       } else if ("tr".equals(currentLanguageCode)) {
                           Toast.makeText(ff.getContext(), "Toplam Atık Miktarını Geçtin", Toast.LENGTH_SHORT).show();ed2.setText("");
                       } else {
                           Toast.makeText(ff.getContext(), "Toplam Atık Miktarını Geçtin", Toast.LENGTH_SHORT).show();ed2.setText("");
                       }
                   }








                }else{
                    pr2.setProgress(sayi2);ed5.setText(String.valueOf(topat-(sayi1+sayi2+sayi3+sayi4)));
                    pr5.setProgress(topat-(sayi1+sayi2+sayi3+sayi4));
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
                Integer sayi2=0;
                Integer sayi3=0;
                Integer sayi4=0;
                if(ed.getText().toString().equals("")==false){
                    sayi1=Integer.parseInt(ed.getText().toString());
                }
                if(ed2.getText().toString().equals("")==false){
                    sayi2=Integer.parseInt(ed2.getText().toString());
                }
                if(ed3.getText().toString().equals("")==false){
                    sayi3=Integer.parseInt(ed3.getText().toString());
                }
                if(ed4.getText().toString().equals("")==false){
                    sayi4=Integer.parseInt(ed4.getText().toString());
                }
                 if(sayi1+sayi2+sayi3+sayi4>topat){
                     pr3.setProgress(0);
                     Toast.makeText(ff.getContext(), "Toplam Atık Miktarını Geçtin", Toast.LENGTH_SHORT).show();ed3.setText("");

                }else{
                    pr3.setProgress(sayi3);ed5.setText(String.valueOf(topat-(sayi1+sayi2+sayi3+sayi4)));
                    pr5.setProgress(topat-(sayi1+sayi2+sayi3+sayi4));
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
                Integer sayi2=0;
                Integer sayi3=0;
                Integer sayi4=0;
                if(ed.getText().toString().equals("")==false){
                    sayi1=Integer.parseInt(ed.getText().toString());
                }
                if(ed2.getText().toString().equals("")==false){
                    sayi2=Integer.parseInt(ed2.getText().toString());
                }
                if(ed3.getText().toString().equals("")==false){
                    sayi3=Integer.parseInt(ed3.getText().toString());
                }
                if(ed4.getText().toString().equals("")==false){
                    sayi4=Integer.parseInt(ed4.getText().toString());
                }
                 if(sayi1+sayi2+sayi3+sayi4>topat){
                     pr4.setProgress(0);


                     SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                     String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil

                     if (selectedLanguage.equals("es")) {
                         Toast.makeText(ff.getContext(), "Has superado la cantidad total de residuos.", Toast.LENGTH_SHORT).show();
                     } else if (selectedLanguage.equals("en")) {
                         // İngilizce için özel işlemler
                         Toast.makeText(ff.getContext(), "You have exceeded the total waste amount.", Toast.LENGTH_SHORT).show();
                     } else if (selectedLanguage.equals("tr")) {
                         // Türkçe için özel işlemler
                         Toast.makeText(ff.getContext(), "Toplam Atık Miktarını Geçtin", Toast.LENGTH_SHORT).show();
                     } else {
                         Locale currentLocale = Locale.getDefault();
                         String currentLanguageCode = currentLocale.getLanguage();

                         if ("es".equals(currentLanguageCode)) {
                             Toast.makeText(ff.getContext(), "Has superado la cantidad total de residuos.", Toast.LENGTH_SHORT).show();
                             ed4.setText("");



                         } else if ("en".equals(currentLanguageCode)) {
                             Toast.makeText(ff.getContext(), "You have exceeded the total waste amount.", Toast.LENGTH_SHORT).show();
                             ed4.setText("");



                         } else if ("tr".equals(currentLanguageCode)) {
                             Toast.makeText(ff.getContext(), "Toplam Atık Miktarını Geçtin", Toast.LENGTH_SHORT).show();ed4.setText("");
                         } else {
                             Toast.makeText(ff.getContext(), "Toplam Atık Miktarını Geçtin", Toast.LENGTH_SHORT).show();ed4.setText("");
                         }
                     }








                }else{
                    pr4.setProgress(sayi4);ed5.setText(String.valueOf(topat-(sayi1+sayi2+sayi3+sayi4)));
                    pr5.setProgress(topat-(sayi1+sayi2+sayi3+sayi4));
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
                navController.navigate(R.id.yedit,bundle);
            }
        });
        return ff;
    }
}