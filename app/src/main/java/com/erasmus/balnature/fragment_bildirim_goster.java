package com.erasmus.balnature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class fragment_bildirim_goster extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff=inflater.inflate(R.layout.fragment_bildirim_goster, container, false);
        Bundle bundle = getArguments();
        String v = (String) bundle.getSerializable("key");
        String v1 = (String) bundle.getSerializable("key2");
        TextView txt=ff.findViewById(R.id.textView155);
        TextView txt2=ff.findViewById(R.id.textView156);
        Button btn=ff.findViewById(R.id.button21);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(ff).navigate(R.id.bildirim);
            }
        });
txt.setText(v);
txt2.setText(v1);
        return ff;
    }
}