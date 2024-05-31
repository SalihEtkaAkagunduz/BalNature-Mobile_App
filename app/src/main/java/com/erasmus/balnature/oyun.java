package com.erasmus.balnature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.erasmus.balnature.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class oyun extends Fragment {



    ArrayList<Fragment> frglist = new ArrayList<>();
    ArrayList<String> rttt = new ArrayList<>();
    TabLayout tabLayout;
    ViewPager2 viewPager;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frglist.clear();
        rttt.clear();
        frglist.add(new fragment_oyun_1());
        frglist.add(new fragment_oyun_2());
        frglist.add(new fragment_oyun_3());
        view = inflater.inflate(R.layout.fragment_oyun, container, false);
        adpp kk = new adpp(this.getActivity());
        viewPager = view.findViewById(R.id.vipa);
        viewPager.setAdapter(kk);
        viewPager.setUserInputEnabled(false);
        rttt.add("");
        rttt.add("");
        rttt.add("");
        tabLayout = view.findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(rttt.get(position))).attach();
        tabLayout.getTabAt(1).setIcon(R.drawable.outline_download_for_offline_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.baseline_code_24);
        Drawable iconn= ContextCompat.getDrawable(requireContext(), R.drawable.baseline_videogame_asset_24);
        int renkk=R.color.tablayouttiklandi;
        int tabIconColor = ContextCompat.getColor(view.getContext(), renkk);
        iconn.setColorFilter(tabIconColor,PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(0).setIcon(iconn);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateTabIcon(tab, true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateTabIcon(tab, false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

    private void updateTabIcon(TabLayout.Tab tab, boolean selected) {
        Drawable icon;
        int renk;
        if (selected) {
            switch (tab.getPosition()) {
                case 0:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.baseline_videogame_asset_24);
                    renk = R.color.tablayouttiklandi;
                    break;
                case 1:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.baseline_download_for_offline_24);
                    renk = R.color.tablayouttiklandi;
                    break;
                case 2:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.baseline_code_24);
                    renk = R.color.tablayouttiklandi;
                    break;
                default:
                    icon = null;
                    renk = R.color.white;
                    break;
            }
        } else {
            switch (tab.getPosition()) {
                case 0:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.outline_videogame_asset_24);
                    renk = R.color.white;
                    break;
                case 1:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.outline_download_for_offline_24);
                    renk = R.color.white;
                    break;
                case 2:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.baseline_code_24);
                    renk = R.color.white;
                    break;
                default:
                    icon = null;
                    renk = R.color.white;
                    break;
            }
        }
        int tabIconColor = ContextCompat.getColor(view.getContext(), renk);
        icon.setColorFilter(tabIconColor,PorterDuff.Mode.SRC_IN);
        tab.setIcon(icon);
    }

    class adpp extends FragmentStateAdapter {
        public adpp(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return frglist.get(position);
        }

        @Override
        public int getItemCount() {
            return frglist.size();
        }
    }


}