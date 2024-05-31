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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;


public class fragment_hesapayarlari_guvenlik extends Fragment {
    TextInputLayout eposta, sifre, sifre2, mevcut;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff = inflater.inflate(R.layout.fragment_hesapayarlari_guvenlik, container, false);
        mevcut = ff.findViewById(R.id.textInputLayoukt3);
        eposta = ff.findViewById(R.id.textInputLayout3);
        sifre = ff.findViewById(R.id.textInputLapyoutl3);
        sifre2 = ff.findViewById(R.id.textInputLayoutl3);
        btn = ff.findViewById(R.id.button4);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser2 = mAuth.getCurrentUser();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("kullanicilar");
        DatabaseReference kullaniciRef = mDatabase.child(currentUser2.getUid());

        kullaniciRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // UID'ye ait veri bulundu
                    Kullanici kullanici = dataSnapshot.getValue(Kullanici.class);

                    if (kullanici != null) {
                        eposta.getEditText().setText(kullanici.getEmail());


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
                String str1 = sifre.getEditText().getText().toString();
                String str2 = sifre2.getEditText().getText().toString();

                boolean esitMi = str1.equals(str2);
                if (esitMi && sifre.getEditText().getText().toString().length() >= 6) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String newPassword = sifre.getEditText().getText().toString();

                    AuthCredential credential = EmailAuthProvider
                            .getCredential(eposta.getEditText().getText().toString(), mevcut.getEditText().getText().toString());

                    user.reauthenticate(credential)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Kullanıcının kimlik doğrulaması başarılı oldu, şifre değiştirilebilir.
                                        user.updatePassword(newPassword)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                                                            String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                                                            if (selectedLanguage.equals("es")) {
                                                                Toast.makeText(getContext(), "Contraseña actualizada exitosamente", Toast.LENGTH_SHORT).show();
                                                            } else if (selectedLanguage.equals("en")) {
                                                                // İngilizce için özel işlemler
                                                                Toast.makeText(getContext(), "Password updated successfully", Toast.LENGTH_SHORT).show();
                                                            } else if (selectedLanguage.equals("tr")) {
                                                                // Türkçe için özel işlemler
                                                                Toast.makeText(getContext(), "Şifre başarıyla güncellendi", Toast.LENGTH_SHORT).show();
                                                            } else {
                                                                Locale currentLocale = Locale.getDefault();
                                                                String currentLanguageCode = currentLocale.getLanguage();

                                                                if ("es".equals(currentLanguageCode)) {
                                                                    Toast.makeText(getContext(), "Contraseña actualizada exitosamente", Toast.LENGTH_SHORT).show();
                                                                } else if ("en".equals(currentLanguageCode)) {
                                                                    Toast.makeText(getContext(), "Password updated successfully", Toast.LENGTH_SHORT).show();
                                                                } else if ("tr".equals(currentLanguageCode)) {
                                                                    Toast.makeText(getContext(), "Şifre başarıyla güncellendi", Toast.LENGTH_SHORT).show();
                                                                } else {
                                                                    Toast.makeText(getContext(), "Şifre başarıyla güncellendi", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }







                                                        } else {
                                                            Toast.makeText(getContext(), "Şifre güncelleme işlemi başarısız oldu", Toast.LENGTH_SHORT).show();
                                                            if (task.getException() != null) {
                                                                Log.e("Firebase", "Şifre güncelleme hatası: " + task.getException().getMessage());
                                                            }
                                                        }
                                                    }
                                                });
                                    } else {
                                        Toast.makeText(getContext(), "Mevcut Şifreniz Hatalı", Toast.LENGTH_SHORT).show();
                                        if (task.getException() != null) {
                                            Log.e("Firebase", "Kimlik doğrulama hatası: " + task.getException().getMessage());
                                        }
                                    }
                                }
                            });
                } else {
                    Locale currentLocale = Locale.getDefault();
                    String currentLanguageCode = currentLocale.getLanguage();

                    if ("es".equals(currentLanguageCode)) {
                        Toast.makeText(getContext(), "Asegúrese de que su contraseña tenga seis o más longitudes o que sus contraseñas sean iguales", Toast.LENGTH_SHORT).show();
                    } else if ("en".equals(currentLanguageCode)) {
                        Toast.makeText(getContext(), "Please make sure your password is six or more in length or your passwords are equal", Toast.LENGTH_SHORT).show();
                    } else if ("tr".equals(currentLanguageCode)) {
                        Toast.makeText(getContext(), "Lütfen şifrenizin uzunluğunun altı veya daha fazla olduğundan veya şifrelerinizin eşit olduğundan emin olun", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Lütfen şifrenizin uzunluğunun altı veya daha fazla olduğundan veya şifrelerinizin eşit olduğundan emin olun", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        return ff;

    }
}