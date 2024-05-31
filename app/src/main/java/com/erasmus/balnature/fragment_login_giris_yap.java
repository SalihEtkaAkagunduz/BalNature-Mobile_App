package com.erasmus.balnature;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.renderscript.ScriptGroup;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Locale;
import java.util.concurrent.Executor;


public class fragment_login_giris_yap extends Fragment  {


    Button btn;

    EditText edt;
    EditText edt2;
    String email;

    String parola;
    Button girisgoogle,girisfacebook;
    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 123;
    private FirebaseAuth mAuth;
    Switch sw;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ff = inflater.inflate(R.layout.fragment_login_giris_yap, container, false);
        btn = ff.findViewById(R.id.button6);
        edt = ff.findViewById(R.id.mail_et);

        edt2 = ff.findViewById(R.id.password_et);
sw=ff.findViewById(R.id.switch1);
        mAuth = FirebaseAuth.getInstance();

        // Initialize Facebook Login button




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = edt.getText().toString();
                parola = edt2.getText().toString();

                if (TextUtils.isEmpty(email)) {


                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                    if (selectedLanguage.equals("es")) {
                        Toast.makeText(getContext(), "Los datos se han agregado correctamente.", Toast.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("en")) {
                        // İngilizce için özel işlemler
                        Snackbar.make(view, "Please fill in the specified text expressions", Snackbar.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("tr")) {
                        Snackbar.make(ff, "Lütfen E-Postanızı girin", Snackbar.LENGTH_SHORT).show();
                    } else {
                        Locale currentLocale = Locale.getDefault();
                        String currentLanguageCode = currentLocale.getLanguage();

                        if ("es".equals(currentLanguageCode)) {
                            Toast.makeText(getContext(), "Los datos se han agregado correctamente.", Toast.LENGTH_SHORT).show();
                        } else if ("en".equals(currentLanguageCode)) {
                            Toast.makeText(getContext(), "Data has been successfully added.", Toast.LENGTH_SHORT).show();
                        } else if ("tr".equals(currentLanguageCode)) {
                            Snackbar.make(ff, "Lütfen E-Postanızı girin", Snackbar.LENGTH_SHORT).show();
                        } else {
                            Snackbar.make(ff, "Lütfen E-Postanızı girin", Snackbar.LENGTH_SHORT).show();
                        }

                    }



                    return;
                }
                if (TextUtils.isEmpty(parola)) {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                    if (selectedLanguage.equals("es")) {
                        // İspanyolca için özel işlemler
                        Snackbar.make(ff, "Por favor, ingrese su correo electrónico", Snackbar.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("en")) {
                        // İngilizce için özel işlemler
                        Snackbar.make(ff, "Please enter your email", Snackbar.LENGTH_SHORT).show();
                    } else if (selectedLanguage.equals("tr")) {
                        // Türkçe için özel işlemler
                        Snackbar.make(ff, "Lütfen parolanızı giriniz", Snackbar.LENGTH_SHORT).show();
                    } else {
                        Locale currentLocale = Locale.getDefault();
                        String currentLanguageCode = currentLocale.getLanguage();

                        if ("es".equals(currentLanguageCode)) {
                            Snackbar.make(ff, "Por favor, ingrese su correo electrónico", Snackbar.LENGTH_SHORT).show();
                        } else if ("en".equals(currentLanguageCode)) {
                            Snackbar.make(ff, "Please enter your email", Snackbar.LENGTH_SHORT).show();
                        } else if ("tr".equals(currentLanguageCode)) {
                            Snackbar.make(ff, "Lütfen parolanızı giriniz", Snackbar.LENGTH_SHORT).show();
                        } else {
                            Snackbar.make(ff, "Lütfen parolanızı giriniz", Snackbar.LENGTH_SHORT).show();
                        }
                    }


                }else {
                    if(sw.isChecked()){
                        registerFuncsig();
                    }
                    else{
                        registerFunc();
                    }




                }
            }
        });

