package com.erasmus.balnature;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.itsxtt.patternlock.PatternLockView;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class fragment_ayarlar_sifrailk extends Fragment {
    PatternLockView patternLockView;
    ImageView img;
    String kullaniciadi;
Button btn;
    View gg;
    TextView txt;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        int aa=sharedPreferences.getInt("sifrekontrol", 0);
        if(aa==0 ){
            View ff= inflater.inflate(R.layout.fragment_ayarlar_sifrailk, container, false);

            patternLockView=ff.findViewById(R.id.patternLockView);
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            FirebaseUser currentUser = mAuth.getCurrentUser();
            img=ff.findViewById(R.id.imageView70);
            btn=ff.findViewById(R.id.button19);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sifrailk2_to_fragment_ayarlar_ana3);


                }
            });
            if (currentUser != null) {
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("kullanicilar");
                DatabaseReference kullaniciRef = mDatabase.child(currentUser.getUid());

                kullaniciRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            // UID'ye ait veri bulunduF
                            Kullanici kullanici = dataSnapshot.getValue(Kullanici.class);

                            if (kullanici != null) {
                                kullaniciadi = kullanici.getIsim()+" "+kullanici.getSoyisim();

                                img.setImageBitmap(createProfileImage(kullaniciadi));
                            }
                        } else {

                            Log.e("Firebase", "UID'ye ait veri bulunamadı.");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Veri okuma işlemi iptal edildi veya hata oluştu
                        Log.e("Firebase", "Veri okunurken hata oluştu: " + databaseError.getMessage());
                    }
                });

                patternLockView.setOnPatternListener(new PatternLockView.OnPatternListener() {
                    @Override
                    public void onStarted() {

                    }

                    @Override
                    public void onProgress(ArrayList<Integer> ids) {

                    }

                    @Override
                    public boolean onComplete(ArrayList<Integer> ids) {


                        String result = ids.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining());
                        Bundle b=new Bundle();

                        b.putString("veri",result);

                        Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sifrailk2_to_fragment_ayarlar_sifre22,b);
                        return  true;

                    }
                });
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setMessage("Uygulamada bir hata oluştu mevcut bir kullanıcı yok. Lütfen uygulamanın ayarlarından verileri silip tekrar girip oturum açın ve bizimle iletişim kurun..")
                        .setTitle("Uyarı")
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sifrailk2_to_fragment_ayarlar_ana3);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();


            }

            return  ff;
        }
        else{
            View ff= inflater.inflate(R.layout.fragment_ayarlar_sifremenu, container, false);

            ConstraintLayout layout1 = ff.findViewById(R.id.constraintLayout56);
            ConstraintLayout layout2 = ff.findViewById((R.id.constraintLayout56d));
            ConstraintLayout layout3 = ff.findViewById(R.id.constraintLayout56f);

            txt=ff.findViewById(R.id.textView137);
            img=ff.findViewById(R.id.imageView68);


            gg=ff;
            txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sifrailk2_to_fragment_ayarlar_ana3);
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
                    Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sifrailk2_to_fragment_ayarlar_ana3);
                }
            });
            layout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sifrailk2_self);

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



    }
    public Bitmap createProfileImage(String text) {
        int[] colors = {
                Color.parseColor("#FF0000"), Color.parseColor("#FF7F00"), Color.parseColor("#FFD700"),
                Color.parseColor("#00FF00"), Color.parseColor("#00FF7F"), Color.parseColor("#00FFFF"),
                Color.parseColor("#0000FF"), Color.parseColor("#8A2BE2"), Color.parseColor("#4B0082"),
                Color.parseColor("#9400D3"), Color.parseColor("#FF1493"), Color.parseColor("#FF00FF"),
                Color.parseColor("#DC143C"), Color.parseColor("#FF4500"), Color.parseColor("#FFA500"),
                Color.parseColor("#808000"), Color.parseColor("#006400"), Color.parseColor("#008080"),
                Color.parseColor("#000080"), Color.parseColor("#8B008B"), Color.parseColor("#800080"),
                Color.parseColor("#B22222"), Color.parseColor("#FF69B4"), Color.parseColor("#FFC0CB"),
                Color.parseColor("#F08080"), Color.parseColor("#FFA07A"), Color.parseColor("#ADFF2F"),
                Color.parseColor("#00FF00"), Color.parseColor("#32CD32")
        };
        String initial = String.valueOf(text.charAt(0));
        int size = 300;
        Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(120);
        textPaint.setTextAlign(Paint.Align.CENTER);
        int colorIndex = 0;
        if (initial.matches("[A-Za-zÇçĞğİıÖöŞşÜü]")) {
            char firstChar = initial.toUpperCase().charAt(0);
            if (firstChar >= 'A' && firstChar <= 'Z') {
                colorIndex = (firstChar - 'A') % colors.length;
            } else if (firstChar >= 'Ç' && firstChar <= 'Ü') {
                colorIndex = (firstChar - 'Ç') % colors.length;
            }
        }
        canvas.drawColor(colors[colorIndex]);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float yOffset = (fontMetrics.ascent + fontMetrics.descent) / 2;
        float xPos = canvas.getWidth() / 2;
        float yPos = (canvas.getHeight() / 2) - yOffset;
        canvas.drawText(initial, xPos, yPos, textPaint);
        Bitmap output = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas outputCanvas = new Canvas(output);
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, size, size);
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        outputCanvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.WHITE);
        outputCanvas.drawOval(rectF, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        outputCanvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
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