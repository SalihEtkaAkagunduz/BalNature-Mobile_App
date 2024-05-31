package com.erasmus.balnature;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class fragment_veri_ekle_fragment_8 extends Fragment {
    ProgressBar pr, pr1, pr2, pr3, pr4, pr5, pr6, pr7, pr8, pr9, pr10, pr11, pr12, pr13, pr14, pr15;
    int id, ortalama, topcam, topkagıt, tokmetal, topplastik, toastt;
    TextView tx;
    RatingBar rt;
    Button btn, btn2;
    NavController navController;
    ProgressBar prr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff = inflater.inflate(R.layout.fragment_veri_ekle_fragment_8, container, false);
        DatabaseReference databaseRef, databaseRef2, databaseRef3, databaseRef4, databaseRef5, databaseRef6, databaseRef7;
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference("kullanicilar/" + mAuth.getUid().toString());
        databaseRef2 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("kayitsayisi");
        databaseRef3 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("toplamortalama");
        databaseRef4 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("metalortlama");
        databaseRef5 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("kagitortalama");
        databaseRef6 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("camortalama");
        databaseRef7 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("plastikortalama");
        veriaktarimi veri = (veriaktarimi) getArguments().getSerializable("key");

        databaseRef7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                topplastik = (Integer) snapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseRef6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                topcam = (Integer) snapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                topkagıt = (Integer) snapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tokmetal = (Integer) snapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ortalama = (Integer) snapshot.getValue(Integer.class);
                if (ortalama == 0) {
                    pr11.setMax(100);
                    pr12.setMax(100);
                    pr13.setMax(100);
                    pr14.setMax(100);
                    pr15.setMax(100);
                } else {
                    pr11.setMax(ortalama*2);
                    pr12.setMax(tokmetal);
                    pr13.setMax(topcam);
                    pr14.setMax(topkagıt);
                    pr15.setMax(topplastik);
                }


                if (ortalama == 0) {
                    pr11.setProgress(50);
                    pr12.setProgress(50);
                    pr13.setProgress(50);
                    pr14.setProgress(50);
                    pr15.setProgress(50);
                } else {
                    pr11.setProgress(veri.toplamatık);
                    pr12.setProgress(veri.metala);
                    pr13.setProgress(veri.cama);
                    pr14.setProgress(veri.kağıta);
                    pr15.setProgress(veri.plastika);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        toastt = 0;
        pr = ff.findViewById(R.id.progressBar9);
        pr2 = ff.findViewById(R.id.progressBar8);
        pr3 = ff.findViewById(R.id.progressBar10);
        pr4 = ff.findViewById(R.id.progressBar11);
        pr5 = ff.findViewById(R.id.progressBar12);
        pr6 = ff.findViewById(R.id.progressBar133);
        pr7 = ff.findViewById(R.id.progressBar16);
        pr8 = ff.findViewById(R.id.progressBar14);
        pr9 = ff.findViewById(R.id.progressBar17);
        pr10 = ff.findViewById(R.id.progressBar15);
        pr11 = ff.findViewById(R.id.progressBar13);
        pr12 = ff.findViewById(R.id.progressBar18);
        pr13 = ff.findViewById(R.id.progressBar21);
        pr14 = ff.findViewById(R.id.progressBar19);
        pr15 = ff.findViewById(R.id.progressBar20);
        tx = ff.findViewById(R.id.textView97);
        rt = ff.findViewById(R.id.ratingBar);

        btn = ff.findViewById(R.id.button14);
        btn2 = ff.findViewById(R.id.button13);


        pr.setMax(veri.toplamatık);
        pr2.setMax(veri.toplamatık);
        pr3.setMax(veri.toplamatık);
        pr4.setMax(veri.toplamatık);
        pr5.setMax(veri.toplamatık);
        pr.setProgress(veri.metala);
        pr2.setProgress(veri.cama);
        pr3.setProgress(veri.kağıta);
        pr4.setProgress(veri.plastika);
        pr5.setProgress(veri.toplamatık - (veri.metala + veri.cama + veri.kağıta + veri.plastika));


        pr6.setMax(veri.toplamatık);
        pr7.setMax(veri.metala);
        pr8.setMax(veri.cama);
        pr9.setMax(veri.kağıta);
        pr10.setMax(veri.plastika);
        pr6.setProgress((veri.metalg + veri.camg + veri.kağıtg + veri.platikg));
        pr7.setProgress(veri.camg);
        pr8.setProgress(veri.camg);
        pr9.setProgress(veri.kağıtg);
        pr10.setProgress(veri.platikg);



        LocalDate bugun = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String bugunString = bugun.format(formatter);


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil

        if (selectedLanguage.equals("es")) {
            tx.setText("Hola, el registro que realizó el " + bugunString + " sido añadido a nuestro sistema. Puede continuar presionando el botón 'Finalizar'.");
        } else if (selectedLanguage.equals("en")) {
            tx.setText("Hello, the record you made on " + bugunString + " has been added to our system. You can continue by pressing the 'Finish' button.");
        } else if (selectedLanguage.equals("tr")) {
            tx.setText("Merhaba, " + bugunString + " tarihinde yaptığınız kayıt sistemimize eklenmiştir 'Bitir' Tuşuna basarak devam edebilirsiniz. ");
        } else {
            Locale currentLocale = Locale.getDefault();
            String currentLanguageCode = currentLocale.getLanguage();

            if ("es".equals(currentLanguageCode)) {

                tx.setText("Hola, el registro que realizó el " + bugunString + " sido añadido a nuestro sistema. Puede continuar presionando el botón 'Finalizar'.");


            } else if ("en".equals(currentLanguageCode)) {
                tx.setText("Hello, the record you made on " + bugunString + " has been added to our system. You can continue by pressing the 'Finish' button.");



            } else if ("tr".equals(currentLanguageCode)) {
                tx.setText("Merhaba, " + bugunString + " tarihinde yaptığınız kayıt sistemimize eklenmiştir 'Bitir' Tuşuna basarak devam edebilirsiniz. ");
            } else {
                tx.setText("Merhaba, " + bugunString + " tarihinde yaptığınız kayıt sistemimize eklenmiştir 'Bitir' Tuşuna basarak devam edebilirsiniz. ");
            }

        }




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(view);
                if (rt.getRating() > 0) {
                    veri.setKaydıdegerlendir(rt.getRating());
                    if (currentUser != null) {
                        databaseRef2.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()) {
                                    id = (Integer) dataSnapshot.getValue(Integer.class);
                                    Log.e("we", String.valueOf(id));
                                    databaseRef.child("veriListesi").child(String.valueOf(id)).setValue(veri)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    int idg = id + 1;
                                                    navController.navigate(R.id.dokuzz);
                                                    databaseRef2.setValue(idg)
                                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                @Override
                                                                public void onSuccess(Void aVoid) {
                                                                    if (ortalama == 0) {
                                                                        ortalama = 1;
                                                                    }
                                                                    int toplam = ortalama * (id - 1);
                                                                    toplam += veri.toplamatık;
                                                                    ortalama = Math.round(toplam / id);
                                                                    databaseRef3.setValue(ortalama).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                        @Override
                                                                        public void onSuccess(Void unused) {
                                                                            if (tokmetal == 0) {
                                                                                tokmetal = 1;
                                                                            }
                                                                            int toplam1 = tokmetal * (id - 1);
                                                                            toplam1 += veri.metala;
                                                                            tokmetal = Math.round(toplam1 / id);
                                                                            if (topcam == 0) {
                                                                                topcam = 1;
                                                                            }
                                                                            int toplam2 = topcam * (id - 1);
                                                                            toplam2 += veri.cama;
                                                                            topcam = Math.round(toplam2 / id);
                                                                            if (topkagıt == 0) {
                                                                                topkagıt = 1;
                                                                            }
                                                                            int toplam3 = topkagıt * (id - 1);
                                                                            toplam3 += veri.kağıta;
                                                                            topkagıt = Math.round(toplam3 / id);
                                                                            if (topplastik == 0) {
                                                                                topplastik = 1;
                                                                            }
                                                                            int toplam4 = topplastik * (id - 1);
                                                                            toplam4 += veri.plastika;
                                                                            topplastik = Math.round(toplam4 / id);
                                                                            databaseRef4.setValue(tokmetal)
                                                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                        @Override
                                                                                        public void onSuccess(Void unused) {
                                                                                            databaseRef5.setValue(topcam)
                                                                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                                        @Override
                                                                                                        public void onSuccess(Void unused) {
                                                                                                            databaseRef6.setValue(topkagıt)
                                                                                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                                                        @Override
                                                                                                                        public void onSuccess(Void unused) {
                                                                                                                            databaseRef7.setValue(topplastik)
                                                                                                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                                                                        @Override
                                                                                                                                        public void onSuccess(Void unused) {
                                                                                                                                            if (toastt == 0) {
                                                                                                                                                Toast.makeText(ff.getContext(), "Veri Başarıyla Kaydedildi", Toast.LENGTH_SHORT).show();
                                                                                                                                                toastt++;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                        }
                                                                                                                    });
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                                }
                                                            });
                                                }
                                            });
                                    btn2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            // NavController'ı bul ve ilkk eylemini gerçekleştir
                                            Bundle bundle = new Bundle();
                                            bundle.putSerializable("key", veri);
                                            NavController navController = Navigation.findNavController(view);
                                            navController.navigate(R.id.dokuzt, bundle);
                                        }
                                    });
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                                String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil

                                if (selectedLanguage.equals("es")) {
                                    // İspanyolca için özel işlemler
                                    Toast.makeText(ff.getContext(), "Se produjo un error al guardar los datos.", Toast.LENGTH_SHORT).show();
                                } else if (selectedLanguage.equals("en")) {
                                    Toast.makeText(ff.getContext(), "An error occurred while saving the data.", Toast.LENGTH_SHORT).show();
                                } else if (selectedLanguage.equals("tr")) {
                                    Toast.makeText(ff.getContext(), "Veri Kaydedilirken Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
                                } else {
                                    Locale currentLocale = Locale.getDefault();
                                    String currentLanguageCode = currentLocale.getLanguage();

                                    if ("es".equals(currentLanguageCode)) {

                                        Toast.makeText(ff.getContext(), "Se produjo un error al guardar los datos.", Toast.LENGTH_SHORT).show();


                                    } else if ("en".equals(currentLanguageCode)) {
                                        Toast.makeText(ff.getContext(), "An error occurred while saving the data.", Toast.LENGTH_SHORT).show();



                                    } else if ("tr".equals(currentLanguageCode)) {
                                        Toast.makeText(ff.getContext(), "Veri Kaydedilirken Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(ff.getContext(), "Veri Kaydedilirken Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
                                    }

                                }





                                NavController navController = Navigation.findNavController(view);
                                navController.navigate(R.id.dokuzz);
                            }
                        });
                    }
                }
            }
        });
        return ff;
    }
}