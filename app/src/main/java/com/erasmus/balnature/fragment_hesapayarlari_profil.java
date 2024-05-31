package com.erasmus.balnature;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class fragment_hesapayarlari_profil extends Fragment {
    private FirebaseAuth mAuth;
    TextInputLayout txt,txt2,txt3;
    CalendarView date;
    Button btn;
    Switch sw,sw2,sw3;
    Kullanici kullanici;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff=inflater.inflate(R.layout.fragment_hesapayarlari_profil, container, false);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser2 = mAuth.getCurrentUser();
        txt=ff.findViewById(R.id.textInputLayout3);
        txt2=ff.findViewById(R.id.textInputLayout4);
        txt3=ff.findViewById(R.id.textInputLayout5);
        date=ff.findViewById(R.id.calendarView);
        sw=ff.findViewById(R.id.switch2);
        sw2=ff.findViewById(R.id.switch4);
        sw3=ff.findViewById(R.id.switch3);
btn=ff.findViewById(R.id.button7);
            // Kullanıcı oturum açık ise ana ekrana yönlendir
            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("kullanicilar");
            DatabaseReference kullaniciRef = mDatabase.child(currentUser2.getUid());

            kullaniciRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // UID'ye ait veri bulundu
                          kullanici = dataSnapshot.getValue(Kullanici.class);

                        if (kullanici != null) {
                            txt.getEditText().setText(kullanici.getIsim());
                            txt2.getEditText().setText(kullanici.getSoyisim());
                            txt3.getEditText().setText(kullanici.getAciklama());
                            date.setDate(kullanici.getTarih());

                            // Kullanıcı verilerini kullanarak istediğiniz işlemleri yapabilirsiniz

                        }
                    } else {
                        // UID'ye ait veri bulunamadı
                        Log.e("Firebase", "UID'ye ait veri bulunamadı.");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Veri okuma işlemi iptal edildi veya hata oluştu
                    Log.e("Firebase", "Veri okunurken hata oluştu: " + databaseError.getMessage());
                }
            });
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference kullaniciRef = database.getReference("kullanicilar").child(currentUser2.getUid());
                    Kullanici yeniKullanici = new Kullanici();
                    yeniKullanici.setAciklama(txt3.getEditText().getText().toString());
                    yeniKullanici.setSoyisim(txt2.getEditText().getText().toString());
                    yeniKullanici.setIsim(txt.getEditText().getText().toString());
                    yeniKullanici.setEmail(kullanici.getEmail().toString());
                    yeniKullanici.setOlusturmazamani(kullanici.getOlusturmazamani().toString());
                    yeniKullanici.setTarih(date.getDate());
                    yeniKullanici.setWeb(kullanici.web);
                    yeniKullanici.setFacebook(kullanici.facebook);
                    yeniKullanici.setInstagram(kullanici.instagram);
                    yeniKullanici.setLinkedin(kullanici.linkedin);
                    yeniKullanici.setTwitter(kullanici.twitter);
                    kullaniciRef.setValue(yeniKullanici)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                                    String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                                    if (selectedLanguage.equals("es")) {
                                        Toast.makeText(getContext(), "Los datos se han agregado correctamente.", Toast.LENGTH_SHORT).show();
                                    } else if (selectedLanguage.equals("en")) {
                                        Toast.makeText(getContext(), "Data has been successfully added.", Toast.LENGTH_SHORT).show();
                                    } else if (selectedLanguage.equals("tr")) {
                                        Toast.makeText(getContext(), "Veri başarıyla eklendi.", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Locale currentLocale = Locale.getDefault();
                                        String currentLanguageCode = currentLocale.getLanguage();

                                        if ("es".equals(currentLanguageCode)) {
                                            Toast.makeText(getContext(), "Los datos se han agregado correctamente.", Toast.LENGTH_SHORT).show();
                                        } else if ("en".equals(currentLanguageCode)) {
                                            Toast.makeText(getContext(), "Data has been successfully added.", Toast.LENGTH_SHORT).show();
                                        } else if ("tr".equals(currentLanguageCode)) {
                                            Toast.makeText(getContext(), "Veri başarıyla eklendi.", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getContext(), "Veri başarıyla eklendi.", Toast.LENGTH_SHORT).show();
                                        }
                                    }








                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Locale currentLocale = Locale.getDefault();
                                    String currentLanguageCode = currentLocale.getLanguage();

                                    if ("es".equals(currentLanguageCode)) {
                                        Toast.makeText(getContext(), "Error al insertar datos.", Toast.LENGTH_SHORT).show();
                                    } else if ("en".equals(currentLanguageCode)) {
                                        Toast.makeText(getContext(), "Data insertion failed.", Toast.LENGTH_SHORT).show();
                                    } else if ("tr".equals(currentLanguageCode)) {
                                        Toast.makeText(getContext(), "Veri ekleme başarısız oldu.", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(), "Veri ekleme başarısız oldu.", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });



                }
            });

        return ff;
    }
}