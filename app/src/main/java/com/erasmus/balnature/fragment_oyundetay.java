package com.erasmus.balnature;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class fragment_oyundetay extends Fragment {


    ViewPager2 vipa;
    TabLayout tabLayout;
    ArrayList<Fragment> frglist =new ArrayList<>();
    ArrayList<String> rttt  =new ArrayList<>();
    ImageView img,img1,img2,img3,img4,img5,img6,img7;
    ConstraintLayout cs;
    TextView txtt,txtt2;
Button btn,btn2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View f=inflater.inflate(R.layout.fragment_oyundetay, container, false);
        vipa=f.findViewById(R.id.vippppp);
        tabLayout=f.findViewById(R.id.tabte);
        img=f.findViewById(R.id.imageView96);
btn=f.findViewById(R.id.button22);
        btn2=f.findViewById(R.id.button23);
        img1=f.findViewById(R.id.imageView85);
        img2=f.findViewById(R.id.imageView86);
        img3=f.findViewById(R.id.imageView87);
        img4=f.findViewById(R.id.imageView88);
        img5=f.findViewById(R.id.imageView89);
        img6=f.findViewById(R.id.imageView90);
        txtt=f.findViewById(R.id.textView162);txtt2=f.findViewById(R.id.textView161);
        img7=f.findViewById(R.id.imageView91);
        Bundle receivedBundle = getArguments();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(f.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Demo kullanıcıları oyunları indiremez ama Play Store üzerinden oynayabilirsiniz.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });
               AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Bu özellik devre dışı",Snackbar.LENGTH_SHORT).show();
            }
        });
            // Bundle içindeki veriyi almak
            oyungoster data =(oyungoster) receivedBundle.getSerializable("oyun"); // "key" yerine kendi bundle anahtarınızı kullanmalısınız
            // Veriyi kullanmak
txtt.setText(data.kısaacık);
txtt2.setText(data.isim);
                Picasso.get()
                        .load(data.resim)
                        .into(img1);
                Picasso.get()
                        .load(data.resim6)
                        .into(img7);
                Picasso.get()
                        .load(data.resim2)
                        .into(img3);
                Picasso.get()
                        .load(data.resim3)
                        .into(img4);
                Picasso.get()
                        .load(data.resim4)
                        .into(img5);
                Picasso.get()
                        .load(data.resim5)
                        .into(img6);
                Picasso.get()
                        .load(data.resim)
                        .into(img2);


        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setImageDrawable(img2.getDrawable());
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setImageDrawable(img3.getDrawable());
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setImageDrawable(img4.getDrawable());
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setImageDrawable(img5.getDrawable()); ;
            }
        });img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setImageDrawable(img6.getDrawable());
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setImageDrawable(img7.getDrawable());
            }
        });
        cs=f.findViewById(R.id.imghh);
        frglist.add(new fragment_oyundetay_1());
        frglist.add(new fragment_oyundetay_2());
        rttt.add("Ayrıntılar");
        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(f).navigate(R.id.action_fragment_oyundetay_to_oyun);
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(f).navigate(R.id.action_fragment_oyundetay_to_oyun);
            }
        });
        rttt.add("Daha Fazla");
        fragment_oyundetay.adpp kk= new fragment_oyundetay.adpp(getActivity());
        vipa.setAdapter(kk);
        new TabLayoutMediator(tabLayout,vipa ,((tab, position) ->tab.setText(rttt.get(position)) )).attach();

        return f;
    }
    class adpp extends FragmentStateAdapter {
        private FragmentActivity mActivity;

        public adpp(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            mActivity = fragmentActivity;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // mActivity nesnesini kullanarak fragment oluşturun
            return frglist.get(position);
        }

        @Override
        public int getItemCount() {
            return frglist.size();
        }
    }}