        return ff;
    }


    private void registerFunc() {
        mAuth.signInWithEmailAndPassword(email, parola)
                .addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent=new Intent(getContext(),MainActivity.class);
                            FirebaseUser user = mAuth.getCurrentUser();
                            intent.putExtra("tekseferlikmi",true);
                            intent.putExtra("id",user.getUid());
                            startActivity(intent);
                            Locale currentLocale = Locale.getDefault();
                            String currentLanguageCode = currentLocale.getLanguage();

                            if ("es".equals(currentLanguageCode)) {
                                Toast.makeText(getContext(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                            } else if ("en".equals(currentLanguageCode)) {
                                Toast.makeText(getContext(), "Login Successful", Toast.LENGTH_SHORT).show();

                            } else if ("tr".equals(currentLanguageCode)) {
                                Toast.makeText(getContext(), "Giriş Yapıldı", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "Giriş Yapıldı", Toast.LENGTH_SHORT).show();
                            }

                            mAuth.signOut();
                        } else {
                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                            String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                            if (selectedLanguage.equals("es")) {
                                Toast.makeText(getContext(), "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                            } else if (selectedLanguage.equals("en")) {
                                Toast.makeText(getContext(), "Username or password incorrect", Toast.LENGTH_SHORT).show();
                            } else if (selectedLanguage.equals("tr")) {
                                Toast.makeText(getContext(), "Kullanıcı adı veya parola yanlış", Toast.LENGTH_SHORT).show();
                            } else {
                                Locale currentLocale = Locale.getDefault();
                                String currentLanguageCode = currentLocale.getLanguage();

                                if ("es".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();

                                } else if ("en".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Username or password incorrect", Toast.LENGTH_SHORT).show();

                                } else if ("tr".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Kullanıcı adı veya parola yanlış", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getContext(), "Kullanıcı adı veya parola yanlış", Toast.LENGTH_SHORT).show();
                                }
                            }




                            Log.e("Giriş Hatası",task.getException().getMessage());
                        }
                    }
                });

    }
    private void registerFuncsig() {
        mAuth.signInWithEmailAndPassword(email, parola)
                .addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                user.getIdToken(true);
                            }
                            Intent intent=new Intent(getContext(),MainActivity.class);
                            intent.putExtra("tekseferlikmi",false);
                            startActivity(intent);

                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                            String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                            if (selectedLanguage.equals("es")) {
                                Toast.makeText(getContext(), "Iniciando sesión...", Toast.LENGTH_SHORT).show();
                            } else if (selectedLanguage.equals("en")) {
                                Toast.makeText(getContext(), "Logging in...", Toast.LENGTH_SHORT).show();
                            } else if (selectedLanguage.equals("tr")) {
                                // Türkçe için özel işlemler
                                Toast.makeText(getContext(), "Giriş Yapılıyor", Toast.LENGTH_SHORT).show();
                            } else {

                                Locale currentLocale = Locale.getDefault();
                                String currentLanguageCode = currentLocale.getLanguage();

                                if ("es".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Iniciando sesión...", Toast.LENGTH_SHORT).show();

                                } else if ("en".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Logging in...", Toast.LENGTH_SHORT).show();

                                } else if ("tr".equals(currentLanguageCode)) {

                                } else {
                                    Toast.makeText(getContext(), "Giriş Yapılıyor", Toast.LENGTH_SHORT).show();
                                }
                            }



                        }
                        else {
                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                            String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                            if (selectedLanguage.equals("es")) {
                                Toast.makeText(getContext(), "El nombre de usuario o la contraseña son incorrectos", Toast.LENGTH_SHORT).show();
                            } else if (selectedLanguage.equals("en")) {
                                Toast.makeText(getContext(), "Username or password is incorrect", Toast.LENGTH_SHORT).show();
                            } else if (selectedLanguage.equals("tr")) {
                                Toast.makeText(getContext(), "Kullanıcı adım yada parola yanlış", Toast.LENGTH_SHORT).show();
                            } else {
                                Locale currentLocale = Locale.getDefault();
                                String currentLanguageCode = currentLocale.getLanguage();

                                if ("es".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "El nombre de usuario o la contraseña son incorrectos", Toast.LENGTH_SHORT).show();

                                } else if ("en".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Username or password is incorrect", Toast.LENGTH_SHORT).show();

                                } else if ("tr".equals(currentLanguageCode)) {
                                    Toast.makeText(getContext(), "Kullanıcı adım yada parola yanlış", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getContext(), "Kullanıcı adım yada parola yanlış", Toast.LENGTH_SHORT).show();
                                }
                            }




                            Log.e("Giriş Hatası",task.getException().getMessage());
                        }
                    }
                });
    }


}
