package com.erasmus.balnature;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

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

public class fragment_istatistik_1 extends Fragment {
    private LineChart lineChart;
    NavController navController;
    TextView txt,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
    int mod=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View f = inflater.inflate(R.layout.fragment_istatistik_1, container, false);
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
                        ArrayList<veriaktarimi> verii=new ArrayList<>();
                        ArrayList<Entry> entries1 = new ArrayList<>();
Log.e("a","oldu");
                        ArrayList<Entry> entries2 = new ArrayList<>();
                        int sayi=0;
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            veriaktarimi value = snapshot.getValue(veriaktarimi.class);
                            verii.add(value);
                            toplamatık+=value.toplamatık;
                            camatık+=value.cama;
                            plastikatık+=value.plastika;
                            metalatık+=value.metala;
                            kagıatık+=value.kağıta;
                            entries2.add(new Entry(sayi,value.toplamatık));
                            entries1.add(new Entry(sayi,(value.camg+value.kağıtg+value.metalg+value.platikg)));
sayi+=1;
                        }

txt.setText(toplamatık+",000");
                        txt2.setText(String.valueOf(toplamatık+"(1000% +)"));
                        txt3.setText("+"+String.valueOf(toplamatık-(camatık+kagıatık+metalatık+plastikatık))+" kg");
                        lineChart = f.findViewById(R.id.chart1);
                        txt4.setText(String.valueOf( toplamatık-(camatık+kagıatık+metalatık+plastikatık))+" kg");
                        txt5.setText("+"+String.valueOf((camatık+kagıatık+metalatık+plastikatık))+" kg");
                        txt6.setText(String.valueOf(metalatık)+" kg");
                        txt7.setText(String.valueOf(camatık)+" kg");
                        txt8.setText(String.valueOf(plastikatık)+" kg");
                        txt9.setText(String.valueOf(kagıatık)+" kg");
                        List<Integer> colors = new ArrayList<>();
                        colors.add(Color.rgb(104, 241, 175));

                        List<Integer> colors2 = new ArrayList<>();
                        colors2.add(Color.rgb(178, 34, 34));

                        LineDataSet lineDataSet1 = new LineDataSet(entries1, "Atık Miktarı");
                        lineDataSet1.setColors(colors);
                        lineDataSet1.setCircleColors(colors);
                        lineDataSet1.setLineWidth(2f);
                        lineDataSet1.setDrawFilled(true);
                        lineDataSet1.setFillDrawable(getGradientDrawable());
                        lineDataSet1.setValueTextColor(Color.WHITE);


                        LineDataSet lineDataSet2 = new LineDataSet(entries2, "Geri Dönüşüm Miktarı");
                        lineDataSet2.setColors(colors2);
                        lineDataSet2.setCircleColors(colors2);
                        lineDataSet2.setLineWidth(2f);
                        lineDataSet2.setDrawFilled(true);
                        lineDataSet2.setFillDrawable(getGradientDrawable2());
                        lineDataSet2.setValueTextColor(Color.WHITE);
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
                        legend.setTextColor(Color.GRAY);
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
        // ... (diğer işlemleri burada yapın)

        return f;
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
