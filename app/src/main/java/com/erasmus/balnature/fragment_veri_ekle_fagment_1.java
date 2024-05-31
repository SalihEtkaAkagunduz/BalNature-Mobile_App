package com.erasmus.balnature;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;


public class fragment_veri_ekle_fagment_1 extends Fragment {


Button btn,btn2;
EditText edt,edt2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff=inflater.inflate(R.layout.fragment_veri_ekle_fagment_1, container, false);
        btn = ff.findViewById(R.id.button14);
        btn2 = ff.findViewById(R.id.button13);
        edt=ff.findViewById(R.id.editTextText);
        edt2=ff.findViewById(R.id.editTextText2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // NavController'ı bul ve ilkk eylemini gerçekleştir
                if(edt.getText().toString().length()>0 && edt2.getText().toString().length()>0 ) {
                    Bundle bundle = new Bundle();
                    veriaktarimi veri=new veriaktarimi();
                    veri.setAd(edt.getText().toString());
                    veri.setAçiklama(edt2.getText().toString().toString());
                    bundle.putSerializable("key", veri); // Veri gönderme işlemi, veri türüne göre değişebilir


                    NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.iki,bundle);
                }
                else{
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                    if (selectedLanguage.equals("es")) {
                        Toast.makeText(getContext(), "Registro creado exitosamente", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("en")) {
                        Toast.makeText(ff.getContext(), "Lütfen Belirtile Alanları Doldurunuz", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("tr")) {
                        Toast.makeText(ff.getContext(), "Lütfen Belirtile Alanları Doldurunuz", Toast.LENGTH_SHORT).show();
                    } else {
                        Locale currentLocale = Locale.getDefault();
                        String currentLanguageCode = currentLocale.getLanguage();

                        if ("es".equals(currentLanguageCode)) {
                            Toast.makeText(getContext(), "Registro creado exitosamente", Toast.LENGTH_SHORT).show();

                        } else if ("en".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "Please fill in the specified fields", Toast.LENGTH_SHORT).show();


                        } else if ("tr".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "Lütfen Belirtile Alanları Doldurunuz", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ff.getContext(), "Lütfen Belirtile Alanları Doldurunuz", Toast.LENGTH_SHORT).show();
                        }
                    }




                }


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // NavController'ı bul ve ilkk eylemini gerçekleştir
                Bundle bundle = new Bundle();
                veriaktarimi veri=new veriaktarimi();
                bundle.putSerializable("key", veri);
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.ikit,bundle);
            }
        });
        return ff;
    }
}