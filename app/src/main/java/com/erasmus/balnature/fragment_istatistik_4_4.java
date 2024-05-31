package com.erasmus.balnature;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.Entry;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.Entry;
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
import java.util.ArrayList;
import java.util.List;

public class fragment_istatistik_4_4 extends Fragment {
    private LineChart lineChart;
    int g=0;
    int b=0;
    TextView txt,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ff = inflater.inflate(R.layout.fragment_istatistik_4_4, container, false);
        lineChart = ff.findViewById(R.id.pieChart);
        ArrayList<Entry> entries2 = new ArrayList<>();
        DatabaseReference databaseRef, databaseRef2, databaseRef3, databaseRef4, databaseRef5, databaseRef6, databaseRef7;
        FirebaseAuth mAuth;
        txt=ff.findViewById(R.id.textView11229);
        txt2=ff.findViewById(R.id.textView1122);
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
                        int toplamatık = 0, metalatık = 0, camatık = 0, plastikatık = 0, kagıatık = 0,metalatıkg = 0, camatıkg = 0, plastikatıkg = 0, kagıatıkg = 0, metalatık2 = 0, camatık2 = 0, plastikatık2 = 0, kagıatık2 = 0,metalatıkg2 = 0, camatıkg2 = 0, plastikatıkg2 = 0, kagıatıkg2 = 0;
                        List<Integer> colors = new ArrayList<>();
                        List<Integer> colors2 = new ArrayList<>();
                        colors.add(Color.rgb(104, 241, 175));


                        colors2.add(Color.rgb(178, 34, 34));
                        ArrayList<veriaktarimi> verii = new ArrayList<>();

                        Log.e("a", "oldu");
                        ArrayList<Entry> entries1 = new ArrayList<>();
                        int sayi = 0;
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            veriaktarimi value = snapshot.getValue(veriaktarimi.class);
                            verii.add(value);
                            toplamatık = value.toplamatık;
                            camatık = value.cama;
                            plastikatık = value.plastika;
                            metalatık = value.metala;
                            kagıatık = value.kağıta;
                            camatık2 += value.cama;
                            plastikatık2 += value.plastika;
                            metalatık2 += value.metala;
                            kagıatık2 += value.kağıta;
                            camatıkg2 += value.camg;
                            plastikatıkg2 += value.platikg;
                            metalatıkg2 += value.metalg;
                            kagıatıkg2 += value.kağıtg;
                            camatıkg2 += value.camg;
                            plastikatıkg = value.platikg;
                            metalatıkg = value.metalg;
                            kagıatıkg = value.kağıtg;
                            g=(value.camg + value.metalg + value.kağıtg + value.platikg);
                            b=value.toplamatık-g;
                            entries1.add(new Entry(sayi, plastikatıkg));
                            entries2.add(new Entry(sayi, plastikatık));
                            sayi += 1;
                        }
                        txt.setText(String.valueOf(plastikatık2+" kg"));
                        txt2.setText(String.valueOf(plastikatıkg2+" kg"));
                        LineDataSet lineDataSet1 = new LineDataSet(entries1, "Group 1");
                        lineDataSet1.setColors(colors);
                        lineDataSet1.setCircleColors(colors);
                        lineDataSet1.setLineWidth(2f);
                        lineDataSet1.setDrawFilled(true);
                        lineDataSet1.setFillDrawable(getGradientDrawable());

                        LineDataSet lineDataSet2 = new LineDataSet(entries2, "Group 2");
                        lineDataSet2.setColors(colors2);
                        lineDataSet2.setCircleColors(colors2);
                        lineDataSet2.setLineWidth(2f);
                        lineDataSet2.setDrawFilled(true);
                        lineDataSet2.setFillDrawable(getGradientDrawable2());

                        LineData lineData = new LineData(lineDataSet1, lineDataSet2);
                        lineChart.setData(lineData);

                        XAxis xAxis = lineChart.getXAxis();
                        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                        xAxis.setGranularity(1);
                        xAxis.setCenterAxisLabels(true);
                        xAxis.setAxisMinimum(0);

                        lineChart.getDescription().setEnabled(false);
                        lineChart.getAxisRight().setEnabled(false);

                        YAxis leftAxis = lineChart.getAxisLeft();
                        leftAxis.setAxisMinimum(0);

                        Legend legend = lineChart.getLegend();
                        legend.setFormSize(8f);
                        legend.setFormToTextSpace(4f);

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

        return ff;
    }
    private Drawable getGradientDrawable() {
        int[] colors = {Color.rgb(104, 241, 175), Color.TRANSPARENT};
        return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
    }
    private Drawable getGradientDrawable2() {
        int[] colors = {Color.rgb(255, 128, 114), Color.TRANSPARENT};
        return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
    }
}



