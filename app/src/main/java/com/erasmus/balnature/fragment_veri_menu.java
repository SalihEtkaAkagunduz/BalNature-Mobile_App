package com.erasmus.balnature;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class fragment_veri_menu extends Fragment {
Button btn; private FirebaseAuth mAuth;Integer ort=0;
    Integer ortg=0;
    ProgressBar pr;Button bten;
    public int hesaplaOran(int sayi1, int sayi2) {
        if (sayi2 != 0) {
            double oran = (double) (sayi1*100 / sayi2); // İkinci sayıya bölüm sonucunu ondalıklı sayı olarak hesapla
            return (int) Math.round(oran); // Sonucu yuvarla ve tamsayıya çevir
        } else {
            // İkinci sayı sıfır olmamalıdır, sıfıra bölme hatasını önlemek için kontrol eklenmiştir.
            // İstediğiniz bir hata işleme veya geri dönüş değeri ekleyebilirsiniz.
            return 0; // ya da -1 veya başka bir değer
        }
    }
    List<veriaktarimi> data;Kullanici kullanici;Integer ortalama;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DatabaseReference databaseRef, databaseRef2, databaseRef3, databaseRef4, databaseRef5, databaseRef6, databaseRef7;


        View ff=inflater.inflate(R.layout.fragment_veri_menu, container, false);
        mAuth = FirebaseAuth.getInstance();pr=ff.findViewById(R.id.progressBar);
        FirebaseUser currentUser2 = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        TextView txt=ff.findViewById(R.id.textView77);
        TextView txt3=ff.findViewById(R.id.textView79);
        TextView txt2=ff.findViewById(R.id.textView78);
        bten=ff.findViewById(R.id.button12);
        bten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde sınırlıdır.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("kullanicilar");
        DatabaseReference kullaniciRef = mDatabase.child(currentUser2.getUid());
        databaseRef3 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("toplamortalama");
        databaseRef4 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("veriListesi");
        databaseRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ortalama = (Integer) snapshot.getValue(Integer.class);
                Query lastTenItemsQuery = databaseRef4.limitToLast(10);
                lastTenItemsQuery.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Verileri işlemek için bir List oluşturun
                        data= new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            veriaktarimi value = snapshot.getValue(veriaktarimi.class);
                            data.add(value);
                            ort+=value.toplamatık;
                            ortg+=(value.camg+ value.platikg+ value.metalg+ value.kağıtg);
                            pr.setMax(ort);
                            pr.setProgress(ortg);

                        }
                        txt3.setText("Bu haftaki atıklarınızın toplam "+String.valueOf("%"+hesaplaOran(ortg, ort))+"'unu geri dönüştürdünüz");
                        txt2.setText(String.valueOf("%"+hesaplaOran(ortg, ort)));
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Veri alımı başarısız olursa buraya düşer
                        Log.e("hata","ops");
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("hata","ops");
            }
        });
        kullaniciRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // UID'ye ait veri bulundu
                    kullanici = dataSnapshot.getValue(Kullanici.class);


                    txt.setText(kullanici.getIsim()+" "+kullanici.soyisim);


                    // Kullanıcı verilerini kullanarak istediğiniz işlemleri yapabilirsiniz

                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Veri okuma işlemi iptal edildi veya hata oluştu
                Log.e("Firebase", "Veri okunurken hata oluştu: " + databaseError.getMessage());
            }
        });

        //TODO:bak bu kısmı chatgpt ye sor öle yap olay şu burada findviewbyid olmuyor fragment olduğu için onu çözz sonra hallet diğer sekmeye geçme işi 31/07/2023
        return ff;
    }

}