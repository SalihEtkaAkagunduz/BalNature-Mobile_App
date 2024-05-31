package com.erasmus.balnature;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;


public class fragment_istatistik_4_1 extends Fragment {
    private BarChart barChart;


    int g=0;
    int b=0;
    TextView txt,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ff = inflater.inflate(R.layout.fragment_istatistik_4_1, container, false);
        PieChart pieChart = ff.findViewById(R.id.pieChart);
        PieChart pieChart2 = ff.findViewById(R.id.pieChart2);
        PieChart pieChart3 = ff.findViewById(R.id.pieChart3);
        ArrayList<PieEntry> entries = new ArrayList<>();
        Locale currentLocale = Locale.getDefault();
        String currentLanguageCode = currentLocale.getLanguage();
txt=ff.findViewById(R.id.textView11229);
        txt2=ff.findViewById(R.id.textView1122);
        txt3=ff.findViewById(R.id.textView118);
        txt4=ff.findViewById(R.id.textView119);
        DatabaseReference databaseRef, databaseRef2, databaseRef3, databaseRef4, databaseRef5, databaseRef6, databaseRef7;
        FirebaseAuth mAuth;
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
                        int toplamatık = 0, metalatık = 0, camatık = 0, plastikatık = 0, kagıatık = 0;

                        ArrayList<veriaktarimi> verii = new ArrayList<>();

                        Log.e("a", "oldu");

                        int sayi = 0;
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            veriaktarimi value = snapshot.getValue(veriaktarimi.class);
                            verii.add(value);
                            toplamatık += value.toplamatık;
                            camatık += value.cama;
                            plastikatık += value.plastika;
                            metalatık += value.metala;
                            kagıatık += value.kağıta;
                              g=(value.camg + value.metalg + value.kağıtg + value.platikg);
                              b=value.toplamatık-g;

