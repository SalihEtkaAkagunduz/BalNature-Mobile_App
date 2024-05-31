package com.erasmus.balnature;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
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


public class fragment_istatistik_4_3 extends Fragment {
    private BarChart barChart;


    int g=0;
    int b=0;
    TextView txt,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ff = inflater.inflate(R.layout.fragment_istatistik_4_3, container, false);


        txt=ff.findViewById(R.id.textView11229);
        txt2=ff.findViewById(R.id.textView1122yy);
        txt3=ff.findViewById(R.id.textView1122pp);
        txt4=ff.findViewById(R.id.textView1122tt);
        txt5=ff.findViewById(R.id.textView1122);
        txt6=ff.findViewById(R.id.textView118);
        txt7=ff.findViewById(R.id.textView119);
        txt8=ff.findViewById(R.id.textView118e);
        txt9=ff.findViewById(R.id.textView119x);
        txt10=ff.findViewById(R.id.textView118em);
        PieChart pieChart = ff.findViewById(R.id.pieChart);
        PieChart pieChart2 = ff.findViewById(R.id.pieChart2);
        PieChart pieChart3 = ff.findViewById(R.id.pieChart3);
        PieChart pieChart4 = ff.findViewById(R.id.pieChart4);
        PieChart pieChart5 = ff.findViewById(R.id.pieChart5);
        PieChart pieChart6 = ff.findViewById(R.id.pieChart6);
        ArrayList<PieEntry> entries = new ArrayList<>();

        DatabaseReference databaseRef, databaseRef2, databaseRef3, databaseRef4, databaseRef5, databaseRef6, databaseRef7;
        FirebaseAuth mAuth;
        ArrayList<Integer> colors = new ArrayList<>();
        ArrayList<Integer> colors2 = new ArrayList<>(); ArrayList<Integer> colors4 = new ArrayList<>();ArrayList<Integer> colors5 = new ArrayList<>(); ArrayList<Integer> colors3 = new ArrayList<>();
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

                        int toplamatık = 0, metalatık = 0, camatık = 0, plastikatık = 0, kagıatık = 0, metalatıkg = 0, camatıkg = 0, plastikatıkg = 0, kagıatıkg = 0;

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
                            camatıkg += value.camg;
                            plastikatıkg += value.platikg;
                            metalatıkg += value.metalg;
                            kagıatıkg += value.kağıtg;
                            g=(value.camg + value.metalg + value.kağıtg + value.platikg);
                            b=value.toplamatık-g;

