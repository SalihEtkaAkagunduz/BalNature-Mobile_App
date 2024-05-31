package com.erasmus.balnature;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextPaint;
import android.util.Log;
import android.widget.ImageView;

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

public class lock extends AppCompatActivity {
PatternLockView patternLockView;
 ImageView img;
 String kullaniciadi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_lock);
        super.onCreate(savedInstanceState);
        patternLockView=findViewById(R.id.patternLockView);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
img=findViewById(R.id.imageView70);

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
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    String aa=sharedPreferences.getString("sifre", "error");
                    if(result.equals(aa)){
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);

                        startActivity(intent);
                        return true;
                    }
                    if(result.equals("error")){

                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setMessage("Şifre verisi Alınamadı.")
                                .setTitle("Uyarı")
                                .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        System.exit(0);
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        return false;
                    }
                    else{
                        return false;
                    }

                }
            });
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Uygulamada bir hata oluştu mevcut bir kullanıcı yok. Lütfen uygulamanın ayarlarından verileri silip tekrar girip oturum açın ve bizimle iletişim kurun..")
                    .setTitle("Uyarı")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            System.exit(0);
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();


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


}