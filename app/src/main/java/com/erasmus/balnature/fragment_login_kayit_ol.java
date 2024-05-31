package com.erasmus.balnature;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;


public class fragment_login_kayit_ol extends Fragment implements GoogleApiClient.OnConnectionFailedListener {



    Button btn;
    EditText edt;private GoogleApiClient mGoogleApiClient;
    EditText edt2,edt3;String email;
    String parola,parola2;private FirebaseAuth auth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ff=inflater.inflate(R.layout.fragment_login_kayit_ol, container, false);
        btn=ff.findViewById(R.id.button6);
        edt=ff.findViewById(R.id.mail_et2);
        edt2=ff.findViewById(R.id.password_et2);
edt3=ff.findViewById(R.id.password_et3);





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=edt.getText().toString();
                parola = edt2.getText().toString();
                parola2 = edt3.getText().toString();
                int result = parola.compareTo(parola2);
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





                Locale currentLocale = Locale.getDefault();
                String currentLanguageCode = currentLocale.getLanguage();

                if ("es".equals(currentLanguageCode)) {
                    if (TextUtils.isEmpty(email)) {
                        Snackbar.make(ff, "Por favor, ingrese su correo electrónico", Snackbar.LENGTH_SHORT).show();
                        return;
                    } else if (TextUtils.isEmpty(parola)) {
                        Snackbar.make(ff, "Por favor, ingrese su contraseña", Snackbar.LENGTH_SHORT).show();
                    } else if (parola.length() < 6) {
                        Snackbar.make(ff, "La contraseña debe tener al menos 6 caracteres", Snackbar.LENGTH_SHORT).show();
                    } else if (result != 0) {
                        Snackbar.make(ff, "Las contraseñas no coinciden", Snackbar.LENGTH_SHORT).show();
                    }



                    else{
                        auth=FirebaseAuth.getInstance();
                        fragment_login_kayit_olDirections.ActionFragmentLoginKayitOlToFragmentLoginIsim g= fragment_login_kayit_olDirections.actionFragmentLoginKayitOlToFragmentLoginIsim();
                        g.setEmail(email);
                        g.setParola(parola);
                        Navigation.findNavController(ff).navigate(g);

                    }
                } else if ("en".equals(currentLanguageCode)) {
                    if (TextUtils.isEmpty(email)) {
                        Snackbar.make(ff, "Please enter your email", Snackbar.LENGTH_SHORT).show();
                        return;
                    } else if (TextUtils.isEmpty(parola)) {
                        Snackbar.make(ff, "Please enter your password", Snackbar.LENGTH_SHORT).show();
                    } else if (parola.length() < 6) {
                        Snackbar.make(ff, "Password must be at least 6 characters long", Snackbar.LENGTH_SHORT).show();
                    } else if (result != 0) {
                        Snackbar.make(ff, "Passwords do not match", Snackbar.LENGTH_SHORT).show();
                    }
                    else{
                        auth=FirebaseAuth.getInstance();
                        fragment_login_kayit_olDirections.ActionFragmentLoginKayitOlToFragmentLoginIsim g= fragment_login_kayit_olDirections.actionFragmentLoginKayitOlToFragmentLoginIsim();
                        g.setEmail(email);
                        g.setParola(parola);
                        Navigation.findNavController(ff).navigate(g);

                    }
                } else if ("tr".equals(currentLanguageCode)) {
                    if (TextUtils.isEmpty(email)) {
                        Snackbar.make(ff, "Lütfen E-Postanızı girin", Snackbar.LENGTH_SHORT).show();
                        return;
                    }
                    else if (TextUtils.isEmpty(parola)) {
                        Snackbar.make(ff, "Lütfen parolanızı giriniz", Snackbar.LENGTH_SHORT).show();
                    }
                    else if (parola.length() < 6) {
                        Snackbar.make(ff, "Parola en az 6 haneli olmalıdır", Snackbar.LENGTH_SHORT).show();
                    }

                    else if(result != 0){
                        Snackbar.make(ff, "Parolalar uyuşmuyor", Snackbar.LENGTH_SHORT).show();
                    }
                    else{
                        auth=FirebaseAuth.getInstance();
                        fragment_login_kayit_olDirections.ActionFragmentLoginKayitOlToFragmentLoginIsim g= fragment_login_kayit_olDirections.actionFragmentLoginKayitOlToFragmentLoginIsim();
                        g.setEmail(email);
                        g.setParola(parola);
                        Navigation.findNavController(ff).navigate(g);

                    }
                } else {
                    if (TextUtils.isEmpty(email)) {
                        Snackbar.make(ff, "Lütfen E-Postanızı girin", Snackbar.LENGTH_SHORT).show();
                        return;
                    }
                    else if (TextUtils.isEmpty(parola)) {
                        Snackbar.make(ff, "Lütfen parolanızı giriniz", Snackbar.LENGTH_SHORT).show();
                    }
                    else if (parola.length() < 6) {
                        Snackbar.make(ff, "Parola en az 6 haneli olmalıdır", Snackbar.LENGTH_SHORT).show();
                    }

                    else if(result != 0){
                        Snackbar.make(ff, "Parolalar uyuşmuyor", Snackbar.LENGTH_SHORT).show();
                    }
                    else{
                        auth=FirebaseAuth.getInstance();
                        fragment_login_kayit_olDirections.ActionFragmentLoginKayitOlToFragmentLoginIsim g= fragment_login_kayit_olDirections.actionFragmentLoginKayitOlToFragmentLoginIsim();
                        g.setEmail(email);
                        g.setParola(parola);
                        Navigation.findNavController(ff).navigate(g);

                    }
                }

            }
        });
        // Inflate the layout for this fragment


        return ff;

    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}