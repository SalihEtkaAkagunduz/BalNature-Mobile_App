package com.erasmus.balnature;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;


public class fragment_login_isim extends Fragment {

Button btn;
EditText txt,txt2,txt3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff=inflater.inflate(R.layout.fragment_login_isim, container, false);
        fragment_login_isimArgs gg=fragment_login_isimArgs.fromBundle(getArguments());
        String email=gg.getEmail();
        String parola=gg.getParola();
        btn=ff.findViewById(R.id.button6);
        txt=ff.findViewById(R.id.mail_et2);
        txt2=ff.findViewById(R.id.password_et2);
        txt3=ff.findViewById(R.id.password_et3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt.getText().toString().length()>=3&&txt2.getText().toString().length()>=2){
                    fragment_login_isimDirections.ActionFragmentLoginIsimToFragmentLoginTarih g= fragment_login_isimDirections.actionFragmentLoginIsimToFragmentLoginTarih();
                    g.setEmail(email);
g.setAd(txt.getText().toString());
                    g.setSoyisim(txt2.getText().toString());
                    g.setParola(parola);

                    g.setMetin(txt3.getText().toString());
                    Navigation.findNavController(ff).navigate(g);
                }
                else {

                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                    if (selectedLanguage.equals("es")) {
                        // İspanyolca için özel işlemler
                        Snackbar.make(ff, "Por favor, complete los campos de Nombre y Apellido", Snackbar.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("en")) {
                        // İngilizce için özel işlemler
                        Snackbar.make(ff, "Please fill in the Name and Surname fields", Snackbar.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("tr")) {
                        // Türkçe için özel işlemler
                        Snackbar.make(ff,"Lütfen İsim ve Soyisim alanlarını doldurun",Snackbar.LENGTH_SHORT);
                    } else {
                        Locale currentLocale = Locale.getDefault();
                        String currentLanguageCode = currentLocale.getLanguage();

                        if ("es".equals(currentLanguageCode)) {
                            Snackbar.make(ff, "Por favor, complete los campos de Nombre y Apellido", Snackbar.LENGTH_SHORT).show();

                        } else if ("en".equals(currentLanguageCode)) {
                            Snackbar.make(ff, "Please fill in the Name and Surname fields", Snackbar.LENGTH_SHORT).show();

                        } else if ("tr".equals(currentLanguageCode)) {
                            Snackbar.make(ff,"Lütfen İsim ve Soyisim alanlarını doldurun",Snackbar.LENGTH_SHORT);
                        } else {
                            Snackbar.make(ff, "Lütfen İsim ve Soyisim alanlarını doldurun", Snackbar.LENGTH_SHORT);
                        }
                    }





                }

            }
        });
        return ff;
    }
}