package com.erasmus.balnature;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class fragment_ayarlar_bilgisayarsrm extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ff=inflater.inflate(R.layout.fragment_ayarlar_bilgisayarsrm, container, false);
        Button btn=ff.findViewById(R.id.button20);
        TextView txt=ff.findViewById(R.id.textView144);
        ImageView ımg=ff.findViewById(R.id.imageView74);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.seazer.xyz/balnature/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_bilgisayarsrm_to_fragment_ayarlar_ana);
            }
        });
        ımg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_bilgisayarsrm_to_fragment_ayarlar_ana);
            }
        });
        return  ff;
    }
}