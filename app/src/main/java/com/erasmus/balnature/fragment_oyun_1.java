package com.erasmus.balnature;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;


public class fragment_oyun_1 extends Fragment {
    Integer tıklı=1;
    ImageView img,img2,img3,img4,img5,img6,img7;
    public static fragment_oyun_1 newInstance(String veri) {
        fragment_oyun_1 fragment = new fragment_oyun_1();
        Bundle args = new Bundle();
        args.putString("veriAnahtari", veri);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff=inflater.inflate(R.layout.fragment_oyun_1, container, false);
        img=ff.findViewById(R.id.imageView85);


        img2=ff.findViewById(R.id.imageView86);

        img3=ff.findViewById(R.id.imageView87);
        img4=ff.findViewById(R.id.imageView88);
        img5=ff.findViewById(R.id.imageView89);
        img6=ff.findViewById(R.id.imageView90);
        img7=ff.findViewById(R.id.imageView91);
/*
     DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("oyun");
        üstoyun1 üst1=new üstoyun1("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true);
        üstoyun2 üst2=new üstoyun2("https://seazer.xyz/balnature/resim16.jpg","deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals", "https://seazer.xyz/balnature/resim29.jpg","https://seazer.xyz/balnature/resim1.jpg ","https://seazer.xyz/balnature/resim29.jpg","https://seazer.xyz/balnature/resim30.jpg","https://seazer.xyz/balnature/resim31.jpg","https://seazer.xyz/balnature/resim32.jpg","God Worker Boid","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true);
        üstoyun3 üst3=new üstoyun3("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim3.jpg", "https://seazer.xyz/balnature/resim7.jpg" ,  "https://seazer.xyz/balnature/resim15.jpg","https://seazer.xyz/balnature/resim7.jpg" ,"https://seazer.xyz/balnature/resim8.jpg","https://seazer.xyz/balnature/resim9.jpg","https://seazer.xyz/balnature/resim11.jpg","Nature.io","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true);
        üstoyun4 üst4=new üstoyun4("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim41.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true);
        üstoyun5 üst5=new üstoyun5( "https://seazer.xyz/balnature/resim42.jpg","https://seazer.xyz/balnature/resim22.jpg","deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true);
        üstoyun6 üst6=new üstoyun6( "https://seazer.xyz/balnature/resim43.jpg","https://seazer.xyz/balnature/resim22.jpg","deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true);
        ArrayList<tümoy> tümm=new ArrayList<>();
        tümm.add(new tümoy("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        tümm.add(new tümoy("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim16.jpg","https://seazer.xyz/balnature/resim16.jpg","https://seazer.xyz/balnature/resim1.jpg ","https://seazer.xyz/balnature/resim29.jpg","https://seazer.xyz/balnature/resim30.jpg","https://seazer.xyz/balnature/resim31.jpg","https://seazer.xyz/balnature/resim32.jpg","God Worker Boid","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        tümm.add(new tümoy("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim3.jpg","https://seazer.xyz/balnature/resim3.jpg",  "https://seazer.xyz/balnature/resim15.jpg","https://seazer.xyz/balnature/resim7.jpg","https://seazer.xyz/balnature/resim8.jpg","https://seazer.xyz/balnature/resim9.jpg","https://seazer.xyz/balnature/resim11.jpg","Nature.io","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        tümm.add(new tümoy("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim41.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        tümm.add(new tümoy("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim42.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        tümm.add(new tümoy("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim43.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));

        ArrayList<popülero> pop=new ArrayList<>();
        pop.add(new popülero("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
       pop.add(new popülero("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim16.jpg","https://seazer.xyz/balnature/resim16.jpg", "https://seazer.xyz/balnature/resim1.jpg ","https://seazer.xyz/balnature/resim29.jpg","https://seazer.xyz/balnature/resim30.jpg","https://seazer.xyz/balnature/resim31.jpg","https://seazer.xyz/balnature/resim32.jpg","God Worker Boid","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
       pop.add(new popülero("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim3.jpg","https://seazer.xyz/balnature/resim3.jpg",   "https://seazer.xyz/balnature/resim15.jpg","https://seazer.xyz/balnature/resim7.jpg","https://seazer.xyz/balnature/resim8.jpg","https://seazer.xyz/balnature/resim9.jpg","https://seazer.xyz/balnature/resim11.jpg","Nature.io","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
       pop.add(new popülero("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim41.jpg","https://seazer.xyz/balnature/resim44.jpg", "https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
       pop.add(new popülero("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim42.jpg","https://seazer.xyz/balnature/resim44.jpg", "https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
       pop.add(new popülero("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim43.jpg","https://seazer.xyz/balnature/resim44.jpg", "https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));

        ArrayList<önerilero> önn=new ArrayList<>();
        önn.add(new önerilero("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        önn.add(new önerilero("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim16.jpg","https://seazer.xyz/balnature/resim16.jpg","https://seazer.xyz/balnature/resim1.jpg ","https://seazer.xyz/balnature/resim29.jpg","https://seazer.xyz/balnature/resim30.jpg","https://seazer.xyz/balnature/resim31.jpg","https://seazer.xyz/balnature/resim32.jpg","God Worker Boid","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        önn.add(new önerilero("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim3.jpg","https://seazer.xyz/balnature/resim3.jpg",  "https://seazer.xyz/balnature/resim15.jpg","https://seazer.xyz/balnature/resim7.jpg","https://seazer.xyz/balnature/resim8.jpg","https://seazer.xyz/balnature/resim9.jpg","https://seazer.xyz/balnature/resim11.jpg","Nature.io","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        önn.add(new önerilero("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim41.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        önn.add(new önerilero("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim42.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        önn.add(new önerilero("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim43.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));




        ArrayList<yenioyunlar> yyy=new ArrayList<>();
        yyy.add(new yenioyunlar("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        yyy.add(new yenioyunlar("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim16.jpg","https://seazer.xyz/balnature/resim16.jpg","https://seazer.xyz/balnature/resim1.jpg ","https://seazer.xyz/balnature/resim29.jpg","https://seazer.xyz/balnature/resim30.jpg","https://seazer.xyz/balnature/resim31.jpg","https://seazer.xyz/balnature/resim32.jpg","God Worker Boid","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        yyy.add(new yenioyunlar("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim3.jpg","https://seazer.xyz/balnature/resim3.jpg",  "https://seazer.xyz/balnature/resim15.jpg","https://seazer.xyz/balnature/resim7.jpg","https://seazer.xyz/balnature/resim8.jpg","https://seazer.xyz/balnature/resim9.jpg","https://seazer.xyz/balnature/resim11.jpg","Nature.io","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        yyy.add(new yenioyunlar("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim41.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        yyy.add(new yenioyunlar("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim42.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        yyy.add(new yenioyunlar("deafşldskflşakfişlaksf","lşwdwskflşsdjkflşasdjgkldfşsjglksdfhjgslkdfjgdals","https://seazer.xyz/balnature/resim43.jpg","https://seazer.xyz/balnature/resim44.jpg","https://seazer.xyz/balnature/resim19.jpg","https://seazer.xyz/balnature/resim22.jpg","https://seazer.xyz/balnature/resim23.jpg","https://seazer.xyz/balnature/resim24.jpg","https://seazer.xyz/balnature/resim20.jpg","Bootle and Advantures","",1,"Bal Nature LCC.","Bal Nature LCC.","28.9",new Date(),"Platform",true,true,true,true,true,true,true,true,true,true));
        oyundata oy=new oyundata(üst1,üst2,üst3,üst4,üst5,üst6,tümm,pop,önn,yyy);

        mDatabase.setValue(oy)
                .addOnSuccessListener(aVoid -> {



                })
                .addOnFailureListener(e -> {
                    // Kullanıcı bilgileri kaydedilirken bir hata oluştu
                    Log.e("Firebase", "Kullanıcı bilgileri kaydedilirken hata oluştu: " + e.getMessage());
                });*/
        final oyundata[] oyp = {new oyundata()};

        String resim1,resim2,resim3,resim4,resim5,resim6,resim7;
        DatabaseReference databaseRef;
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
       databaseRef = FirebaseDatabase.getInstance().getReference("oyun");

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                oyundata data = snapshot.getValue(oyundata.class);
oyp[0] =data;
                    Picasso.get()
                            .load(data.üstoyun1.resim1)
                            .into(img);
                    Picasso.get()
                            .load(data.üstoyun6.resim1)
                            .into(img7);
                    Picasso.get()
                            .load(data.üstoyun2.resim1)
                            .into(img3);
                    Picasso.get()
                            .load(data.üstoyun3.resim1)
                            .into(img4);
                    Picasso.get()
                            .load(data.üstoyun4.resim1)
                            .into(img5);
                    Picasso.get()
                            .load(data.üstoyun5.resim1)
                            .into(img6);
                    Picasso.get()
                            .load(data.üstoyun1.resim1)
                            .into(img2);



                LinearLayout linearLayout;
                linearLayout = ff.findViewById(R.id.linearr); // LinearLayout'ı bulun
                for (int i = 0; i < oyp[0].yenioyun.stream().count(); i++) {
                    CardView cardView = new CardView(ff.getContext());
                    int cardWidth = getResources().getDimensionPixelSize(R.dimen.card_width); // R.dimen.card_width değerini kullanabilirsiniz
                    int cardHeight = getResources().getDimensionPixelSize(R.dimen.card_height); // R.dimen.card_height değerini kullanabilirsiniz
                    cardView.setLayoutParams(new LinearLayout.LayoutParams(cardWidth, cardHeight));
                    cardView.setRadius(35);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) cardView.getLayoutParams();
                    params.setMargins(16, 40, 16, 0);
                    cardView.setLayoutParams(params);
                    ConstraintLayout constraintLayout = new ConstraintLayout(ff.getContext());
                    cardView.addView(constraintLayout);
                    ImageView imageView = new ImageView(ff.getContext());
                    imageView.setLayoutParams(new ConstraintLayout.LayoutParams(
                            ConstraintLayout.LayoutParams.MATCH_PARENT,
                            ConstraintLayout.LayoutParams.MATCH_PARENT
                    ));
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.get()
                            .load(oyp[0].yenioyun.get(i).resim)
                            .into(imageView);
                    imageView.setImageResource(R.drawable.yenioyun1); // Resminizi ayarlayın
                    constraintLayout.addView(imageView);
                    linearLayout.addView(cardView);}


