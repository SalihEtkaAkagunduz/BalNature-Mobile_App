package com.erasmus.balnature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erasmus.balnature.databinding.FragmentVeriDuzenleFragment2Binding;
import com.erasmus.balnature.databinding.FragmentVeriInceleFragment2Binding;

import java.util.ArrayList;


public class fragment_veri_incele_fragment_2 extends Fragment {
    FragmentVeriInceleFragment2Binding fff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fff = FragmentVeriInceleFragment2Binding.inflate(inflater, container, false);
        View rootView = fff.getRoot();

        Bundle bundle = getArguments();
        if (bundle != null) {
            veriaktarimi v = (veriaktarimi) bundle.getSerializable("key");
            if (v != null) {
                // Alınan veriyi kullanın...
                int o= bundle.getInt("key2");
                fff.editTextNumber3l.setText(v.getMetala().toString());
                fff.editTextNumberl2l.setText(v.getKağıta().toString());
                fff.editTextNumber4l.setText(v.getCama().toString());
                fff.editTextNumber5l.setText(v.getPlastika().toString());
                fff.editTextNumber6ol.setText(String.valueOf(v.getToplamatık()-(v.getMetala()+v.getCama()+v.getKağıta()+v.getPlastika())));
                fff.editTextNumber3.setText(v.getMetalg().toString());
                fff.editTextNumber2.setText(v.getKağıtg().toString());
                fff.editTextNumber4.setText(v.getCamg().toString());
                fff.editTextNumber5.setText(v.getPlastika().toString());
                fff.progressBar2l.setMax(v.getToplamatık());fff.progressBar2l.setProgress(v.getMetala());
                fff.progressBar4l.setMax(v.getToplamatık());fff.progressBar4l.setProgress(v.getCama());
                fff.progressBar5l.setMax(v.getToplamatık());fff.progressBar5l.setProgress(v.getKağıta());
                fff.progressBar6l.setMax(v.getToplamatık());fff.progressBar6l.setProgress(v.getPlastika());
                fff.progressBar6l.setMax(v.getToplamatık());fff.progressBar7l.setProgress(v.getToplamatık()-(v.getPlastika()+v.getCama()+v.getKağıta()+v.getMetala()));


                fff.progressBar2.setMax(v.getMetala());fff.progressBar2.setProgress(v.getMetalg());
                fff.progressBar4.setMax(v.getCama());fff.progressBar4.setProgress(v.getCamg());
                fff.progressBar5.setMax(v.getKağıta());fff.progressBar5.setProgress(v.getKağıtg());
                fff.progressBar6.setMax(v.getPlastika());fff.progressBar6.setProgress(v.getPlatikg());


                fff.progressBar9.setMax(v.getToplamatık());fff.progressBar9.setProgress(v.getMetala());
                fff.progressBar8.setMax(v.getToplamatık());fff.progressBar8.setProgress(v.getCama());
                fff.progressBar10.setMax(v.getToplamatık());fff.progressBar10.setProgress(v.getKağıta());
                fff.progressBar11.setMax(v.getToplamatık());fff.progressBar11.setProgress(v.getPlastika());
                fff.progressBar12.setMax(v.getToplamatık());fff.progressBar12.setProgress(v.getToplamatık()-(v.getPlastika()+v.getCama()+v.getKağıta()+v.getMetala()));
                fff.editTextText.setText(v.getAd());
                fff.calendarView3.setDate(v.getTarih());
                if(v.getFaliyetalanı().toString().equals("Ev")){

                }
                if(v.getFaliyetalanı().toString().equals("İş Yeri")){

                }
                if(v.getFaliyetalanı().toString().equals("Okul")){

                }
                else{

                }
fff.editTextText2.setText(v.getAçiklama());
if(v.getTur()==1){
fff.radioButton.setSelected(true);

}
else{
    fff.radioButton2.setSelected(true);
}
                fff.progressBar16.setMax(v.getMetala());fff.progressBar16.setProgress(v.getMetalg());
                fff.progressBar14.setMax(v.getCama());fff.progressBar14.setProgress(v.getCamg());
                fff.progressBar17.setMax(v.getKağıta());fff.progressBar17.setProgress(v.getKağıtg());
                fff.progressBar15.setMax(v.getPlastika());fff.progressBar15.setProgress(v.getPlatikg());
fff.progressBar133.setMax(v.getToplamatık());fff.progressBar133.setProgress(v.getPlatikg()+v.getKağıtg()+v.getCamg()+v.getMetalg());
fff.progressBar13.setMax(o*2);fff.progressBar13.setProgress(v.getToplamatık());
                fff.ratingBar.setRating(v.kaydıdegerlendir);
                fff.button14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NavController navController= Navigation.findNavController(requireView());
                        navController.navigate(R.id.tooo);
                    }
                });
                fff.button14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NavController navController= Navigation.findNavController(requireView());
                        navController.navigate(R.id.hoppp);
                    }
                });
            }
        }

        return rootView;
    }
}