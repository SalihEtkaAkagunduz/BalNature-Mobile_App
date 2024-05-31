package com.erasmus.balnature;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.type.DateTime;


public class fragment_login_son extends Fragment {
    String email, isim, soyisim, metin, parola, oluşturmazamanı;
    Long l;
    View ff;  private Context mContext;
    Button btn;
    private FirebaseAuth auth;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff = inflater.inflate(R.layout.fragment_login_son, container, false);
        fragment_login_sonArgs gg = fragment_login_sonArgs.fromBundle(getArguments());
        email = gg.getEmail();

        soyisim = gg.getSoyisim();
        metin = gg.getMetin();
        isim = gg.getAd();
        parola = gg.getParola();
        btn = ff.findViewById(R.id.button5);

        ff = ff;
        LocalDateTime simdikiZaman = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        oluşturmazamanı = simdikiZaman.format(formatter);


        l = gg.getTarih();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerFunc();
            }
        });

        return ff;
    }

    private void registerFunc() {
        auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, parola)
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        FirebaseAuth mAuth = FirebaseAuth.getInstance();
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            // Bildirim oluştur+

                            bildirimat notificationSender = new bildirimat(mContext); // 'this' bir Context nesnesi olmalı
                            notificationSender.sendNotification("Mehaba ilk girişinizi yaptınız.", "Mehaba ilk girişinizi yaptınız." );



                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                            String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                            if (selectedLanguage.equals("es")) {
                                  Toast.makeText(getContext(), "Registro creado exitosamente", Toast.LENGTH_SHORT).show();
                            } else if (selectedLanguage.equals("en")) {
                                Toast.makeText(getContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                            } else if (selectedLanguage.equals("tr")) {
                                // Türkçe için özel işlemler
                                Toast.makeText(getContext(), "Kayıt Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show();
                            } else {
                                Locale currentLocale = Locale.getDefault();
                                String currentLanguageCode = currentLocale.getLanguage();

                                if ("es".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Registro creado exitosamente", Toast.LENGTH_SHORT).show();

                                } else if ("en".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Registration Successful", Toast.LENGTH_SHORT).show();

                                } else if ("tr".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Kayıt Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getContext(), "Kayıt Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show();
                                }
                            }







                            if (user != null) {
                                // Kullanıcının UID'sini al
                                String uid = user.getUid();

                                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("kullanicilar");
ArrayList<veriaktarimi> v=new ArrayList<>();
                                Date date = new Date();
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                Calendar calendar = Calendar.getInstance();
// Tarihi biçimlendir ve bir string olarak al
                                String currentDate = dateFormat.format(calendar.getTime());
veriaktarimi ver=new veriaktarimi("varsayılan","veri",1, System.currentTimeMillis(),"Ev",0,0,0,0,0,0,0,0,0, 3.5f);
v.add(ver);
                                // Kullanıcı bilgilerini oluşturulan UID ile Realtime Database'e kaydet
                                ArrayList<bild> v2=new ArrayList<>();


// LocalDateTime'i Date'e çevir




                                bild ver2=new bild(0,"Mehaba ilk girişinizi yaptınız.","Mehaba ilk girişinizi yaptınız.","Mehaba ilk girişinizi yaptınız.",currentDate,0,0,0);
                                v2.add(ver2);
                                Kullanici kullanici = new Kullanici(v,v2,isim,soyisim,metin,oluşturmazamanı,"","","","","",email  ,l,1,0,0,0,0,0);
                                mDatabase.child(uid).setValue(kullanici)
                                        .addOnSuccessListener(aVoid -> {
                                            // Bildirim oluştur





                                        })
                                        .addOnFailureListener(e -> {
                                            // Kullanıcı bilgileri kaydedilirken bir hata oluştu
                                            Log.e("Firebase", "Kullanıcı bilgileri kaydedilirken hata oluştu: " + e.getMessage());
                                        });
                            }
                            Intent i = new Intent(getContext(), MainActivity.class);
                            startActivity(i);
                        } else {

                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                            String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                            if (selectedLanguage.equals("es")) {
                                Toast.makeText(getContext(), "Este correo electrónico ya ha sido utilizado", Toast.LENGTH_SHORT).show();
                            } else if (selectedLanguage.equals("en")) {
                                // İngilizce için özel işlemler
                                Toast.makeText(getContext(), "This email has been used before", Toast.LENGTH_SHORT).show();
                            } else if (selectedLanguage.equals("tr")) {
                                // Türkçe için özel işlemler
                                Toast.makeText(getContext(), "Bu E-Posta daha önce kullanılmış", Toast.LENGTH_SHORT).show();
                            } else {
                                Locale currentLocale = Locale.getDefault();
                                String currentLanguageCode = currentLocale.getLanguage();

                                if ("es".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Este correo electrónico ya ha sido utilizado", Toast.LENGTH_SHORT).show();


                                } else if ("en".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "This email has been used before", Toast.LENGTH_SHORT).show();


                                } else if ("tr".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Bu E-Posta daha önce kullanılmış", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getContext(), "Bu E-Posta daha önce kullanılmış", Toast.LENGTH_SHORT).show();
                                }
                            }






                            Log.e("aa","hata" + task.getException().getMessage());
                        }
                    }
                });


    }
}