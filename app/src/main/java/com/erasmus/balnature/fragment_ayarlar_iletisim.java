package com.erasmus.balnature;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class fragment_ayarlar_iletisim extends Fragment {
View gg;
TextView txt;
ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ff=inflater.inflate(R.layout.fragment_ayarlar_iletisim, container, false);
        ConstraintLayout layout1 = ff.findViewById(R.id.constraintLayout56);
        ConstraintLayout layout2 = ff.findViewById((R.id.constraintLayout56d));
        ConstraintLayout layout3 = ff.findViewById(R.id.constraintLayout56f);
        ConstraintLayout layout4 = ff.findViewById(R.id.constraintLayout56e);
        txt=ff.findViewById(R.id.textView137);
        img=ff.findViewById(R.id.imageView68);

        ConstraintLayout layout5 = ff.findViewById(R.id.constraintLayout56a);
        ConstraintLayout layout6 = ff.findViewById(R.id.constraintLayout56b);
        ConstraintLayout layout7 = ff.findViewById(R.id.constraintLayout56c);

gg=ff;
txt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_iletisim_to_fragment_ayarlar_ana);
    }
});
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGmailAppInstalled()) {
                    sendEmailUsingGmail();
                } else {
                    // Gmail uygulaması yüklü değilse varsayılan e-posta uygulamasını kullanın
                    sendEmailUsingDefaultApp();
                }
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "05370234669";

                // Telefon numarasını arama işlemi için bir Intent oluşturun
                Intent callIntent = new Intent(Intent.ACTION_DIAL);

                // Arama yapılacak numarayı Intent'e ekleyin
                callIntent.setData(Uri.parse("tel:" + phoneNumber));

                // Intent'i başlatın
                startActivity(callIntent);
            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // SMS gönderme işlemi için bir Intent oluşturun
                String smsNumber = "05370234669";
                ;

                Uri uri = Uri.parse("smsto:" + smsNumber);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);

                startActivity(intent);
            }
        });
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri uri = Uri.parse("https://www.facebook.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri uri = Uri.parse("https://www.instagram.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });layout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("https://www.youtube.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });layout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri uri = Uri.parse("https://www.discord.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });



        setTouchListener(layout1);
        setTouchListener(layout2);
        setTouchListener(layout3);
        setTouchListener(layout4);
        setTouchListener(layout5);
        setTouchListener(layout6);
        setTouchListener(layout7);











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
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "infa@seazer.com.tr" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Konu");
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
         intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "infa@seazer.com.tr" });
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