                LinearLayout linearLayout2;
                linearLayout2 = ff.findViewById(R.id.linearrr); // LinearLayout'ı bulun
                for (int i = 0; i < oyp[0].onerilenoyunlar.stream().count(); i++) {
                    CardView cardView = new CardView(ff.getContext());
                    int cardWidth = getResources().getDimensionPixelSize(R.dimen.card_width); // R.dimen.card_width değerini kullanabilirsiniz
                    int cardHeight = getResources().getDimensionPixelSize(R.dimen.card_height); // R.dimen.card_height değerini kullanabilirsiniz
                    cardView.setLayoutParams(new LinearLayout.LayoutParams(cardWidth, cardHeight));
                    cardView.setRadius(35);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) cardView.getLayoutParams();
                    params.setMargins(16, 40, 16, 0);
                    cardView.setLayoutParams(params);
                    ConstraintLayout constraintLayout = new ConstraintLayout(ff.getContext());
                    cardView.addView(constraintLayout);
                    ImageView imageView = new ImageView(ff.getContext());
                    imageView.setLayoutParams(new ConstraintLayout.LayoutParams(
                            ConstraintLayout.LayoutParams.MATCH_PARENT,
                            ConstraintLayout.LayoutParams.MATCH_PARENT
                    ));
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.get()
                            .load(oyp[0].onerilenoyunlar.get(i).resim)
                            .into(imageView);
                    imageView.setImageResource(R.drawable.yenioyun1); // Resminizi ayarlayın
                    constraintLayout.addView(imageView);
                    linearLayout2.addView(cardView);}



                LinearLayout linearLayout3;
                linearLayout3 = ff.findViewById(R.id.linearrrr); // LinearLayout'ı bulun
                for (int i = 0; i < oyp[0].populeroyunlar.stream().count(); i++) {
                    CardView cardView = new CardView(ff.getContext());
                    int cardWidth = getResources().getDimensionPixelSize(R.dimen.card_width); // R.dimen.card_width değerini kullanabilirsiniz
                    int cardHeight = getResources().getDimensionPixelSize(R.dimen.card_height); // R.dimen.card_height değerini kullanabilirsiniz
                    cardView.setLayoutParams(new LinearLayout.LayoutParams(cardWidth, cardHeight));
                    cardView.setRadius(35);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) cardView.getLayoutParams();
                    params.setMargins(16, 40, 16, 0);
                    cardView.setLayoutParams(params);
                    ConstraintLayout constraintLayout = new ConstraintLayout(ff.getContext());
                    cardView.addView(constraintLayout);
                    ImageView imageView = new ImageView(ff.getContext());
                    imageView.setLayoutParams(new ConstraintLayout.LayoutParams(
                            ConstraintLayout.LayoutParams.MATCH_PARENT,
                            ConstraintLayout.LayoutParams.MATCH_PARENT
                    ));
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.get()
                            .load(oyp[0].populeroyunlar.get(i).resim)
                            .into(imageView);
                    imageView.setImageResource(R.drawable.yenioyun1); // Resminizi ayarlayın
                    constraintLayout.addView(imageView);
                    linearLayout3.addView(cardView);}




                LinearLayout linearLayout4;
                linearLayout4 = ff.findViewById(R.id.linearrrrr); // LinearLayout'ı bulun
                for (int i = 0; i < oyp[0].tümoyunlar.stream().count(); i++) {
                    CardView cardView = new CardView(ff.getContext());
                    int cardWidth = getResources().getDimensionPixelSize(R.dimen.card_width); // R.dimen.card_width değerini kullanabilirsiniz
                    int cardHeight = getResources().getDimensionPixelSize(R.dimen.card_height); // R.dimen.card_height değerini kullanabilirsiniz
                    cardView.setLayoutParams(new LinearLayout.LayoutParams(cardWidth, cardHeight));
                    cardView.setRadius(35);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) cardView.getLayoutParams();
                    params.setMargins(16, 40, 16, 0);
                    cardView.setLayoutParams(params);
                    ConstraintLayout constraintLayout = new ConstraintLayout(ff.getContext());
                    cardView.addView(constraintLayout);
                    ImageView imageView = new ImageView(ff.getContext());
                    imageView.setLayoutParams(new ConstraintLayout.LayoutParams(
                            ConstraintLayout.LayoutParams.MATCH_PARENT,
                            ConstraintLayout.LayoutParams.MATCH_PARENT
                    ));
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.get()
                            .load(oyp[0].tümoyunlar.get(i).resim)
                            .into(imageView);
                    imageView.setImageResource(R.drawable.yenioyun1); // Resminizi ayarlayın
                    constraintLayout.addView(imageView);
                    linearLayout4.addView(cardView);}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable sourceDrawable = img2.getDrawable();
