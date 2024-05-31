package com.erasmus.balnature;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

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


public class bildirim extends Fragment {


    Button btn;
    RecyclerView rv;
    List<bild> data;
    adapter adptr;
    Integer ortalama;
    NavController navController;
    ProgressBar pss;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_bildirim, container, false);
        NavController navController = NavHostFragment.findNavController(this);
        ImageView img=v.findViewById(R.id.imageView79);
        rv = v.findViewById(R.id.rex);
       pss = v.findViewById(R.id.progressBar24);
        TextView txt=v.findViewById(R.id.textView148);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navController.navigate(R.id.anamenu);
            }
        });
         txt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 navController.navigate(R.id.anamenu);
             }
         });
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Burada Firebase verilerini çekme ve RecyclerView'i kurma işlemlerini yapın
        DatabaseReference databaseRef, databaseRef2, databaseRef3, databaseRef4, databaseRef5, databaseRef6, databaseRef7;
        FirebaseAuth mAuth;
        navController = Navigation.findNavController(view);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();


        databaseRef4 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("bildirim");
        Query query = databaseRef4.limitToLast(20);
                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Verileri işlemek için bir List oluşturun
                        data = new ArrayList<>();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            bild value = snapshot.getValue(bild.class);
                            data.add(value);
                        }

                        Context context = getContext();
                        if (context == null) {
                            context = getActivity();
                        }

                        if (context != null) {
                            adptr = new adapter(context, data, navController);

                            rv.setLayoutManager(new LinearLayoutManager(context));
                            rv.setHasFixedSize(true);
                            rv.setAdapter(adptr);
                           pss.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Veri alımı başarısız olursa buraya düşer
                        Log.e("hata", "ops");
                    }
                });
            }


        // ... (diğer işlemleri burada yapın)
    }

    // ... (diğer yöntemler ve kodlar)
