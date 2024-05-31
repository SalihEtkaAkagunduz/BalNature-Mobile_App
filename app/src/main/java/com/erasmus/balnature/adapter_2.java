package com.erasmus.balnature;

import android.app.AlertDialog;
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

import java.util.List;

public class adapter_2 extends RecyclerView.Adapter<adapter_2.CardVTNT> {
    Context mc;
    List<veriaktarimi> ml;
    Integer Ortalama;
    NavController nav;Integer kayıt;
    public adapter_2(Context mc, List<veriaktarimi> ml, Integer ortalama, NavController nav,Integer kayıt) {
        this.mc = mc;
        this.ml = ml;
        this.Ortalama=ortalama;
        this.nav=nav;
        this.kayıt=kayıt;
    }

    @NonNull
    @Override
    public CardVTNT onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vv = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_veri_ekle_list2, parent, false);
        return new CardVTNT(vv);
    }

    @Override
    public void onBindViewHolder(@NonNull CardVTNT holder, int position) {
        veriaktarimi ulke = ml.get(holder.getAdapterPosition());int aa=position;
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
                b.putInt("key3",kayıt);
                b.putInt("key4",aa);
                nav.navigate(R.id.too,b);

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
