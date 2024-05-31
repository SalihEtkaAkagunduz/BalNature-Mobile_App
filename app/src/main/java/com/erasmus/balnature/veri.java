package com.erasmus.balnature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class veri extends Fragment {
    ArrayList<Fragment> frglist = new ArrayList<>();
    ArrayList<String> rttt = new ArrayList<>();
    TabLayout tabLayout;
    ViewPager2 viewPager;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_veri2, container, false);
        frglist.clear();
        rttt.clear();

        tabLayout = view.findViewById(R.id.tabLayoutveri);


        frglist.add(new fragment_veri_menu());
        frglist.add(new fragment_veri_goruntule());
        frglist.add(new fragment_veri_ekle());
        frglist.add(new fragment_veri_duzenle());
        frglist.add(new fragment_veri_cikar());


        rttt.add("");
        rttt.add("");
        rttt.add("");
        rttt.add("");
        rttt.add("");


        veri.adpp kk = new veri.adpp(this.getActivity());
        viewPager = view.findViewById(R.id.vipaveri);
        viewPager.setAdapter(kk);



        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(rttt.get(position))).attach();
        Drawable iconn= ContextCompat.getDrawable(requireContext(), R.drawable.homeboyali);
        int renkk=R.color.tablayouttiklandi;
        int tabIconColor = ContextCompat.getColor(view.getContext(), renkk);
        iconn.setColorFilter(tabIconColor,PorterDuff.Mode.SRC_IN);

        tabLayout.getTabAt(0).setIcon(iconn);
        tabLayout.getTabAt(1).setIcon(R.drawable.fragment_veri_goruntule_bos);
        tabLayout.getTabAt(2).setIcon(R.drawable.fragment_veri_ekle_bos);
        tabLayout.getTabAt(3).setIcon(R.drawable.fragment_veri_duzenle_bos);
        tabLayout.getTabAt(4).setIcon(R.drawable.fragment_veri_sil_bos);




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
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.homeboyali);
                    renk = R.color.tablayouttiklandi;
                    break;
                case 1:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.fragment_veri_goruntule_dolu);
                    renk = R.color.tablayouttiklandi;
                    break;
                case 2:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.fragment_veri_ekle_dolu);
                    renk = R.color.tablayouttiklandi;
                    break;
                case 3:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.fragment_veri_duzenle_dolu);
                    renk = R.color.tablayouttiklandi;
                    break;
                case 4:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.fragment_veri_sil_dolu);
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
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.homebos);
                    renk = R.color.white;
                    break;
                case 1:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.fragment_veri_goruntule_bos);
                    renk = R.color.white;
                    break;
                case 2:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.fragment_veri_ekle_bos);
                    renk = R.color.white;
                    break;
                case 3:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.fragment_veri_duzenle_bos);
                    renk = R.color.white;
                    break;
                case 4:
                    icon = ContextCompat.getDrawable(requireContext(), R.drawable.fragment_veri_sil_bos);
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