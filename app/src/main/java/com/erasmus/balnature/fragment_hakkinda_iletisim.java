package com.erasmus.balnature;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;

public class fragment_hakkinda_iletisim extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff=inflater.inflate(R.layout.fragment_hakkinda_iletisim, container, false);
        TextView txt=ff.findViewById(R.id.textView24);
        TextView txt2=ff.findViewById(R.id.textView26);
        TextView txt3=ff.findViewById(R.id.textView27);
        TextView txt4=ff.findViewById(R.id.textView28);
        TextView txt5=ff.findViewById(R.id.textView29);
        TextView txt6=ff.findViewById(R.id.textView36);
        Button btn=ff.findViewById(R.id.button2);
        Button btn1=ff.findViewById(R.id.button3);
        TextInputLayout tıp=ff.findViewById(R.id.textInputLayout);
        TextInputLayout tıp2=ff.findViewById(R.id.textInputLayout2);
        CheckBox cb=ff.findViewById(R.id.checkBox);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://balnatureerasmus.wixsite.com/balnature"));
                startActivity(intent);

            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String instagramUrl = "https://www.instagram.com/balnature.erasmus";
                Intent intent;

// Instagram uygulaması yüklü ise
                if (isAppInstalled("com.instagram.android")) {
                    // Instagram uygulamasını açmak için Intent oluştur
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_u/balnature.erasmus"));
                    intent.setPackage("com.instagram.android");
                } else {
                    // Instagram uygulaması yüklü değilse, varsayılan tarayıcıda açmak için Intent oluştur
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));
                }

// Intent'i başlat
                requireActivity().startActivity(intent);
            }
                private boolean isAppInstalled(String packageName) {
                PackageManager packageManager = getActivity().getPackageManager();
                try {
                    packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
                    return true;
                } catch (PackageManager.NameNotFoundException e) {
                    return false;
                }
            }
        });
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822"); // E-posta türünü belirtin
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"salihetkaakagunduz@gmail.com"}); // Alıcının e-posta adresini belirtin
                // E-posta içeriğini belirtin
                startActivity(intent);
            }
        });
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = "Bursa Anadolu  Lisesi"; // Kullanıcının girdiği konumu burada varsayalım

                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(location));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    // Harita uygulaması bulunuyorsa
                    startActivity(mapIntent);
                } else {
                    // Harita uygulaması bulunmuyorsa
                    Uri googleMapsUri = Uri.parse("https://goo.gl/maps/AXtDCqVFRxr7HBxk7");
                    Intent googleMapsIntent = new Intent(Intent.ACTION_VIEW, googleMapsUri);

                    if (googleMapsIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        // Varsayılan tarayıcıda Google Haritalar'ı aç
                        startActivity(googleMapsIntent);
                    } else {
                        // Uygun bir harita uygulaması veya tarayıcı bulunamadı
                        Toast.makeText(ff.getContext(), "Harita uygulaması bulunamadı", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tıp.getEditText().setText("");
                tıp2.getEditText().setText("");
                cb.setChecked(false);

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(tıp.getEditText().getText().toString().isEmpty()==false && tıp2.getEditText().getText().toString().isEmpty()==false){
                    if (cb.isChecked()){
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("message/rfc822"); // E-posta türünü belirtin
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"salihetkaakagunduz@gmail.com"}); // Alıcının e-posta adresini belirtin
                        intent.putExtra(Intent.EXTRA_SUBJECT,tıp.getEditText().getText().toString() ); // E-posta konusunu belirtin
                        intent.putExtra(Intent.EXTRA_TEXT, tıp2.getEditText().getText().toString());
                        startActivity(intent);// E-posta içeriğini belirtin
                    }
                    else {
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                        String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                        if (selectedLanguage.equals("es")) {
                            // İspanyolca için özel işlemler
                            Snackbar.make(view, "Por favor acepte el contrato", Snackbar.LENGTH_SHORT).show();
                        } else if (selectedLanguage.equals("en")) {
                            // İngilizce için özel işlemler
                            Snackbar.make(view, "Please accept the contract", Snackbar.LENGTH_SHORT).show();
                        } else if (selectedLanguage.equals("tr")) {
                            // Türkçe için özel işlemler
                            Snackbar.make(view, "Lütfen sözleşmeyi kabul edin", Snackbar.LENGTH_SHORT).show();
                        } else {
                            Locale currentLocale = Locale.getDefault();
                            String currentLanguageCode = currentLocale.getLanguage();

                            if ("es".equals(currentLanguageCode)) {
                                // İspanyolca için özel işlemler
                                Snackbar.make(view, "Por favor acepte el contrato", Snackbar.LENGTH_SHORT).show();
                            } else if ("en".equals(currentLanguageCode)) {
                                // İngilizce için özel işlemler
                                Snackbar.make(view, "Please accept the contract", Snackbar.LENGTH_SHORT).show();
                            } else if ("tr".equals(currentLanguageCode)) {
                                // Türkçe için özel işlemler
                                Snackbar.make(view, "Lütfen sözleşmeyi kabul edin", Snackbar.LENGTH_SHORT).show();
                            } else {
                                // Desteklenmeyen diller için varsayılan işlem
                                Snackbar.make(view, "Lütfen sözleşmeyi kabul edin", Snackbar.LENGTH_SHORT).show();
                            }
                        }




                    }
                }
                else{

                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                    if (selectedLanguage.equals("es")) {
                        // İspanyolca için özel işlemler
                        Snackbar.make(view, "Por favor complete las expresiones de texto especificadas.", Snackbar.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("en")) {
                        // İngilizce için özel işlemler
                        Snackbar.make(view, "Please fill in the specified text expressions", Snackbar.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("tr")) {
                        // Türkçe için özel işlemler
                        Snackbar.make(view, "Lütfen belitilen metin ifadelerini doldurun", Snackbar.LENGTH_SHORT).show();
                    } else {
                        Locale currentLocale = Locale.getDefault();
                        String currentLanguageCode = currentLocale.getLanguage();

                        if ("es".equals(currentLanguageCode)) {
                            // İspanyolca için özel işlemler
                            Snackbar.make(view, "Por favor complete las expresiones de texto especificadas.", Snackbar.LENGTH_SHORT).show();
                        } else if ("en".equals(currentLanguageCode)) {
                            // İngilizce için özel işlemler
                            Snackbar.make(view, "Please fill in the specified text expressions", Snackbar.LENGTH_SHORT).show();
                        } else if ("tr".equals(currentLanguageCode)) {
                            // Türkçe için özel işlemler
                            Snackbar.make(view, "Lütfen belitilen metin ifadelerini doldurun", Snackbar.LENGTH_SHORT).show();
                        } else {
                            // Desteklenmeyen diller için varsayılan işlem
                            Snackbar.make(view, "Lütfen belitilen metin ifadelerini doldurun", Snackbar.LENGTH_SHORT).show();
                        }
                    }






                }


            }
        });


        return ff;
    }
}