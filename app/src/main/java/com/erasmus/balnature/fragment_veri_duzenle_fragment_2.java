package com.erasmus.balnature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.erasmus.balnature.databinding.FragmentVeriDuzenleFragment2Binding;
import com.erasmus.balnature.databinding.FragmentVeriInceleFragment2Binding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class fragment_veri_duzenle_fragment_2 extends Fragment {
    FragmentVeriDuzenleFragment2Binding fff;  List<veriaktarimi> ml;
 DatabaseReference databaseRef, databaseRef2, databaseRef3, databaseRef4, databaseRef5, databaseRef6, databaseRef7,databaseRef8; FirebaseAuth mAuth;NavController nav;
    FirebaseDatabase database; FirebaseUser currentUser;
    Button btn;
    Integer Ortalama,ortalama,position,ortalamayeni,kayıt; int  topcam, topkagıt, tokmetal, topplastik, topcamyeni, topkagıtyeni, tokmetalyeni, topplastikyeni, ytopcamyeni, ytopkagıtyeni, ytokmetalyeni, ytopplastikyeni;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fff = FragmentVeriDuzenleFragment2Binding.inflate(inflater, container, false);
        View rootView = fff.getRoot();

        Bundle bundle = getArguments();

        if (bundle != null) {
            veriaktarimi v = (veriaktarimi) bundle.getSerializable("key");
            // v nesnesinden klon oluşturun
            veriaktarimi vv = v.clone();

            if (v != null) {
                // Alınan veriyi kullanın...
                  ortalama = bundle.getInt("key2");
                kayıt=bundle.getInt("key3");
                position=bundle.getInt("key4");
                mAuth = FirebaseAuth.getInstance();
                currentUser = mAuth.getCurrentUser();
                database =  FirebaseDatabase.getInstance();
                databaseRef2 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("kayitsayisi");
                databaseRef3 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("toplamortalama");
                databaseRef4 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("metalortlama");
                databaseRef5 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("kagitortalama");
                databaseRef6 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("camortalama");
                databaseRef7 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("plastikortalama");
                databaseRef8 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("veriListesi").child(String.valueOf(position));
                fff.editTextNumber3l.setText(v.getMetala().toString());
                fff.editTextNumberl2l.setText(v.getKağıta().toString());
                fff.editTextNumber4l.setText(v.getCama().toString());
                fff.editTextNumber5l.setText(v.getPlastika().toString());
                fff.editTextNumber6ol.setText(String.valueOf(v.getToplamatık() - (v.getMetala() + v.getCama() + v.getKağıta() + v.getPlastika())));
                fff.editTextNumber3.setText(v.getMetalg().toString());
                fff.editTextNumber2.setText(v.getKağıtg().toString());
                fff.editTextNumber4.setText(v.getCamg().toString());
                fff.editTextNumber5.setText(v.getPlastika().toString());
                fff.progressBar2l.setMax(v.getToplamatık());
                fff.progressBar2l.setProgress(v.getMetala());
                fff.progressBar4l.setMax(v.getToplamatık());
                fff.progressBar4l.setProgress(v.getCama());
                fff.progressBar5l.setMax(v.getToplamatık());
                fff.progressBar5l.setProgress(v.getKağıta());
                fff.progressBar6l.setMax(v.getToplamatık());
                fff.progressBar6l.setProgress(v.getPlastika());
                fff.progressBar6l.setMax(v.getToplamatık());
                fff.progressBar7l.setProgress(v.getToplamatık() - (v.getPlastika() + v.getCama() + v.getKağıta() + v.getMetala()));


                fff.progressBar2.setMax(v.getMetala());
                fff.progressBar2.setProgress(v.getMetalg());
                fff.progressBar4.setMax(v.getCama());
                fff.progressBar4.setProgress(v.getCamg());
                fff.progressBar5.setMax(v.getKağıta());
                fff.progressBar5.setProgress(v.getKağıtg());
                fff.progressBar6.setMax(v.getPlastika());
                fff.progressBar6.setProgress(v.getPlatikg());

fff.button13.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.tooo);
    }
});
                fff.button14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer ıı=Integer.parseInt(fff.editTextNumber3.getText().toString());
                        Integer ıı2=Integer.parseInt(fff.editTextNumber2.getText().toString());
                        Integer ıı3=Integer.parseInt(fff.editTextNumber4.getText().toString());
                        Integer ıı4=Integer.parseInt(fff.editTextNumber5.getText().toString());

                        Integer ııı=Integer.parseInt(fff.editTextNumber3l.getText().toString());
                        Integer ııı2=Integer.parseInt(fff.editTextNumberl2l.getText().toString());
                        Integer ııı3=Integer.parseInt(fff.editTextNumber4l.getText().toString());
                        Integer ııı4=Integer.parseInt(fff.editTextNumber5l.getText().toString());

                         vv.setToplamatık(ııı+ııı2+ııı3+ııı4+(v.getToplamatık()-(v.getKağıta()+v.getKağıta()+v.getCama()+v.getMetala())));
                         vv.setMetala(ııı);
                         vv.setCama(ııı2);
                         vv.setKağıta(ııı3);
                         vv.setPlastika(ııı4);


                         vv.setMetalg(ıı);
                         vv.setCamg(ıı2);
                         vv.setKağıtg(ıı3);
                         vv.setPlatikg(ıı4);




                        ortalamayeni=((kayıt*ortalama)-v.getToplamatık()+vv.getToplamatık()) /(kayıt);
                        tokmetalyeni=((tokmetal*tokmetal)-v.getMetala()+vv.getMetala()) /(kayıt);
                        topcamyeni=((topcam*topcam)-v.getCama()+vv.getCama()) /(kayıt);
                        topkagıtyeni=((topkagıt*topkagıt)-v.getKağıta()+vv.getKağıta()) /(kayıt);
                        topplastikyeni=((topplastik*topplastik)-v.getPlastika()+vv.getPlastika()) /(kayıt);
                        databaseRef7.setValue(topplastikyeni);
databaseRef8.setValue(vv);
                        databaseRef3.setValue(ortalamayeni);
                        databaseRef4.setValue(tokmetalyeni);
                        databaseRef5.setValue(topkagıtyeni);
                        databaseRef6.setValue(topcamyeni);
                        NavController navController = Navigation.findNavController(requireView());
                        navController.navigate(R.id.tooo);
                    }
                });

            }
        }

        return rootView;
    }
}