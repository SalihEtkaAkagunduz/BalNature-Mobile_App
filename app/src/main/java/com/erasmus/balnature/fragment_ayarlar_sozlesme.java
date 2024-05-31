package com.erasmus.balnature;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class fragment_ayarlar_sozlesme extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View ff=inflater.inflate(R.layout.fragment_ayarlar_sozlesme, container, false);

        ConstraintLayout layout1 = ff.findViewById(R.id.constraintLayout56);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("click", "click");

                Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sozlesme_to_fragment_ayarlar_sozll);
            }
        });
        TextView s=ff.findViewById(R.id.textView137);
        ImageView ss=ff.findViewById(R.id.imageView69);
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sozlesme_to_fragment_ayarlar_ana);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_sozlesme_to_fragment_ayarlar_ana);
            }
        });
        setTouchListener(layout1);
        return ff;
    } private void setTouchListener(final ConstraintLayout layout) {
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Üzerine gelindiğinde buraya kod ekleyin
                        // Arka plan rengini değiştirin veya diğer işlemleri gerçekleştirin
                        layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.renkiste));
                        break;
                    case MotionEvent.ACTION_UP:
                        // Dokunma bittiğinde buraya kod ekleyin
                        // Arka plan rengini geri döndürün veya diğer işlemleri gerçekleştirin
                        layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.renkaa));

                        // Eğer bu bir tıklama ise OnClickListener'ı çağırın
                        v.performClick();


                        break;
                    case MotionEvent.ACTION_CANCEL:
                        // Dokunma iptal edildiğinde buraya kod ekleyin
                        // Arka plan rengini geri döndürün veya diğer işlemleri gerçekleştirin
                        layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.renkaa));
                        break;
                }
                return true; // true döndürerek olayın tüketildiğini belirtin
            }
        });
    }

}