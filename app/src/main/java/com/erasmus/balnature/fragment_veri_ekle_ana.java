package com.erasmus.balnature;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

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

public class fragment_veri_ekle_ana extends Fragment {

    Button btn;
    RecyclerView rv;List<veriaktarimi> data;
    adapter_1 adptr;
    Button bten;
Integer ortalama;
ProgressBar pss;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Fragment layoutunu şişir (inflate) et
        View ff = inflater.inflate(R.layout.fragment_veri_ekle_ana, container, false);
        DatabaseReference databaseRef, databaseRef2, databaseRef3, databaseRef4, databaseRef5, databaseRef6, databaseRef7;
        FirebaseAuth mAuth;

        rv=ff.findViewById(R.id.rec);
        pss=ff.findViewById(R.id.progressBar22);
        mAuth = FirebaseAuth.getInstance();
        bten=ff.findViewById(R.id.button13);
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
        FirebaseUser currentUser = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
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
                        }
                        adptr=new adapter_1(ff.getContext(),data,ortalama);

                        rv.setLayoutManager(new LinearLayoutManager(ff.getContext()));
                        rv.setHasFixedSize(true);
                        rv.setAdapter(adptr);
                        pss.setVisibility(View.INVISIBLE);
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





        // Button'u bul ve tıklama olayını dinle
        btn = ff.findViewById(R.id.button14);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // NavController'ı bul ve ilkk eylemini gerçekleştir
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.ilkk);
            }
        });

        // Düzenlenmiş görünümü (view) döndür
        return ff;
    }
}
