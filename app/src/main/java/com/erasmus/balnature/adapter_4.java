package com.erasmus.balnature;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class adapter_4 extends RecyclerView.Adapter<adapter_4.CardVTNT> {
    Context mc;
     NavController nav;
    List<veriaktarimi> ml;
    Integer Ortalama;
Integer kayıt;
    public adapter_4(Context mc, List<veriaktarimi> ml, Integer ortalama, NavController nav ) {
        this.mc = mc;
        this.ml = ml;

        this.Ortalama=ortalama;
        this.nav=nav;
    }

    @NonNull
    @Override
    public CardVTNT onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vv = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_veri_ekle_list4, parent, false);




        return new CardVTNT(vv);
    }

    @Override
    public void onBindViewHolder(@NonNull CardVTNT holder, int position) {
        int aa=position;


        veriaktarimi ulke = ml.get(holder.getAdapterPosition());
        holder.baslık.setText(ulke.getAd());
        holder.aciklama.setText(ulke.getAçiklama());

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
        Bundle b=new Bundle();
        veriaktarimi ver= ml.get(aa);
        int ortalama=Ortalama;
        b.putSerializable("key",ver);
        b.putInt("key2",ortalama);


        nav.navigate(R.id.hopp,b);


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
