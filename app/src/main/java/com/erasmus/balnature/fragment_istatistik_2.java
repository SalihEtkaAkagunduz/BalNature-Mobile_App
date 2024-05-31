package com.erasmus.balnature;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;


import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

// ...
public class fragment_istatistik_2 extends Fragment {
    private BarChart barChart;



    TextView txt,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
    // ...

    // ...

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View f = inflater.inflate(R.layout.fragment_istatistik_2, container, false);
        barChart = f.findViewById(R.id.chart1);
        DatabaseReference databaseRef, databaseRef2, databaseRef3, databaseRef4, databaseRef5, databaseRef6, databaseRef7;
        FirebaseAuth mAuth;
        txt=f.findViewById(R.id.textView105);
        txt2=f.findViewById(R.id.textView106);
        txt3=f.findViewById(R.id.textView110);
        txt4=f.findViewById(R.id.textView112);
        txt5=f.findViewById(R.id.textView11023);
        txt6=f.findViewById(R.id.textView1122);
        txt7=f.findViewById(R.id.textView11223);
        txt8=f.findViewById(R.id.textView11224);
        txt9=f.findViewById(R.id.textView11225);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseRef3 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("toplamortalama");
        databaseRef4 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("veriListesi");
        databaseRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Query lastTenItemsQuery = databaseRef4.limitToLast(10);
                databaseRef4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int toplamatık=0,metalatık=0,camatık=0,plastikatık=0,kagıatık=0;
                        ArrayList<BarEntry> group3 = new ArrayList<>();
                        ArrayList<BarEntry> group4 = new ArrayList<>();
                        ArrayList<veriaktarimi> verii=new ArrayList<>();
                        ArrayList<BarEntry> group2 = new ArrayList<>();
                        ArrayList<BarEntry> group5 = new ArrayList<>();
                        ArrayList<BarEntry> group1 = new ArrayList<>();
                        Log.e("a","oldu");

                        int sayi=0;
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            veriaktarimi value = snapshot.getValue(veriaktarimi.class);
                            verii.add(value);
                            toplamatık+=value.toplamatık;
                            camatık+=value.cama;
                            plastikatık+=value.plastika;
                            metalatık+=value.metala;
                            kagıatık+=value.kağıta;
                            group1.add(new BarEntry(0, (value.toplamatık-(value.camg+value.metalg+value.kağıtg+value.platikg))));
                            group2.add(new BarEntry(0,(value.metala-value.metalg)));
                            group3.add(new BarEntry(0,(value.cama-value.camg)));
                            group4.add(new BarEntry(0,(value.kağıta-value.kağıtg)));
                            group5.add(new BarEntry(0,(value.plastika-value.platikg)));
                            sayi+=1;
                        }

                        txt.setText(toplamatık+",000");
                        txt2.setText(String.valueOf(toplamatık+"(1000% +)"));
                        txt3.setText("+"+String.valueOf(toplamatık-(camatık+kagıatık+metalatık+plastikatık))+" kg");

                        txt4.setText(String.valueOf( toplamatık-(camatık+kagıatık+metalatık+plastikatık))+" kg");
                        txt5.setText("+"+String.valueOf((camatık+kagıatık+metalatık+plastikatık))+" kg");
                        txt6.setText(String.valueOf(metalatık)+" kg");
                        txt7.setText(String.valueOf(camatık)+" kg");
                        txt8.setText(String.valueOf(plastikatık)+" kg");
                        txt9.setText(String.valueOf(kagıatık)+" kg");














        BarDataSet barDataSet1 = new BarDataSet(group1, "Geri Dönüşmeyen Atık");
        barDataSet1.setColor(Color.rgb(104, 241, 175));
        BarDataSet barDataSet2 = new BarDataSet(group2, "Metal Atık");
        barDataSet2.setColor(Color.rgb(104, 0, 0));

        BarDataSet barDataSet3 = new BarDataSet(group3, "Cam Atık");
        barDataSet3.setColor(Color.rgb(144, 69, 0));
        BarDataSet barDataSet4 = new BarDataSet(group4, "Plastik Atık");
        barDataSet4.setColor(Color.rgb(62, 140, 255));
        BarDataSet barDataSet5 = new BarDataSet(group5, "Kağıt Atık");
        barDataSet5.setColor(Color.rgb(14, 110, 0));
        BarData barData = new BarData(barDataSet1, barDataSet2,barDataSet3, barDataSet4,barDataSet5);
        barChart.setData(barData);

        float groupSpace = 0.4f;
        float barSpace = 0.05f;
        float barWidth = 0.25f;

        barData.setBarWidth(barWidth);
        barChart.groupBars(0, groupSpace, barSpace);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"06.09.2023", "07.09.2023"}));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setCenterAxisLabels(true);
        xAxis.setAxisMinimum(-0.5f);
        xAxis.setAxisMaximum(barData.getGroupWidth(groupSpace, barSpace) * group1.size());

// Grafiği başlangıçta biraz büyütmek için aşağıdaki satırı ekleyin
        barChart.setVisibleXRangeMaximum(4); // Başlangıçta 4 çubuk görünecek şekilde ayarlandı

        barChart.setDrawValueAboveBar(false);
        barChart.getDescription().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setAxisMinimum(0);

        Legend legend = barChart.getLegend();
legend.setTextColor(Color.GRAY);
        legend.setFormSize(8f);
        legend.setFormToTextSpace(4f);
        barChart.setScrollBarSize(122); // İsteğe bağlı, kaydırma çubuğunun genişliğini ayarlayabilirsiniz
        barChart.setHorizontalScrollBarEnabled(true); // Yatay kaydırmayı etkinleştirir

        barChart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                barChart.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Veri alımı başarısız olursa buraya düşer
                        Log.e("hata", "ops");
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("hata", "ops");
            }
        });
        return f;
    }

// ...


// ...





}