tıklı=1;
                if (sourceDrawable != null) {
                    // Kaynak resmin boyutlarını alın
                    int sourceWidth = sourceDrawable.getIntrinsicWidth();
                    int sourceHeight = sourceDrawable.getIntrinsicHeight();

                    // Hedef ImageView'ın boyutlarını alın
                    int targetWidth = img.getWidth();
                    int targetHeight = img.getHeight();

                    // Hedef ImageView'a uyan bir Bitmap oluşturun
                    Bitmap scaledBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);

                    // Canvas kullanarak Bitmap'i çizin
                    Canvas canvas = new Canvas(scaledBitmap);

                    // Ölçekleme matrisi oluşturun
                    Matrix matrix = new Matrix();
                    matrix.setScale((float) targetWidth / sourceWidth, (float) targetHeight / sourceHeight);

                    // Kaynak resmi bu matrisi kullanarak ölçekleyin ve hedef Bitmap'e çizin
                    canvas.drawBitmap(((BitmapDrawable) sourceDrawable).getBitmap(), matrix, null);

                    // Ölçeklendirilmiş resmi ImageView'da gösterin
                    img.setImageBitmap(scaledBitmap);
                }
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable sourceDrawable = img3.getDrawable();
                tıklı=2;
                if (sourceDrawable != null) {
                    // Kaynak resmin boyutlarını alın
                    int sourceWidth = sourceDrawable.getIntrinsicWidth();
                    int sourceHeight = sourceDrawable.getIntrinsicHeight();

                    // Hedef ImageView'ın boyutlarını alın
                    int targetWidth = img.getWidth();
                    int targetHeight = img.getHeight();

                    // Hedef ImageView'a uyan bir Bitmap oluşturun
                    Bitmap scaledBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);

                    // Canvas kullanarak Bitmap'i çizin
                    Canvas canvas = new Canvas(scaledBitmap);

                    // Ölçekleme matrisi oluşturun
                    Matrix matrix = new Matrix();
                    matrix.setScale((float) targetWidth / sourceWidth, (float) targetHeight / sourceHeight);

                    // Kaynak resmi bu matrisi kullanarak ölçekleyin ve hedef Bitmap'e çizin
                    canvas.drawBitmap(((BitmapDrawable) sourceDrawable).getBitmap(), matrix, null);

                    // Ölçeklendirilmiş resmi ImageView'da gösterin
                    img.setImageBitmap(scaledBitmap);
                }
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable sourceDrawable = img4.getDrawable();
                tıklı=3;
                if (sourceDrawable != null) {
                    // Kaynak resmin boyutlarını alın
                    int sourceWidth = sourceDrawable.getIntrinsicWidth();
                    int sourceHeight = sourceDrawable.getIntrinsicHeight();

                    // Hedef ImageView'ın boyutlarını alın
                    int targetWidth = img.getWidth();
                    int targetHeight = img.getHeight();

                    // Hedef ImageView'a uyan bir Bitmap oluşturun
                    Bitmap scaledBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);

                    // Canvas kullanarak Bitmap'i çizin
                    Canvas canvas = new Canvas(scaledBitmap);

                    // Ölçekleme matrisi oluşturun
                    Matrix matrix = new Matrix();
                    matrix.setScale((float) targetWidth / sourceWidth, (float) targetHeight / sourceHeight);

                    // Kaynak resmi bu matrisi kullanarak ölçekleyin ve hedef Bitmap'e çizin
                    canvas.drawBitmap(((BitmapDrawable) sourceDrawable).getBitmap(), matrix, null);

                    // Ölçeklendirilmiş resmi ImageView'da gösterin
                    img.setImageBitmap(scaledBitmap);
                }
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable sourceDrawable = img5.getDrawable();
                tıklı=4;
                if (sourceDrawable != null) {
                    // Kaynak resmin boyutlarını alın
                    int sourceWidth = sourceDrawable.getIntrinsicWidth();
                    int sourceHeight = sourceDrawable.getIntrinsicHeight();

                    // Hedef ImageView'ın boyutlarını alın
                    int targetWidth = img.getWidth();
                    int targetHeight = img.getHeight();

                    // Hedef ImageView'a uyan bir Bitmap oluşturun
                    Bitmap scaledBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);

                    // Canvas kullanarak Bitmap'i çizin
                    Canvas canvas = new Canvas(scaledBitmap);

                    // Ölçekleme matrisi oluşturun
                    Matrix matrix = new Matrix();
                    matrix.setScale((float) targetWidth / sourceWidth, (float) targetHeight / sourceHeight);

                    // Kaynak resmi bu matrisi kullanarak ölçekleyin ve hedef Bitmap'e çizin
                    canvas.drawBitmap(((BitmapDrawable) sourceDrawable).getBitmap(), matrix, null);

                    // Ölçeklendirilmiş resmi ImageView'da gösterin
                    img.setImageBitmap(scaledBitmap);
                }
            }
        });img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable sourceDrawable = img6.getDrawable();
                tıklı=5;
                if (sourceDrawable != null) {
                    // Kaynak resmin boyutlarını alın
                    int sourceWidth = sourceDrawable.getIntrinsicWidth();
                    int sourceHeight = sourceDrawable.getIntrinsicHeight();

                    // Hedef ImageView'ın boyutlarını alın
                    int targetWidth = img.getWidth();
                    int targetHeight = img.getHeight();

                    // Hedef ImageView'a uyan bir Bitmap oluşturun
                    Bitmap scaledBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);

                    // Canvas kullanarak Bitmap'i çizin
                    Canvas canvas = new Canvas(scaledBitmap);

                    // Ölçekleme matrisi oluşturun
                    Matrix matrix = new Matrix();
                    matrix.setScale((float) targetWidth / sourceWidth, (float) targetHeight / sourceHeight);

                    // Kaynak resmi bu matrisi kullanarak ölçekleyin ve hedef Bitmap'e çizin
                    canvas.drawBitmap(((BitmapDrawable) sourceDrawable).getBitmap(), matrix, null);

                    // Ölçeklendirilmiş resmi ImageView'da gösterin
                    img.setImageBitmap(scaledBitmap);
                }
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

