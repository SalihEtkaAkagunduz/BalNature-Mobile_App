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


public class fragment_hesapayarlari_hesapbagla extends Fragment {
    private FirebaseAuth mAuth;
    TextInputLayout web,tw,fa,in,li;
    Kullanici kullanici;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         mAuth = FirebaseAuth.getInstance();

                FirebaseUser currentUser2 = mAuth.getCurrentUser();
        View ff=inflater.inflate(R.layout.fragment_hesapayarlari_hesapbagla, container, false);
        web=ff.findViewById(R.id.textInputLayout6);
        tw=ff.findViewById(R.id.tww);
        fa=ff.findViewById(R.id.faa);
        in=ff.findViewById(R.id.inn);
        li=ff.findViewById(R.id.lii);



        Button btn=ff.findViewById(R.id.button8);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("kullanicilar");
        DatabaseReference kullaniciRef = mDatabase.child(currentUser2.getUid());

        kullaniciRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // UID'ye ait veri bulundu
                    kullanici = dataSnapshot.getValue(Kullanici.class);

                    if (kullanici != null) {
                        web.getEditText().setText(kullanici.getWeb());
                        tw.getEditText().setText(kullanici.getTwitter());
                        fa.getEditText().setText(kullanici.getFacebook());
                        in.getEditText().setText(kullanici.getInstagram());
                        li.getEditText().setText(kullanici.getLinkedin());

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
                yeniKullanici.setAciklama(kullanici.aciklama);
                yeniKullanici.setSoyisim(kullanici.soyisim);
                yeniKullanici.setIsim(kullanici.isim);
                yeniKullanici.setEmail(kullanici.getEmail().toString());
                yeniKullanici.setOlusturmazamani(kullanici.getOlusturmazamani().toString());
                yeniKullanici.setTarih(kullanici.tarih);
                yeniKullanici.setWeb(web.getEditText().getText().toString());
                yeniKullanici.setFacebook(fa.getEditText().getText().toString());
                yeniKullanici.setInstagram(in.getEditText().getText().toString());
                yeniKullanici.setLinkedin(li.getEditText().getText().toString());
                yeniKullanici.setTwitter(tw.getEditText().getText().toString());
                kullaniciRef.setValue(yeniKullanici)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                                String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                                if (selectedLanguage.equals("es")) {
                                    // İspanyolca için özel işlemler
                                    Toast.makeText(getContext(), "Sus cuentas se han actualizado correctamente.", Toast.LENGTH_SHORT).show();
                                } else if (selectedLanguage.equals("en")) {
                                    // İngilizce için özel işlemler
                                    Toast.makeText(getContext(), "Your accounts have been successfully updated.", Toast.LENGTH_SHORT).show();
                                } else if (selectedLanguage.equals("tr")) {
                                    // Türkçe için özel işlemler
                                    Toast.makeText(getContext(), "Hesapların başarıyla güncellendi.", Toast.LENGTH_SHORT).show();
                                } else {
                                    Locale currentLocale = Locale.getDefault();
                                    String currentLanguageCode = currentLocale.getLanguage();

                                    if ("es".equals(currentLanguageCode)) {
                                        Toast.makeText(getContext(), "Sus cuentas se han actualizado correctamente.", Toast.LENGTH_SHORT).show();
                                    } else if ("en".equals(currentLanguageCode)) {
                                        Toast.makeText(getContext(), "Your accounts have been successfully updated.", Toast.LENGTH_SHORT).show();
                                    } else if ("tr".equals(currentLanguageCode)) {
                                        Toast.makeText(getContext(), "Hesapların başarıyla güncellendi.", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(), "Hesapların başarıyla güncellendi.", Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(getContext(), "Se produjo un error al actualizar sus cuentas.", Toast.LENGTH_SHORT).show();
                                } else if ("en".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "An error occurred while updating your accounts", Toast.LENGTH_SHORT).show();
                                } else if ("tr".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Hesapların güncellenirken bir hata oluştu", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getContext(), "Hesapların güncellenirken bir hata oluştu", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });



            }
        });

        return ff;
    }
}