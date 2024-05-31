package com.erasmus.balnature;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class fragment_ayarlar_sozll extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ff=inflater.inflate(R.layout.fragment_ayarlar_sozll, container, false);

        WebView web=ff.findViewById(R.id.webb);
        web.loadUrl("https://seazer.xyz/privacy.html");
        TextView s=ff.findViewById(R.id.textView137);
        ImageView ss=ff.findViewById(R.id.imageView69);
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sozll_to_fragment_ayarlar_sozlesme);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sozll_to_fragment_ayarlar_sozlesme);
            }
        });
        Button btn =ff.findViewById(R.id.button26);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Uri uri = Uri.parse("https://seazer.xyz/privacy.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
});



        // Inflate the layout for this fragment
        return ff;
    }
}