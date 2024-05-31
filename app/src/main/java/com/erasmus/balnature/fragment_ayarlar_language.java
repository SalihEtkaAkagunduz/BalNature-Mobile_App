package com.erasmus.balnature;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Locale;


public class fragment_ayarlar_language extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ff=inflater.inflate(R.layout.fragment_ayarlar_language, container, false);
        ConstraintLayout layout1 = ff.findViewById(R.id.constraintLayout59);
        ConstraintLayout layout2 = ff.findViewById((R.id.constraintLayout60));
        ConstraintLayout layout3 = ff.findViewById(R.id.constraintLayout61);
        ConstraintLayout layout4 = ff.findViewById(R.id.constraintLayout62);
        ConstraintLayout layout5 = ff.findViewById(R.id.constraintLayout66);
layout1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("selectedLanguage", "varsayılan"); // selectedLanguage kullanıcının seçtiği dil
        editor.apply();Navigation.findNavController(view).navigate(R.id.fragment_ayarlar_ana);

        Locale currentLocale = Locale.getDefault();
        String currentLanguageCode = currentLocale.getLanguage();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

        if ("es".equals(currentLanguageCode)) {

            alertDialogBuilder.setTitle("Advertencia");
            alertDialogBuilder.setMessage("La aplicación se reiniciará para que el cambio se pueda aplicar a todas las unidades.");
            alertDialogBuilder.setPositiveButton("De acuerdo", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // "Evet" düğmesine tıklandığında yapılacak işlemleri buraya ekleyebilirsiniz
                    dialog.dismiss();
                    Intent intent = getActivity().getIntent();
                    getActivity().finish();
                    startActivity(intent);


                }
            });


        } else if ("en".equals(currentLanguageCode)) {
            alertDialogBuilder.setTitle("Warning");
            alertDialogBuilder.setMessage("The application will be restarted so that the change can be applied to all units.");
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // "Evet" düğmesine tıklandığında yapılacak işlemleri buraya ekleyebilirsiniz
                    dialog.dismiss();
                    Intent intent = getActivity().getIntent();
                    getActivity().finish();
                    startActivity(intent);


                }
            });



        } else if ("tr".equals(currentLanguageCode)) {
            alertDialogBuilder.setTitle("Uyarı");
            alertDialogBuilder.setMessage("Değişikliğin tüm birimlere uygulanabilmesi için uygulama yensiden başlatılacak.");
            alertDialogBuilder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // "Evet" düğmesine tıklandığında yapılacak işlemleri buraya ekleyebilirsiniz
                    dialog.dismiss();
                    Intent intent = getActivity().getIntent();
                    getActivity().finish();
                    startActivity(intent);


                }
            });
        } else {
            alertDialogBuilder.setTitle("Uyarı");
            alertDialogBuilder.setMessage("Değişikliğin tüm birimlere uygulanabilmesi için uygulama yensiden başlatılacak.");
            alertDialogBuilder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // "Evet" düğmesine tıklandığında yapılacak işlemleri buraya ekleyebilirsiniz
                    dialog.dismiss();
                    Intent intent = getActivity().getIntent();
                    getActivity().finish();
                    startActivity(intent);


                }
            });
        }
        Locale.setDefault(currentLocale);
        Configuration config = new Configuration();
        config.locale = currentLocale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        Navigation.findNavController(view).navigate(R.id.fragment_ayarlar_ana);


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
});
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("selectedLanguage", "tr"); // selectedLanguage kullanıcının seçtiği dil
                editor.apply();

                // Yeni bir dil seçildiğinde
                String selectedLanguage = "tr"; // Kullanıcının seçtiği dili alın (örneğin "en" İngilizce için)
                Locale newLocale = new Locale(selectedLanguage);
                Locale.setDefault(newLocale);
                Configuration config = new Configuration();
                config.locale = newLocale;
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                Navigation.findNavController(view).navigate(R.id.fragment_ayarlar_ana);


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setTitle("Uyarı");
                alertDialogBuilder.setMessage("Değişikliğin tüm birimlere uygulanabilmesi için uygulama yensiden başlatılacak.");
                alertDialogBuilder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Evet" düğmesine tıklandığında yapılacak işlemleri buraya ekleyebilirsiniz
                        dialog.dismiss();
                        Intent intent = getActivity().getIntent();
                        getActivity().finish();
                        startActivity(intent);


                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Yeni bir dil seçildiğinde

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("selectedLanguage", "en"); // selectedLanguage kullanıcının seçtiği dil
                editor.apply();
                String selectedLanguage = "en"; // Seçilen dili alın (örneğin "en" İngilizce için)
                Locale newLocale = new Locale(selectedLanguage);
                Locale.setDefault(newLocale);
                Configuration config = new Configuration();
                config.locale = newLocale;
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                Navigation.findNavController(view).navigate(R.id.fragment_ayarlar_ana);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setTitle("Warning");
                alertDialogBuilder.setMessage("The application will be restarted so that the change can be applied to all units.");
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Evet" düğmesine tıklandığında yapılacak işlemleri buraya ekleyebilirsiniz
                        dialog.dismiss();
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);


                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


            }
        });
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Yeni bir dil seçildiğinde
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("selectedLanguage", "es"); // selectedLanguage kullanıcının seçtiği dil
                editor.apply();
                String selectedLanguage = "es"; // Kullanıcının seçtiği dili alın (örneğin "en" İngilizce için)
                Locale newLocale = new Locale(selectedLanguage);
                Locale.setDefault(newLocale);
                Configuration config = new Configuration();
                config.locale = newLocale;
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                Navigation.findNavController(view).navigate(R.id.fragment_ayarlar_ana);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setTitle("Advertencia");
                alertDialogBuilder.setMessage("La aplicación se reiniciará para que el cambio se pueda aplicar a todas las unidades.");
                alertDialogBuilder.setPositiveButton("De acuerdo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Evet" düğmesine tıklandığında yapılacak işlemleri buraya ekleyebilirsiniz
                        dialog.dismiss();
                        Intent intent = getActivity().getIntent();
                        getActivity().finish();
                        startActivity(intent);


                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragment_ayarlar_ana);


            }
        });
        setTouchListener(layout1);
        setTouchListener(layout2);
        setTouchListener(layout3);
        setTouchListener(layout4);
        setTouchListener(layout5);
        return  ff;
    }
    private void setTouchListener(final ConstraintLayout layout) {
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Üzerine gelindiğinde buraya kod ekleyin
                        // Arka plan rengini değiştirin veya diğer işlemleri gerçekleştirin
                        layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.renkiste));
                        break;
                    case MotionEvent.ACTION_UP:
                        // Dokunma bittiğinde buraya kod ekleyin
                        // Arka plan rengini geri döndürün veya diğer işlemleri gerçekleştirin
                        layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.renkaa));

                            v.performClick();


                        break;
                    case MotionEvent.ACTION_CANCEL:
                        // Dokunma iptal edildiğinde buraya kod ekleyin
                        // Arka plan rengini geri döndürün veya diğer işlemleri gerçekleştirin
                        layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.renkaa));
                        break;
                }
                return true; // true döndürerek olayın tüketildiğini belirtin
            }
        });
    }
}