

    package com.erasmus.balnature;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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


    public class fragment_veri_cikar extends Fragment {
        Button btn;
        RecyclerView rv;
        List<veriaktarimi> data;
        adapter_3 adptr;
        Integer ortalama;
        ProgressBar pss;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View ff=inflater.inflate(R.layout.fragment_veri_cikar, container, false);
            DatabaseReference databaseRef, databaseRef2, databaseRef3, databaseRef4, databaseRef5, databaseRef6, databaseRef7;
            FirebaseAuth mAuth;
            rv=ff.findViewById(R.id.rec2);
            pss=ff.findViewById(R.id.progressBar23);
            mAuth = FirebaseAuth.getInstance();
            FirebaseUser currentUser = mAuth.getCurrentUser();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            databaseRef3 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("toplamortalama");
            databaseRef4 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("veriListesi");

            databaseRef3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    ortalama = (Integer) snapshot.getValue(Integer.class);
                    Query lastTenItemsQuery = databaseRef4.limitToLast(10);
                    databaseRef4.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // Verileri işlemek için bir List oluşturun
                            data= new ArrayList<>();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                veriaktarimi value = snapshot.getValue(veriaktarimi.class);
                                data.add(value);
                            }
                            adptr=new adapter_3(ff.getContext(),data,ortalama);

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
            return ff;
        }
    }