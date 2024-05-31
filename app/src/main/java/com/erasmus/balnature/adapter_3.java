package com.erasmus.balnature;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class adapter_3 extends RecyclerView.Adapter<adapter_3.CardVTNT> {
    Context mc;Integer kayıt,kayıtyeni;
    List<veriaktarimi> ml;
    Integer Ortalama,ortalama,ortalamayeni; int  topcam, topkagıt, tokmetal, topplastik, topcamyeni, topkagıtyeni, tokmetalyeni, topplastikyeni;
    DatabaseReference databaseRef, databaseRef2, databaseRef3, databaseRef4, databaseRef5, databaseRef6, databaseRef7,databaseRef8; FirebaseUser currentUser;
    FirebaseDatabase database;
    FirebaseAuth mAuth;

    public adapter_3(Context mc, List<veriaktarimi> ml, Integer ortalama ) {
        this.mc = mc;
        this.ml = ml;
        this.Ortalama=ortalama;

    }

    @NonNull
    @Override
    public CardVTNT onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vv = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_veri_ekle_list3, parent, false);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        database =  FirebaseDatabase.getInstance();
        return new CardVTNT(vv);
    }

    @Override
    public void onBindViewHolder(@NonNull CardVTNT holder, int position) {
        veriaktarimi ulke = ml.get(holder.getAdapterPosition());
        holder.baslık.setText(ulke.getAd());
        holder.aciklama.setText(ulke.getAçiklama());
int aa=holder.getAdapterPosition();
        if(ulke.getToplamatık()==Ortalama){
            holder.con.setBackgroundResource(R.drawable.fragment_veri_ekle_sari_corner_shape);
        }
        if(ulke.getToplamatık()>Ortalama){
            holder.con.setBackgroundResource(R.drawable.fragment_veri_ekle_kirmizi_corner_shape);

        }
        if(ulke.getToplamatık()<Ortalama){
            holder.con.setBackgroundResource(R.drawable.fragment_veri_ekle_yesil_corner_shape);

        }

        holder.btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                databaseRef2 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("kayitsayisi");
                databaseRef3 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("toplamortalama");
                databaseRef4 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("metalortlama");
                databaseRef5 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("kagitortalama");
                databaseRef6 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("camortalama");
                databaseRef7 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("plastikortalama");
                veriaktarimi k= ml.get(aa);

                databaseRef8 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("veriListesi").child(String.valueOf(aa));
                databaseRef2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        kayıt = (Integer) snapshot.getValue(Integer.class);
                        databaseRef7.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                topplastik = (Integer) snapshot.getValue(Integer.class);
                                databaseRef6.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        topcam = (Integer) snapshot.getValue(Integer.class);
                                        databaseRef5.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                topkagıt = (Integer) snapshot.getValue(Integer.class);
                                                databaseRef4.addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                        tokmetal = (Integer) snapshot.getValue(Integer.class);
                                                        databaseRef3.addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                                if(kayıt==1){

                                                                    ortalamayeni=0;
                                                                    tokmetalyeni=0;
                                                                    topcamyeni=0;
                                                                    topkagıtyeni=0;
                                                                    topplastikyeni=0;
                                                                    kayıtyeni=1;
                                                                    databaseRef7.setValue(topplastikyeni);
                                                                    databaseRef2.setValue(kayıtyeni);
                                                                    databaseRef3.setValue(ortalamayeni);
                                                                    databaseRef4.setValue(tokmetalyeni);
                                                                    databaseRef5.setValue(topkagıtyeni);
                                                                    databaseRef6.setValue(topcamyeni);
                                                                }
                                                                else{
                                                                    ortalama = (Integer) snapshot.getValue(Integer.class);
                                                                    ortalamayeni=((kayıt*ortalama)-k.getToplamatık()) /(kayıt-1);
                                                                    tokmetalyeni=((kayıt*tokmetal)-k.getMetala()) /(kayıt-1);
                                                                    topcamyeni=((kayıt*topcam)-k.getCama()) /(kayıt-1);
                                                                    topkagıtyeni=((kayıt*topkagıt)-k.getKağıta()) /(kayıt-1);
                                                                    topplastikyeni=((kayıt*topplastik)-k.getPlastika()) /(kayıt-1);
                                                                    kayıtyeni=kayıt-1;
                                                                    databaseRef7.setValue(topplastikyeni);
                                                                    databaseRef2.setValue(kayıtyeni);
                                                                    databaseRef3.setValue(ortalamayeni);
                                                                    databaseRef4.setValue(tokmetalyeni);
                                                                    databaseRef5.setValue(topkagıtyeni);
                                                                    databaseRef6.setValue(topcamyeni);
                                                                }

                                                            }

                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {
                                                                Log.e("aa",error.getMessage().toString());
                                                            }
                                                        });
                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError error) {
                                                        Log.e("aa",error.getMessage().toString());
                                                    }
                                                });

                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {
                                                Log.e("aa",error.getMessage().toString());
                                            }
                                        });

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        Log.e("aa",error.getMessage().toString());
                                    }
                                });

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Log.e("aa",error.getMessage().toString());
                            }
                        });

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("aa",error.getMessage().toString());
                    }
                });
                databaseRef8.removeValue();
                ml.remove(aa);
                notifyDataSetChanged();
            }
        });



    }

    @Override
    public int getItemCount() {
        return ml.size();
    }

    class CardVTNT extends RecyclerView.ViewHolder {
        TextView baslık,aciklama,kg;
        ConstraintLayout con;
Button btn;

        public CardVTNT(View v) {
            super(v);
            baslık = v.findViewById(R.id.textView98);
            aciklama = v.findViewById(R.id.textView99);
            con = v.findViewById(R.id.conn);
            btn=v.findViewById(R.id.button15);
        }
    }
}
