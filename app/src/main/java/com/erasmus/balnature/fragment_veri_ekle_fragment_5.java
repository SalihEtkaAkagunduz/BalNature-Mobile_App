package com.erasmus.balnature;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;


public class fragment_veri_ekle_fragment_5 extends Fragment {

    Button btn, btn2;
    EditText ed;
    TextView tx;
    ProgressBar pr;
    Integer ortalama = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff = inflater.inflate(R.layout.fragment_veri_ekle_fragment_5, container, false);
        veriaktarimi veri = (veriaktarimi) getArguments().getSerializable("key");
        btn = ff.findViewById(R.id.button14);
        btn2 = ff.findViewById(R.id.button13);
        ed = ff.findViewById(R.id.editTextNumber);
        tx = ff.findViewById(R.id.textVie8w84);
        pr = ff.findViewById(R.id.progressBar3);
        DatabaseReference databaseRef, databaseRef2, databaseRef3;
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference("kullanicilar/" + mAuth.getUid().toString());
        databaseRef2 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("kayitsayisi");
        databaseRef3 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("toplamortalama");
        databaseRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ortalama = (Integer) snapshot.getValue(Integer.class);
                if (ortalama == 0) {

                    pr.setMax(100);
                } else {
                    pr.setMax(ortalama * 2);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                if (selectedLanguage.equals("es")) {
                    if (ortalama == 0) {
                        pr.setProgress(ortalama);
                        tx.setText("Daha İlk Veri Girişin Endişeye Gerek Yok Ama Herzaman Daha Az Atık Daha İyidir");
                    }
                    else {
                        if (ortalama == 0) {
                            pr.setProgress(ortalama);
                            tx.setText("Esta es tu primera entrada de datos. No te preocupes, pero recuerda que menos desperdicio siempre es mejor.");
                        } else {
                            if (ed.getText().toString().length() > 0) {
                                int userWaste = Integer.parseInt(ed.getText().toString());
                                pr.setProgress(userWaste);
                                if (userWaste < ortalama) {
                                    tx.setText("¡Genial! La cantidad de residuos que has generado hoy está por debajo del promedio. ¡Bien hecho, sigue así!");
                                } else if (userWaste == ortalama) {
                                    tx.setText("¡Increíble! La cantidad de residuos que has generado coincide con el promedio. ¡Sigue así!");
                                } else {
                                    tx.setText("¡Ups! La cantidad de residuos que has generado está por encima del promedio. BALNature recomienda encontrar una solución para esto.");
                                }
                            } else {
                                pr.setProgress(0);
                            }
                        }
                    }
                } else if (selectedLanguage.equals("en")) {
                    if (ortalama == 0) {
                        pr.setProgress(ortalama);
                        tx.setText("This is your first data entry. No need to worry, but remember, less waste is always better.");
                    } else {
                        if (ed.getText().toString().length() > 0) {
                            int userWaste = Integer.parseInt(ed.getText().toString());
                            pr.setProgress(userWaste);
                            if (userWaste < ortalama) {
                                tx.setText("Great! Your waste amount for today is below the average. Well done, keep it up!");
                            } else if (userWaste == ortalama) {
                                tx.setText("Incredible! Your waste amount matches the average. Keep it up!");
                            } else {
                                tx.setText("Uh-oh! Your waste amount is above the average. BALNature recommends finding a solution for this.");
                            }
                        } else {
                            pr.setProgress(0);
                        }
                    }
                } else if (selectedLanguage.equals("tr")) {
                    if (ortalama == 0) {
                        pr.setProgress(ortalama);
                        tx.setText("Daha İlk Veri Girişin Endişeye Gerek Yok Ama Herzaman Daha Az Atık Daha İyidir");
                    }
                    else{
                        if(ed.getText().toString().length()>0){
                            if (Integer.parseInt(ed.getText().toString()) < ortalama) {
                                pr.setProgress(Integer.parseInt(ed.getText().toString()));
                                tx.setText("Harika! bugünkü Atık Ortalamanız Ortlamanın Altına Afferin Asker Böyle Devam  Et");
                            }
                            if (Integer.parseInt(ed.getText().toString()) == ortalama) {
                                pr.setProgress(Integer.parseInt(ed.getText().toString()));
                                tx.setText("İnanılmaz!  Atık miktarınız Tam Ortalamada Böyle Devam ");
                            }
                            if (Integer.parseInt(ed.getText().toString()) > ortalama) {

                                pr.setProgress(Integer.parseInt(ed.getText().toString()));
                                tx.setText("Eyvah! Atık Miktarın Ortalamanın Üzerinde BALNature Olarak Buna bir çare bulmanı öneririz");
                            }
                        }
                        else{
                            pr.setProgress(0);
                        }

                    }
                } else {
                    Locale currentLocale = Locale.getDefault();
                    String currentLanguageCode = currentLocale.getLanguage();

                    if ("es".equals(currentLanguageCode)) {
                        if (ortalama == 0) {
                            pr.setProgress(ortalama);
                            tx.setText("Daha İlk Veri Girişin Endişeye Gerek Yok Ama Herzaman Daha Az Atık Daha İyidir");
                        }
                        else {
                            if (ortalama == 0) {
                                pr.setProgress(ortalama);
                                tx.setText("Esta es tu primera entrada de datos. No te preocupes, pero recuerda que menos desperdicio siempre es mejor.");
                            } else {
                                if (ed.getText().toString().length() > 0) {
                                    int userWaste = Integer.parseInt(ed.getText().toString());
                                    pr.setProgress(userWaste);
                                    if (userWaste < ortalama) {
                                        tx.setText("¡Genial! La cantidad de residuos que has generado hoy está por debajo del promedio. ¡Bien hecho, sigue así!");
                                    } else if (userWaste == ortalama) {
                                        tx.setText("¡Increíble! La cantidad de residuos que has generado coincide con el promedio. ¡Sigue así!");
                                    } else {
                                        tx.setText("¡Ups! La cantidad de residuos que has generado está por encima del promedio. BALNature recomienda encontrar una solución para esto.");
                                    }
                                } else {
                                    pr.setProgress(0);
                                }
                            }
                        }

                    } else if ("en".equals(currentLanguageCode)) {
                        if (ortalama == 0) {
                            pr.setProgress(ortalama);
                            tx.setText("This is your first data entry. No need to worry, but remember, less waste is always better.");
                        } else {
                            if (ed.getText().toString().length() > 0) {
                                int userWaste = Integer.parseInt(ed.getText().toString());
                                pr.setProgress(userWaste);
                                if (userWaste < ortalama) {
                                    tx.setText("Great! Your waste amount for today is below the average. Well done, keep it up!");
                                } else if (userWaste == ortalama) {
                                    tx.setText("Incredible! Your waste amount matches the average. Keep it up!");
                                } else {
                                    tx.setText("Uh-oh! Your waste amount is above the average. BALNature recommends finding a solution for this.");
                                }
                            } else {
                                pr.setProgress(0);
                            }
                        }


                    } else if ("tr".equals(currentLanguageCode)) {
                        if (ortalama == 0) {
                            pr.setProgress(ortalama);
                            tx.setText("Daha İlk Veri Girişin Endişeye Gerek Yok Ama Herzaman Daha Az Atık Daha İyidir");
                        }
                        else{
                            if(ed.getText().toString().length()>0){
                                if (Integer.parseInt(ed.getText().toString()) < ortalama) {
                                    pr.setProgress(Integer.parseInt(ed.getText().toString()));
                                    tx.setText("Harika! bugünkü Atık Ortalamanız Ortlamanın Altına Afferin Asker Böyle Devam  Et");
                                }
                                if (Integer.parseInt(ed.getText().toString()) == ortalama) {
                                    pr.setProgress(Integer.parseInt(ed.getText().toString()));
                                    tx.setText("İnanılmaz!  Atık miktarınız Tam Ortalamada Böyle Devam ");
                                }
                                if (Integer.parseInt(ed.getText().toString()) > ortalama) {

                                    pr.setProgress(Integer.parseInt(ed.getText().toString()));
                                    tx.setText("Eyvah! Atık Miktarın Ortalamanın Üzerinde BALNature Olarak Buna bir çare bulmanı öneririz");
                                }
                            }
                            else{
                                pr.setProgress(0);
                            }

                        }
                    } else {
                        if (ortalama == 0) {
                            pr.setProgress(ortalama);
                            tx.setText("Daha İlk Veri Girişin Endişeye Gerek Yok Ama Herzaman Daha Az Atık Daha İyidir");
                        }
                        else{
                            if(ed.getText().toString().length()>0){
                                if (Integer.parseInt(ed.getText().toString()) < ortalama) {
                                    pr.setProgress(Integer.parseInt(ed.getText().toString()));
                                    tx.setText("Harika! bugünkü Atık Ortalamanız Ortlamanın Altına Afferin Asker Böyle Devam  Et");
                                }
                                if (Integer.parseInt(ed.getText().toString()) == ortalama) {
                                    pr.setProgress(Integer.parseInt(ed.getText().toString()));
                                    tx.setText("İnanılmaz!  Atık miktarınız Tam Ortalamada Böyle Devam ");
                                }
                                if (Integer.parseInt(ed.getText().toString()) > ortalama) {

                                    pr.setProgress(Integer.parseInt(ed.getText().toString()));
                                    tx.setText("Eyvah! Atık Miktarın Ortalamanın Üzerinde BALNature Olarak Buna bir çare bulmanı öneririz");
                                }
                            }
                            else{
                                pr.setProgress(0);
                            }

                        }
                    }
                }







            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // NavController'ı bul ve ilkk eylemini gerçekleştir
                if (ed.getText().toString().length() > 0) {
                    Bundle bundle = new Bundle();
                    veri.setToplamatık(Integer.parseInt(ed.getText().toString()));
                    bundle.putSerializable("key", veri);
                    NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.altı, bundle);
                } else {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                    if (selectedLanguage.equals("es")) {
                        Toast.makeText(ff.getContext(), "Por favor, ingrese la cantidad total de residuos", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("en")) {
                        Toast.makeText(ff.getContext(), "Please enter the total waste amount", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("tr")) {
                        Toast.makeText(ff.getContext(), "Lütfen Toplam Atık Miktarını Girin.", Toast.LENGTH_SHORT).show();
                    } else {
                        Locale currentLocale = Locale.getDefault();
                        String currentLanguageCode = currentLocale.getLanguage();

                        if ("es".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "Por favor, ingrese la cantidad total de residuos", Toast.LENGTH_SHORT).show();


                        } else if ("en".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "Please enter the total waste amount", Toast.LENGTH_SHORT).show();


                        } else if ("tr".equals(currentLanguageCode)) {
                            Toast.makeText(ff.getContext(), "Lütfen Toplam Atık Miktarını Girin.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ff.getContext(), "Lütfen Toplam Atık Miktarını Girin.", Toast.LENGTH_SHORT).show();
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
                bundle.putSerializable("key", veri);
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.altıt, bundle);
            }
        });
        return ff;
    }
}