                            sayi += 1;
                        }
                        txt2.setText(String.valueOf(camatık-camatıkg)+" kg");
                        txt.setText(String.valueOf(metalatık-metalatıkg)+" kg");
                        txt4.setText(String.valueOf(plastikatık-plastikatıkg)+" kg");
                        txt3.setText(String.valueOf(kagıatık-kagıatıkg)+" kg");
                        txt5.setText(String.valueOf(b)+" kg");
                        txt7.setText(String.valueOf(camatık-camatıkg)+" kg");
                        txt6.setText(String.valueOf(metalatık-metalatıkg)+" kg");
                        txt9.setText(String.valueOf(plastikatık-plastikatıkg)+" kg");
                        txt8.setText(String.valueOf(kagıatık-kagıatıkg)+" kg");
                        txt10.setText(String.valueOf(b)+" kg");
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                        String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                        if (selectedLanguage.equals("es")) {

                            entries.add(new PieEntry(metalatık-metalatıkg, "Residuos de Metal"));
                            entries.add(new PieEntry(camatık-camatıkg, "Residuos de Vidrio"));
                            entries.add(new PieEntry(kagıatık-kagıatıkg, "Residuos de Papel"));
                            entries.add(new PieEntry(plastikatık-plastikatıkg, "Residuos de Plástico"));
                            entries.add(new PieEntry(b, "Residuos Domésticos"));

                        } else if (selectedLanguage.equals("en")) {

                            entries.add(new PieEntry(metalatık-metalatıkg, "Metal Waste"));
                            entries.add(new PieEntry(camatık-camatıkg, "Glass Waste"));
                            entries.add(new PieEntry(kagıatık-kagıatıkg, "Paper Waste"));
                            entries.add(new PieEntry(plastikatık-plastikatıkg, "Plastic Waste"));
                            entries.add(new PieEntry(b, "Household Waste"));

                        } else if (selectedLanguage.equals("tr")) {

                            entries.add(new PieEntry(metalatık-metalatıkg, "Metal Atık"));
                            entries.add(new PieEntry(camatık-camatıkg, "Cam Atık"));
                            entries.add(new PieEntry(kagıatık-kagıatıkg, "Kağıt Atık"));
                            entries.add(new PieEntry(plastikatık-plastikatıkg, "Plastik Atık"));
                            entries.add(new PieEntry(b, "Evsel Atık"));

                        } else {
                            Locale currentLocale = Locale.getDefault();
                            String currentLanguageCode = currentLocale.getLanguage();

                            if ("es".equals(currentLanguageCode)) {
                                entries.add(new PieEntry(metalatık-metalatıkg, "Residuos de Metal"));
                                entries.add(new PieEntry(camatık-camatıkg, "Residuos de Vidrio"));
                                entries.add(new PieEntry(kagıatık-kagıatıkg, "Residuos de Papel"));
                                entries.add(new PieEntry(plastikatık-plastikatıkg, "Residuos de Plástico"));
                                entries.add(new PieEntry(b, "Residuos Domésticos"));

                            } else if ("en".equals(currentLanguageCode)) {
                                entries.add(new PieEntry(metalatık-metalatıkg, "Metal Waste"));
                                entries.add(new PieEntry(camatık-camatıkg, "Glass Waste"));
                                entries.add(new PieEntry(kagıatık-kagıatıkg, "Paper Waste"));
                                entries.add(new PieEntry(plastikatık-plastikatıkg, "Plastic Waste"));
                                entries.add(new PieEntry(b, "Household Waste"));

                            } else if ("tr".equals(currentLanguageCode)) {
                                entries.add(new PieEntry(metalatık-metalatıkg, "Metal Atık"));
                                entries.add(new PieEntry(camatık-camatıkg, "Cam Atık"));
                                entries.add(new PieEntry(kagıatık-kagıatıkg, "Kağıt Atık"));
                                entries.add(new PieEntry(plastikatık-plastikatıkg, "Plastik Atık"));
                                entries.add(new PieEntry(b, "Evsel Atık"));
                            } else {
                                entries.add(new PieEntry(metalatık-metalatıkg, "Metal Atık"));
                                entries.add(new PieEntry(camatık-camatıkg, "Cam Atık"));
                                entries.add(new PieEntry(kagıatık-kagıatıkg, "Kağıt Atık"));
                                entries.add(new PieEntry(plastikatık-plastikatıkg, "Plastik Atık"));
                                entries.add(new PieEntry(b, "Evsel Atık"));
                            }
                        }
                        ArrayList<Integer> colors = new ArrayList<>();
                        colors.add(Color.rgb(104, 0, 0));   // Metal Atık dilimi rengi
                        colors.add(Color.rgb(144, 69, 0));
                        colors.add(Color.rgb(62, 140, 255));   // Metal Atık dilimi rengi
                        colors.add(Color.rgb(14, 110, 0));
                        colors.add(Color.rgb(56, 58, 31));   // Metal Atık dilimi rengi
                        ArrayList<Integer> colors2 = new ArrayList<>();
                        colors2.add(Color.rgb(104, 0, 0));   // Metal Atık dilimi rengi
                        colors2.add(Color.rgb(105,105,105));
                        colors2.add(Color.rgb(105,105,105));   // Metal Atık dilimi rengi
                        colors2.add(Color.rgb(105,105,105));
                        colors2.add(Color.rgb(105,105,105));
                        ArrayList<Integer> colors3 = new ArrayList<>();
                        colors3.add(Color.rgb(105,105,105));   // Metal Atık dilimi rengi
                        colors3.add(Color.rgb(144, 69, 0));
                        colors3.add(Color.rgb(105,105,105));   // Metal Atık dilimi rengi
                        colors3.add(Color.rgb(105,105,105));
                        colors3.add(Color.rgb(105,105,105));
                        ArrayList<Integer> colors4 = new ArrayList<>();
                        colors4.add(Color.rgb(105,105,105));   // Metal Atık dilimi rengi
                        colors4.add(Color.rgb(105,105,105));
                        colors4.add(Color.rgb(62, 140, 255));   // Metal Atık dilimi rengi
                        colors4.add(Color.rgb(105,105,105));
                        colors4.add(Color.rgb(105,105,105));
                        ArrayList<Integer> colors5 = new ArrayList<>();
                        colors5.add(Color.rgb(105,105,105));   // Metal Atık dilimi rengi
                        colors5.add(Color.rgb(105,105,105));
                        colors5.add(Color.rgb(105,105,105));   // Metal Atık dilimi rengi
                        colors5.add(Color.rgb(14, 110, 0));
                        colors5.add(Color.rgb(105,105,105));
                        ArrayList<Integer> colors6 = new ArrayList<>();
                        colors6.add(Color.rgb(105,105,105));   // Metal Atık dilimi rengi
                        colors6.add(Color.rgb(105,105,105));
                        colors6.add(Color.rgb(105,105,105));   // Metal Atık dilimi rengi
                        colors6.add(Color.rgb(105,105,105));
                        colors6.add(Color.rgb(56, 58, 31));


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
                        pieChart.setCenterText(toplamatık+" kg");
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
                        pieChart2.setCenterText("%67");
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
                        pieChart3.setCenterText("%33");
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




                        PieDataSet dataSet4 = new PieDataSet(entries, "");
                        dataSet4.setColors(colors4);
                        dataSet4.setValueTextSize(0); // Yazı boyutunu ayarla
                        dataSet4.setSliceSpace(2f);
                        dataSet4.setSelectionShift(1f);
                        Description description4 = new Description();
                        description4.setEnabled(false); // Açıklamayı devre dışı bırak

                        pieChart4.setDescription(description4);
                        PieData pieData4 = new PieData(dataSet4);
                        pieChart4.setData(pieData4);
                        pieChart4.setEntryLabelTextSize(0f);
                        pieChart4.setCenterText("%33");
                        pieChart4.setCenterTextSize(10f); // Metin boyutunu ayarla
                        pieChart4.setCenterTextColor(getResources().getColor(R.color.white)); // Metin rengini ayarla
                        int rgbColor4= Color.rgb(22, 26, 31);
                        pieChart4.setHoleColor(rgbColor4);
                        pieChart4.invalidate(); // Grafik güncelle

                        Legend legend4 = pieChart4.getLegend();
                        legend4.setEnabled(false);
                        legend4.setForm(Legend.LegendForm.CIRCLE); // Açıklama sembolünü yuvarlak yap
                        legend4.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT); // Açıklamayı sola hizala
                        legend4.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM); // Açıklamayı alt kısmına hizala
                        legend4.setTextColor(Color.GRAY); // Açıklama yazı rengini ayarla
                        legend4.setOrientation(Legend.LegendOrientation.HORIZONTAL); // Açıklamayı yatay olarak sırala
                        legend4.setDrawInside(false); // Grafiğin içine çizme
                        legend4.setEnabled(false);









                        PieDataSet dataSet5 = new PieDataSet(entries, "");
                        dataSet5.setColors(colors5);
                        dataSet5.setValueTextSize(0); // Yazı boyutunu ayarla
                        dataSet5.setSliceSpace(2f);
                        dataSet5.setSelectionShift(1f);
                        Description description5 = new Description();
                        description5.setEnabled(false); // Açıklamayı devre dışı bırak

                        pieChart5.setDescription(description5);
                        PieData pieData5 = new PieData(dataSet5);
                        pieChart5.setData(pieData5);
                        pieChart5.setEntryLabelTextSize(0f);
                        pieChart5.setCenterText("%33");
                        pieChart5.setCenterTextSize(10f); // Metin boyutunu ayarla
                        pieChart5.setCenterTextColor(getResources().getColor(R.color.white)); // Metin rengini ayarla
                        int rgbColor5 = Color.rgb(22, 26, 31);
                        pieChart5.setHoleColor(rgbColor5);
                        pieChart5.invalidate(); // Grafik güncelle

                        Legend legend5 = pieChart5.getLegend();
                        legend5.setEnabled(false);
                        legend5.setForm(Legend.LegendForm.CIRCLE); // Açıklama sembolünü yuvarlak yap
                        legend5.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT); // Açıklamayı sola hizala
                        legend5.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM); // Açıklamayı alt kısmına hizala
                        legend5.setTextColor(Color.GRAY); // Açıklama yazı rengini ayarla
                        legend5.setOrientation(Legend.LegendOrientation.HORIZONTAL); // Açıklamayı yatay olarak sırala
                        legend5.setDrawInside(false); // Grafiğin içine çizme
                        legend5.setEnabled(false);








                        PieDataSet dataSet6 = new PieDataSet(entries, "");
                        dataSet6.setColors(colors6);
                        dataSet6.setValueTextSize(0); // Yazı boyutunu ayarla
                        dataSet6.setSliceSpace(2f);
                        dataSet6.setSelectionShift(1f);
                        Description description6 = new Description();
                        description6.setEnabled(false); // Açıklamayı devre dışı bırak

                        pieChart6.setDescription(description6);
                        PieData pieData6 = new PieData(dataSet6);
                        pieChart6.setData(pieData6);
                        pieChart6.setEntryLabelTextSize(0f);
                        pieChart6.setCenterText("%33");
                        pieChart6.setCenterTextSize(10f); // Metin boyutunu ayarla
                        pieChart6.setCenterTextColor(getResources().getColor(R.color.white)); // Metin rengini ayarla
                        int rgbColor6 = Color.rgb(22, 26, 31);
                        pieChart6.setHoleColor(rgbColor6);
                        pieChart6.invalidate(); // Grafik güncelle

                        Legend legend6 = pieChart6.getLegend();
                        legend6.setEnabled(false);
                        legend6.setForm(Legend.LegendForm.CIRCLE); // Açıklama sembolünü yuvarlak yap
                        legend6.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT); // Açıklamayı sola hizala
                        legend6.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM); // Açıklamayı alt kısmına hizala
                        legend6.setTextColor(Color.GRAY); // Açıklama yazı rengini ayarla
                        legend6.setOrientation(Legend.LegendOrientation.HORIZONTAL); // Açıklamayı yatay olarak sırala
                        legend6.setDrawInside(false); // Grafiğin içine çizme
                        legend6.setEnabled(false);









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





















