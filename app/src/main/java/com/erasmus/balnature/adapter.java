package com.erasmus.balnature;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.CardVTNT> {
    Context mc;
    NavController nav;
    List<bild> ml;


    public adapter(Context mc, List<bild> ml, NavController nav) {
        this.mc = mc;
        this.ml = ml;
        this.nav = nav;
    }

    @NonNull
    @Override
    public CardVTNT onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vv = LayoutInflater.from(parent.getContext()).inflate(R.layout.bildirim_layout, parent, false);
        return new CardVTNT(vv);
    }

    @Override
    public void onBindViewHolder(@NonNull CardVTNT holder, int position) {
        int aa = position;
        bild ulke = ml.get(holder.getAdapterPosition());
        String currentDate = ulke.getTarih();



        holder.baslık.setText(ulke.getKonu());
        holder.aciklama.setText(ulke.getAçıklama());
        holder.tarih.setText(currentDate);
        holder.aciklama.setText(ulke.getAçıklama());

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseRef, databaseRef2, databaseRef3, databaseRef4, databaseRef5, databaseRef6, databaseRef7;
                FirebaseAuth mAuth;
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser currentUser = mAuth.getCurrentUser();
                FirebaseDatabase database = FirebaseDatabase.getInstance();


                databaseRef4 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("bildirim");
                Query query = databaseRef4.limitToLast(20);
                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Verileri işlemek için bir List oluşturun
                        ArrayList data = new ArrayList<>();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            bild value = snapshot.getValue(bild.class);
                            if (value.id != ulke.id) {
                                data.add(value);

                            }

                        }
                        databaseRef4.setValue(data);

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Bundle b = new Bundle();


                        b.putString("key", ulke.konu);
                        b.putString("key2", ulke.açıklama);

                        nav.navigate(R.id.fragment_bildirim_goster, b);
                    }
                });

            }
        });
        holder.con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();


                b.putString("key", ulke.konu);
                b.putString("key2", ulke.açıklama);

                nav.navigate(R.id.fragment_bildirim_goster, b);
            }
        });


    }


    @Override
    public int getItemCount() {
        return ml.size();
    }

    class CardVTNT extends RecyclerView.ViewHolder {
        TextView baslık, aciklama, tarih;
        ImageView img;
        ConstraintLayout con;


        public CardVTNT(View v) {
            super(v);
            tarih = v.findViewById(R.id.textView152);
            baslık = v.findViewById(R.id.textView150);
            aciklama = v.findViewById(R.id.textView151);
            con = v.findViewById(R.id.ccc);
            img = v.findViewById(R.id.imageView80);
        }
    }
}
