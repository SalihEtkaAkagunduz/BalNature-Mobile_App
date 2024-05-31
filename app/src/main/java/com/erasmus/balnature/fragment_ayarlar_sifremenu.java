package com.erasmus.balnature;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class fragment_ayarlar_sifremenu extends Fragment {


    View gg;
    TextView txt;
    ImageView img;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff=inflater.inflate(R.layout.fragment_ayarlar_sifremenu, container, false);
        ConstraintLayout layout1 = ff.findViewById(R.id.constraintLayout56);
        ConstraintLayout layout2 = ff.findViewById((R.id.constraintLayout56d));
        ConstraintLayout layout3 = ff.findViewById(R.id.constraintLayout56f);

        txt=ff.findViewById(R.id.textView137);
        img=ff.findViewById(R.id.imageView68);


        gg=ff;
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sifremenu2_to_fragment_ayarlar_ana);
            }
        });
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("sifre", "0");
                editor.apply();

                SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor2 = sharedPreferences.edit();
                editor.putInt("sifrekontrol", 0);
                editor.apply();
                Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sifremenu2_to_fragment_ayarlar_ana);
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sifremenu2_to_fragment_ayarlar_sifrailk22);

            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setMessage("Telefonunuz malesef parmak izi özelliğini desteklememektedir.")
                        .setTitle("Bilgilendirme")
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });


        setTouchListener(layout1);
        setTouchListener(layout2);
        setTouchListener(layout3);












        return ff;
    }
    private boolean isGmailAppInstalled() {
        try {
            // Gmail uygulamasının paket adını kullanarak kontrol edin
            PackageManager packageManager = gg.getContext().getPackageManager();
            packageManager.getPackageInfo("com.google.android.gm", PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private void sendEmailUsingGmail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "egitim@turkcell.com.tr" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Android");
        intent.putExtra(Intent.EXTRA_TEXT, "Kod dosyalarina nasil ulasabiliriz?");


        // Gmail uygulamasını açmak için Gmail'in paket adını kullanın
        intent.setPackage("com.google.android.gm");

        if (intent.resolveActivity(gg.getContext().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // Gmail uygulaması bulunamazsa, kullanıcıya bir hata mesajı gösterebilirsiniz.
            // Varsayılan e-posta uygulamasını kullanma seçeneği de sunabilirsiniz.
            sendEmailUsingDefaultApp();
        }
    }

    void sendEmailUsingDefaultApp() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "egitim@turkcell.com.tr" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Android");
        intent.putExtra(Intent.EXTRA_TEXT, "Kod dosyalarina nasil ulasabiliriz?");


        if (intent.resolveActivity(gg.getContext().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // E-posta uygulaması bulunamazsa, kullanıcıya bir hata mesajı gösterebilirsiniz.
        }
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

                        // Eğer bu bir tıklama ise OnClickListener'ı çağırın
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