                            sayi += 1;
                        }
                        txt2.setText(String.valueOf(g)+" kg");
                        txt.setText(String.valueOf(toplamatık-(camatık+kagıatık+plastikatık+metalatık))+" kg");
                        txt4.setText(String.valueOf(g)+" kg");
                        txt3.setText(String.valueOf(toplamatık-(camatık+kagıatık+plastikatık+metalatık))+" kg");
                        if ("es".equals(currentLanguageCode)) {
                            entries.add(new PieEntry(g, "Cantidad de Residuos"));
                            entries.add(new PieEntry(b, "Reciclaje"));

                        } else if ("en".equals(currentLanguageCode)) {
                            entries.add(new PieEntry(g, "Waste Quantity"));
                            entries.add(new PieEntry(b, "Recycling"));

                        } else if ("tr".equals(currentLanguageCode)) {
                            entries.add(new PieEntry(g, "Geri Dönüşüm"));
                            entries.add(new PieEntry(b, "Atık Miktarı"));
                        } else {
                            entries.add(new PieEntry(g, "Geri Dönüşüm"));
                            entries.add(new PieEntry(b, "Atık Miktarı"));
                        }
                        ArrayList<Integer> colors = new ArrayList<>();
                        colors.add(Color.rgb(154,205,50));   // Metal Atık dilimi rengi
                        colors.add(Color.rgb(219,85,85));

                        double yuzdeOrani = ((double) g / (toplamatık-(camatık+kagıatık+plastikatık+metalatık))) * 100;
                        int aaa=(int)Math.round(yuzdeOrani);
                        String aa=String.valueOf( Math.round(yuzdeOrani)); // Sonucu tam sayıya yuvarla
                        PieDataSet dataSet = new PieDataSet(entries, "");
                        dataSet.setColors(colors);
                        dataSet.setValueTextSize(0); // Yazı boyutunu ayarla
                        dataSet.setSliceSpace(2f);
                        dataSet.setSelectionShift(1f);
                        Description description = new Description();
                        description.setEnabled(false); // Açıklamayı devre dışı bırak

                        pieChart.setDescription(description);
                        PieData pieData = new PieData(dataSet);
                        pieChart.setData(pieData);
                        pieChart.setEntryLabelTextSize(7f);
                        pieChart.setCenterText(String.valueOf(toplamatık)+" kg");
                        pieChart.setCenterTextSize(18f); // Metin boyutunu ayarla
                        pieChart.setCenterTextColor(getResources().getColor(R.color.white)); // Metin rengini ayarla
                        int rgbColor = Color.rgb(22, 26, 31);
                        pieChart.setHoleColor(rgbColor);
                        pieChart.invalidate(); // Grafik güncelle

                        Legend legend = pieChart.getLegend();
                        legend.setForm(Legend.LegendForm.CIRCLE); // Açıklama sembolünü yuvarlak yap
                        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT); // Açıklamayı sola hizala
                        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM); // Açıklamayı alt kısmına hizala
                        legend.setTextColor(Color.GRAY); // Açıklama yazı rengini ayarla
                        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL); // Açıklamayı yatay olarak sırala
                        legend.setDrawInside(false); // Grafiğin içine çizme




                        ArrayList<Integer> colors2 = new ArrayList<>();
                        colors2.add(Color.rgb(105,105,105));   // Metal Atık dilimi rengi
                        colors2.add(Color.rgb(219,85,85));
                        PieDataSet dataSet2 = new PieDataSet(entries, "");
                        dataSet2.setColors(colors2);
                        dataSet2.setValueTextSize(0); // Yazı boyutunu ayarla
                        dataSet2.setSliceSpace(2f);
                        dataSet2.setSelectionShift(1f);
                        Description description2 = new Description();
                        description2.setEnabled(false); // Açıklamayı devre dışı bırak



                        pieChart2.setDescription(description2);
                        PieData pieData2 = new PieData(dataSet2);
                        pieChart2.setData(pieData2);
                        pieChart2.setEntryLabelTextSize(0f);
                        pieChart2.setCenterText("%"+(100-aaa));
                        pieChart2.setCenterTextSize(10f); // Metin boyutunu ayarla
                        pieChart2.setCenterTextColor(getResources().getColor(R.color.white)); // Metin rengini ayarla
                        int rgbColor2 = Color.rgb(22, 26, 31);
                        pieChart2.setHoleColor(rgbColor2);
                        pieChart2.invalidate(); // Grafik güncelle

                        Legend legend2 = pieChart2.getLegend();
                        legend2.setEnabled(false);
                        legend2.setForm(Legend.LegendForm.CIRCLE); // Açıklama sembolünü yuvarlak yap
                        legend2.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT); // Açıklamayı sola hizala
                        legend2.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM); // Açıklamayı alt kısmına hizala
                        legend2.setTextColor(Color.GRAY); // Açıklama yazı rengini ayarla
                        legend2.setOrientation(Legend.LegendOrientation.HORIZONTAL); // Açıklamayı yatay olarak sırala
                        legend2.setDrawInside(false); // Grafiğin içine çizme
                        legend2.setEnabled(false);




                        ArrayList<Integer> colors3 = new ArrayList<>();
                        colors3.add(Color.rgb(154,205,50));   // Metal Atık dilimi rengi
                        colors3.add(Color.rgb(105,105,105));
                        PieDataSet dataSet3 = new PieDataSet(entries, "");
                        dataSet3.setColors(colors3);
                        dataSet3.setValueTextSize(0); // Yazı boyutunu ayarla
                        dataSet3.setSliceSpace(2f);
                        dataSet3.setSelectionShift(1f);
                        Description description3 = new Description();
                        description3.setEnabled(false); // Açıklamayı devre dışı bırak

                        pieChart3.setDescription(description3);
                        PieData pieData3 = new PieData(dataSet3);
                        pieChart3.setData(pieData3);
                        pieChart3.setEntryLabelTextSize(0f);
                        pieChart3.setCenterText("%"+aa);
                        pieChart3.setCenterTextSize(10f); // Metin boyutunu ayarla
                        pieChart3.setCenterTextColor(getResources().getColor(R.color.white)); // Metin rengini ayarla
                        int rgbColor3 = Color.rgb(22, 26, 31);
                        pieChart3.setHoleColor(rgbColor3);
                        pieChart3.invalidate(); // Grafik güncelle

                        Legend legend3 = pieChart3.getLegend();
                        legend3.setEnabled(false);
                        legend3.setForm(Legend.LegendForm.CIRCLE); // Açıklama sembolünü yuvarlak yap
                        legend3.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT); // Açıklamayı sola hizala
                        legend3.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM); // Açıklamayı alt kısmına hizala
                        legend3.setTextColor(Color.GRAY); // Açıklama yazı rengini ayarla
                        legend3.setOrientation(Legend.LegendOrientation.HORIZONTAL); // Açıklamayı yatay olarak sırala
                        legend3.setDrawInside(false); // Grafiğin içine çizme
                        legend3.setEnabled(false);

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
}