// Kaynak resmi al
                Drawable sourceDrawable = img7.getDrawable();
                tıklı=6;
                if (sourceDrawable != null) {
                    // Kaynak resmin boyutlarını alın
                    int sourceWidth = sourceDrawable.getIntrinsicWidth();
                    int sourceHeight = sourceDrawable.getIntrinsicHeight();

                    // Hedef ImageView'ın boyutlarını alın
                    int targetWidth = img.getWidth();
                    int targetHeight = img.getHeight();

                    // Hedef ImageView'a uyan bir Bitmap oluşturun
                    Bitmap scaledBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);

                    // Canvas kullanarak Bitmap'i çizin
                    Canvas canvas = new Canvas(scaledBitmap);

                    // Ölçekleme matrisi oluşturun
                    Matrix matrix = new Matrix();
                    matrix.setScale((float) targetWidth / sourceWidth, (float) targetHeight / sourceHeight);

                    // Kaynak resmi bu matrisi kullanarak ölçekleyin ve hedef Bitmap'e çizin
                    canvas.drawBitmap(((BitmapDrawable) sourceDrawable).getBitmap(), matrix, null);

                    // Ölçeklendirilmiş resmi ImageView'da gösterin
                    img.setImageBitmap(scaledBitmap);
                }





            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Bundle bundle=new Bundle();
                oyungoster oo=new oyungoster();
                if(tıklı==1){
                    oo.kısaacık=oyp[0].üstoyun1.kısaacık;
                    oo.kısaacık=oyp[0].üstoyun1.uzunacık;
                    oo.android=   oyp[0].üstoyun1.android;
                    oo.resim2=    oyp[0].üstoyun1.resim2;
                    oo.resim=     oyp[0].üstoyun1.resim1;
                    oo.resim3=    oyp[0].üstoyun1.resim3;
                    oo.resim4=    oyp[0].üstoyun1.resim4;
                    oo.resim5=    oyp[0].üstoyun1.resim5;
                    oo.resim6=    oyp[0].üstoyun1.resim6;
                    oo.isim=      oyp[0].üstoyun1.isim;
                    oo.dosya=     oyp[0].üstoyun1.dosya;
                    oo.indirilimi=oyp[0].üstoyun1.indirilimi;
                    oo.Geliştiren=oyp[0].üstoyun1.Geliştiren;
                    oo.Yayımlayan=oyp[0].üstoyun1.Yayımlayan;
                    oo.boyut=     oyp[0].üstoyun1.boyut;
                    oo.tarih=     oyp[0].üstoyun1.tarih;
                    oo.tür=       oyp[0].üstoyun1.tür;
                    oo.pc=        oyp[0].üstoyun1.pc;
                    oo.çevrimdisi=oyp[0].üstoyun1.çevrimdisi;
                    oo.tekoyun=   oyp[0].üstoyun1.tekoyun;
                    oo.balnature= oyp[0].üstoyun1.balnature;
                    oo.cabraz=    oyp[0].üstoyun1.cabraz;
                    oo.oturum=    oyp[0].üstoyun1.oturum;
                    oo.kayıt=     oyp[0].üstoyun1.kayıt;
                    oo.avatar=    oyp[0].üstoyun1.avatar;
                    oo.basarım=   oyp[0].üstoyun1.basarım;
                    bundle.putSerializable("oyun",oo);
                    Navigation.findNavController(ff).navigate(R.id.action_oyun_to_fragment_oyundetay,bundle);

                }
                else if(tıklı==2){
                    oo.kısaacık=oyp[0].üstoyun2.kısaacık;
                    oo.kısaacık=oyp[0].üstoyun2.uzunacık;
                    oo.android=   oyp[0].üstoyun2.android;
                    oo.resim2=    oyp[0].üstoyun2.resim2;
                    oo.resim=     oyp[0].üstoyun2.resim1;
                    oo.resim3=    oyp[0].üstoyun2.resim3;
                    oo.resim4=    oyp[0].üstoyun2.resim4;
                    oo.resim5=    oyp[0].üstoyun2.resim5;
                    oo.resim6=    oyp[0].üstoyun2.resim6;
                    oo.isim=      oyp[0].üstoyun2.isim;
                    oo.dosya=     oyp[0].üstoyun2.dosya;
                    oo.indirilimi=oyp[0].üstoyun2.indirilimi;
                    oo.Geliştiren=oyp[0].üstoyun2.Geliştiren;
                    oo.Yayımlayan=oyp[0].üstoyun2.Yayımlayan;
                    oo.boyut=     oyp[0].üstoyun2.boyut;
                    oo.tarih=     oyp[0].üstoyun2.tarih;
                    oo.tür=       oyp[0].üstoyun2.tür;
                    oo.pc=        oyp[0].üstoyun2.pc;
                    oo.çevrimdisi=oyp[0].üstoyun2.çevrimdisi;
                    oo.tekoyun=   oyp[0].üstoyun2.tekoyun;
                    oo.balnature= oyp[0].üstoyun2.balnature;
                    oo.cabraz=    oyp[0].üstoyun2.cabraz;
                    oo.oturum=    oyp[0].üstoyun2.oturum;
                    oo.kayıt=     oyp[0].üstoyun2.kayıt;
                    oo.avatar=    oyp[0].üstoyun2.avatar;
                    oo.basarım=   oyp[0].üstoyun2.basarım;
                    bundle.putSerializable("oyun",oo);
                    Navigation.findNavController(ff).navigate(R.id.action_oyun_to_fragment_oyundetay,bundle);
                }
                else if(tıklı==3){
                    oo.kısaacık=oyp[0].üstoyun3.kısaacık;
                    oo.kısaacık=oyp[0].üstoyun3.uzunacık;
                    oo.android=   oyp[0].üstoyun3.android;
                    oo.resim2=    oyp[0].üstoyun3.resim2;
                    oo.resim=     oyp[0].üstoyun3.resim1;
                    oo.resim3=    oyp[0].üstoyun3.resim3;
                    oo.resim4=    oyp[0].üstoyun3.resim4;
                    oo.resim5=    oyp[0].üstoyun3.resim5;
                    oo.resim6=    oyp[0].üstoyun3.resim6;
                    oo.isim=      oyp[0].üstoyun3.isim;
                    oo.dosya=     oyp[0].üstoyun3.dosya;
                    oo.indirilimi=oyp[0].üstoyun3.indirilimi;
                    oo.Geliştiren=oyp[0].üstoyun3.Geliştiren;
                    oo.Yayımlayan=oyp[0].üstoyun3.Yayımlayan;
                    oo.boyut=     oyp[0].üstoyun3.boyut;
                    oo.tarih=     oyp[0].üstoyun3.tarih;
                    oo.tür=       oyp[0].üstoyun3.tür;
                    oo.pc=        oyp[0].üstoyun3.pc;
                    oo.çevrimdisi=oyp[0].üstoyun3.çevrimdisi;
                    oo.tekoyun=   oyp[0].üstoyun3.tekoyun;
                    oo.balnature= oyp[0].üstoyun3.balnature;
                    oo.cabraz=    oyp[0].üstoyun3.cabraz;
                    oo.oturum=    oyp[0].üstoyun3.oturum;
                    oo.kayıt=     oyp[0].üstoyun3.kayıt;
                    oo.avatar=    oyp[0].üstoyun3.avatar;
                    oo.basarım=   oyp[0].üstoyun3.basarım;
                    bundle.putSerializable("oyun",oo);
                    Navigation.findNavController(ff).navigate(R.id.action_oyun_to_fragment_oyundetay,bundle);
                }
                else if(tıklı==4){

                   /* oo.kısaacık=oyp[0].üstoyun4.kısaacık;
                    oo.kısaacık=oyp[0].üstoyun4.uzunacık;
                    oo.android=   oyp[0].üstoyun4.android;
                    oo.resim2=    oyp[0].üstoyun4.resim2;
                    oo.resim=     oyp[0].üstoyun4.resim1;
                    oo.resim3=    oyp[0].üstoyun4.resim3;
                    oo.resim4=    oyp[0].üstoyun4.resim4;
                    oo.resim5=    oyp[0].üstoyun4.resim5;
                    oo.resim6=    oyp[0].üstoyun4.resim6;
                    oo.isim=      oyp[0].üstoyun4.isim;
                    oo.dosya=     oyp[0].üstoyun4.dosya;
                    oo.indirilimi=oyp[0].üstoyun4.indirilimi;
                    oo.Geliştiren=oyp[0].üstoyun4.Geliştiren;
                    oo.Yayımlayan=oyp[0].üstoyun4.Yayımlayan;
                    oo.boyut=     oyp[0].üstoyun4.boyut;
                    oo.tarih=     oyp[0].üstoyun4.tarih;
                    oo.tür=       oyp[0].üstoyun4.tür;
                    oo.pc=        oyp[0].üstoyun4.pc;
                    oo.çevrimdisi=oyp[0].üstoyun4.çevrimdisi;
                    oo.tekoyun=   oyp[0].üstoyun4.tekoyun;
                    oo.balnature= oyp[0].üstoyun4.balnature;
                    oo.cabraz=    oyp[0].üstoyun4.cabraz;
                    oo.oturum=    oyp[0].üstoyun4.oturum;
                    oo.kayıt=     oyp[0].üstoyun4.kayıt;
                    oo.avatar=    oyp[0].üstoyun4.avatar;
                    oo.basarım=   oyp[0].üstoyun4.basarım;*/
                    AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                    builder.setTitle("Uyarı");
                    builder.setMessage("Bu Oyun Henüz Kullanıma Sunulmamıştır.");

                    builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // "Tamam" düğmesine tıklandığında yapılacak işlemler
                        }
                    });



                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else if(tıklı==5){
                   /*  oo.kısaacık=oyp[0].üstoyun5.kısaacık;
                    oo.kısaacık=oyp[0].üstoyun5.uzunacık;
                    oo.android=   oyp[0].üstoyun5.android;
                    oo.resim2=    oyp[0].üstoyun5.resim2;
                    oo.resim=     oyp[0].üstoyun5.resim1;
                    oo.resim3=    oyp[0].üstoyun5.resim3;
                    oo.resim4=    oyp[0].üstoyun5.resim4;
                    oo.resim5=    oyp[0].üstoyun5.resim5;
                    oo.resim6=    oyp[0].üstoyun5.resim6;
                    oo.isim=      oyp[0].üstoyun5.isim;
                    oo.dosya=     oyp[0].üstoyun5.dosya;
                    oo.indirilimi=oyp[0].üstoyun5.indirilimi;
                    oo.Geliştiren=oyp[0].üstoyun5.Geliştiren;
                    oo.Yayımlayan=oyp[0].üstoyun5.Yayımlayan;
                    oo.boyut=     oyp[0].üstoyun5.boyut;
                    oo.tarih=     oyp[0].üstoyun5.tarih;
                    oo.tür=       oyp[0].üstoyun5.tür;
                    oo.pc=        oyp[0].üstoyun5.pc;
                    oo.çevrimdisi=oyp[0].üstoyun5.çevrimdisi;
                    oo.tekoyun=   oyp[0].üstoyun5.tekoyun;
                    oo.balnature= oyp[0].üstoyun5.balnature;
                    oo.cabraz=    oyp[0].üstoyun5.cabraz;
                    oo.oturum=    oyp[0].üstoyun5.oturum;
                    oo.kayıt=     oyp[0].üstoyun5.kayıt;
                    oo.avatar=    oyp[0].üstoyun5.avatar;
                    oo.basarım=   oyp[0].üstoyun5.basarım;*/ AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                    builder.setTitle("Uyarı");
                    builder.setMessage("Bu Oyun Henüz Kullanıma Sunulmamıştır.");

                    builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // "Tamam" düğmesine tıklandığında yapılacak işlemler
                        }
                    });
                }
                else if(tıklı==6){

               /*      oo.kısaacık=oyp[0].üstoyun6.kısaacık;
                    oo.kısaacık=oyp[0].üstoyun6.uzunacık;
                    oo.android=   oyp[0].üstoyun6.android;
                    oo.resim2=    oyp[0].üstoyun6.resim2;
                    oo.resim=     oyp[0].üstoyun6.resim1;
                    oo.resim3=    oyp[0].üstoyun6.resim3;
                    oo.resim4=    oyp[0].üstoyun6.resim4;
                    oo.resim5=    oyp[0].üstoyun6.resim5;
                    oo.resim6=    oyp[0].üstoyun6.resim6;
                    oo.isim=      oyp[0].üstoyun6.isim;
                    oo.dosya=     oyp[0].üstoyun6.dosya;
                    oo.indirilimi=oyp[0].üstoyun6.indirilimi;
                    oo.Geliştiren=oyp[0].üstoyun6.Geliştiren;
                    oo.Yayımlayan=oyp[0].üstoyun6.Yayımlayan;
                    oo.boyut=     oyp[0].üstoyun6.boyut;
                    oo.tarih=     oyp[0].üstoyun6.tarih;
                    oo.tür=       oyp[0].üstoyun6.tür;
                    oo.pc=        oyp[0].üstoyun6.pc;
                    oo.çevrimdisi=oyp[0].üstoyun6.çevrimdisi;
                    oo.tekoyun=   oyp[0].üstoyun6.tekoyun;
                    oo.balnature= oyp[0].üstoyun6.balnature;
                    oo.cabraz=    oyp[0].üstoyun6.cabraz;
                    oo.oturum=    oyp[0].üstoyun6.oturum;
                    oo.kayıt=     oyp[0].üstoyun6.kayıt;
                    oo.avatar=    oyp[0].üstoyun6.avatar;
                    oo.basarım=   oyp[0].üstoyun6.basarım;*/ AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                    builder.setTitle("Uyarı");
                    builder.setMessage("Bu Oyun Henüz Kullanıma Sunulmamıştır.");

                    builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // "Tamam" düğmesine tıklandığında yapılacak işlemler
                        }
                    });
                }
                //bundle.putSerializable("oyun",oo);
               // Navigation.findNavController(ff).navigate(R.id.action_oyun_to_fragment_oyundetay,bundle);

            }
        });
        return ff;
    }
}