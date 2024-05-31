package com.erasmus.balnature;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erasmus.balnature.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Locale;

public class fragment_istatistik_4 extends Fragment {
 ViewPager2 vipa;
 TabLayout tabLayout;
    ArrayList<Fragment> frglist =new ArrayList<>();
    ArrayList<String> rttt  =new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View f=inflater.inflate(R.layout.fragment_istatistik_4, container, false);
        // Inflate the layout for this fragment
      vipa=f.findViewById(R.id.vippppp);
      tabLayout=f.findViewById(R.id.tabte);

        frglist.add(new fragment_istatistik_4_1());
        frglist.add(new fragment_istatistik_4_2());
        frglist.add(new fragment_istatistik_4_3());
        frglist.add(new fragment_istatistik_4_4());
        frglist.add(new fragment_istatistik_4_5());
        frglist.add(new fragment_istatistik_4_6());
        frglist.add(new fragment_istatistik_4_7());
        frglist.add(new fragment_istatistik_4_8());
        frglist.add(new fragment_istatistik_4_9());
        frglist.add(new fragment_istatistik_4_10());

        adpp kk= new adpp(getActivity());
        vipa.setAdapter(kk);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
        if (selectedLanguage.equals("es")) {
            rttt.add("General");
            rttt.add("Reciclaje"); // Geri Dönüşüm
            rttt.add("Residuos"); // Atık
            rttt.add("Plástico"); // Plastik
            rttt.add("Metal"); // Metal
            rttt.add("Vidrio"); // Cam
            rttt.add("Papel"); // Kağıt
            rttt.add("Por Fecha"); // Tarihe Göre
            rttt.add("Más"); // En Fazla
            rttt.add("Estrella"); // Yıldız
        } else if (selectedLanguage.equals("en")) {
            rttt.add("General");
            rttt.add("Recycling");
            rttt.add("Waste");
            rttt.add("Plastic");
            rttt.add("Metal");
            rttt.add("Glass");
            rttt.add("Paper");
            rttt.add("By Date");
            rttt.add("Most");
            rttt.add("Star");
        } else if (selectedLanguage.equals("tr")) {
            rttt.add("Genel");
            rttt.add("Geri Dönüşüm");
            rttt.add("Atık");
            rttt.add("Plastik");
            rttt.add("Metal");
            rttt.add("Cam");
            rttt.add("Kağıt");
            rttt.add("Tarihe Göre");
            rttt.add("En Fazla");
            rttt.add("Yıldız");
        } else {
            Locale currentLocale = Locale.getDefault();
            String currentLanguageCode = currentLocale.getLanguage();

            if ("es".equals(currentLanguageCode)) {
                rttt.add("General");
                rttt.add("Reciclaje"); // Geri Dönüşüm
                rttt.add("Residuos"); // Atık
                rttt.add("Plástico"); // Plastik
                rttt.add("Metal"); // Metal
                rttt.add("Vidrio"); // Cam
                rttt.add("Papel"); // Kağıt
                rttt.add("Por Fecha"); // Tarihe Göre
                rttt.add("Más"); // En Fazla
                rttt.add("Estrella"); // Yıldız

            } else if ("en".equals(currentLanguageCode)) {
                rttt.add("General");
                rttt.add("Recycling");
                rttt.add("Waste");
                rttt.add("Plastic");
                rttt.add("Metal");
                rttt.add("Glass");
                rttt.add("Paper");
                rttt.add("By Date");
                rttt.add("Most");
                rttt.add("Star");

            } else if ("tr".equals(currentLanguageCode)) {
                rttt.add("Genel");
                rttt.add("Geri Dönüşüm");
                rttt.add("Atık");
                rttt.add("Plastik");
                rttt.add("Metal");
                rttt.add("Cam");
                rttt.add("Kağıt");
                rttt.add("Tarihe Göre");
                rttt.add("En Fazla");
                rttt.add("Yıldız");
            } else {
                rttt.add("Genel");
                rttt.add("Geri Dönüşüm");
                rttt.add("Atık");
                rttt.add("Plastik");
                rttt.add("Metal");
                rttt.add("Cam");
                rttt.add("Kağıt");
                rttt.add("Tarihe Göre");
                rttt.add("En Fazla");
                rttt.add("Yıldız");
            }
        }







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