package com.erasmus.balnature;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;


public class fragment_oyun_2 extends Fragment {
    ViewPager2 vipa;
    TabLayout tabLayout;
    ArrayList<Fragment> frglist =new ArrayList<>();
    ArrayList<String> rttt  =new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View f=inflater.inflate(R.layout.fragment_oyun_2, container, false);
        vipa=f.findViewById(R.id.vippppp);
        tabLayout=f.findViewById(R.id.tabte);
        frglist.add(new fragment_oyun_2_1());
        frglist.add(new fragment_oyun_2_2());
        rttt.add("İndirilenler");
        rttt.add("Favoriler");
        adpp kk= new adpp(getActivity());
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