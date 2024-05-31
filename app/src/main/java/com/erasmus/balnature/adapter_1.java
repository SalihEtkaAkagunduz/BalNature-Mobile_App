package com.erasmus.balnature;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_1 extends RecyclerView.Adapter<adapter_1.CardVTNT> {
    Context mc;
    List<veriaktarimi> ml;
    Integer Ortalama;
    public adapter_1(Context mc, List<veriaktarimi> ml,Integer ortalama) {
        this.mc = mc;
        this.ml = ml;
        this.Ortalama=ortalama;
    }

    @NonNull
    @Override

    public CardVTNT onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vv = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_veri_ekle_list1, parent, false);
        return new CardVTNT(vv);
    }

    @Override
    public void onBindViewHolder(@NonNull CardVTNT holder, int position) {
        veriaktarimi ulke = ml.get(holder.getAdapterPosition());
        holder.baslık.setText(ulke.getAd());
        holder.aciklama.setText(ulke.getAçiklama());
        holder.kg.setText(ulke.getToplamatık().toString());
        if(ulke.getToplamatık()==Ortalama){
            holder.con.setBackgroundResource(R.drawable.fragment_veri_ekle_sari_corner_shape);
        }
        if(ulke.getToplamatık()>Ortalama){
            holder.con.setBackgroundResource(R.drawable.fragment_veri_ekle_kirmizi_corner_shape);

        }

        if(ulke.getToplamatık()<Ortalama){
            holder.con.setBackgroundResource(R.drawable.fragment_veri_ekle_yesil_corner_shape);

        }





    }

    @Override
    public int getItemCount() {
        return ml.size();
    }

    class CardVTNT extends RecyclerView.ViewHolder {
        TextView baslık,aciklama,kg;
        ConstraintLayout con;


        public CardVTNT(View v) {
            super(v);
            baslık = v.findViewById(R.id.textView98);
            aciklama = v.findViewById(R.id.textView99);
            con = v.findViewById(R.id.conn);
            kg=v.findViewById(R.id.textView101);
        }
    }
}
