package com.erasmus.balnature;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class fragment_ayarlar_ana extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ff=inflater.inflate(R.layout.fragment_ayarlar_ana, container, false);
        ConstraintLayout layout1 = ff.findViewById(R.id.constraintLayout56);
        ConstraintLayout layout2 = ff.findViewById((R.id.constraintLayout58));
        ConstraintLayout layout3 = ff.findViewById(R.id.constraintLayout59l);
        ConstraintLayout layout4 = ff.findViewById(R.id.constraintLayout56e);
        ConstraintLayout layout5 = ff.findViewById(R.id.constraintLayout58ww);
        ConstraintLayout layout6 = ff.findViewById(R.id.constraintLayout59lw);
        ConstraintLayout layout7 = ff.findViewById(R.id.constraintLayout56ebs);
        ConstraintLayout layout8 = ff.findViewById(R.id.constraintLayout58wwbs);
        ConstraintLayout layout9 = ff.findViewById(R.id.constraintLayout59lwbs);
        ConstraintLayout layout10 = ff.findViewById(R.id.constraintLayout56eb);
        ConstraintLayout layout11 = ff.findViewById(R.id.constraintLayout58wwb);
        ConstraintLayout layout12 = ff.findViewById(R.id.constraintLayout59lwb);
        ConstraintLayout layout13 = ff.findViewById(R.id.constraintLayout56ebmll);
        ConstraintLayout layout14 = ff.findViewById(R.id.constraintLayout58wwbmll);
        TextView txt=ff.findViewById(R.id.textView116);
        ConstraintLayout layout30 = ff.findViewById(R.id.constraintLayout58wwbmkq);
        ConstraintLayout layout16 = ff.findViewById(R.id.constraintLayout59lwbkll);
        ConstraintLayout layout17 = ff.findViewById(R.id.constraintLayout56ebmkll);
        ConstraintLayout layout18 = ff.findViewById(R.id.constraintLayout58wwbmkll);
        ConstraintLayout layout19 = ff.findViewById(R.id.constraintLayout56ebm);
        ConstraintLayout layout20 = ff.findViewById(R.id.constraintLayout58wwbm);
        ConstraintLayout layout21 = ff.findViewById(R.id.constraintLayout59lwbmll);
        ConstraintLayout layout22 = ff.findViewById(R.id.constraintLayout59lwbk);
        ConstraintLayout layout23 = ff.findViewById(R.id.constraintLayout56ebmkh);
        ConstraintLayout layout24 = ff.findViewById(R.id.constraintLayout58wwbmkh);
        ConstraintLayout layout25 = ff.findViewById(R.id.constraintLayout56ebmk);
        ConstraintLayout layout26 = ff.findViewById(R.id.constraintLayout58wwbmk);
        ConstraintLayout layout27 = ff.findViewById(R.id.constraintLayout56ebmv);
        ConstraintLayout layout28 = ff.findViewById(R.id.constraintLayout58wwbmv);
        ConstraintLayout layout29 = ff.findViewById(R.id.constraintLayout59lwbmv);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        int aa=sharedPreferences.getInt("sifrekontrol", 0);
        if(aa==1){
            txt.setText("ON");
            txt.setTextColor(Color.GREEN);

        }

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                        builder.setTitle("Uyarı");
                        builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                        builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // "Tamam" düğmesine tıklandığında yapılacak işlemler
                            }
                        });



                        AlertDialog dialog = builder.create();
                        dialog.show();

            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        layout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        }); layout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        }); layout8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        }); layout9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        }); layout10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        }); layout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        layout13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        }); layout14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        layout16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        layout17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        layout18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setTitle("Uyarı");
                builder.setMessage("Bu özellik demo sürümünde geçerli değildir.");

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "Tamam" düğmesine tıklandığında yapılacak işlemler
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });




        layout27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Log.e("click","click");
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("sifre", "");
                editor.apply();

                SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor2 = sharedPreferences.edit();
                editor.putInt("sifrekontrol", 0);
                editor.apply();
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(getContext(), introo.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });layout29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Log.e("click","click");

                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                FirebaseUser user = mAuth.getCurrentUser();

                if (user != null) {
                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString("sifre", "");
                                        editor.apply();

                                        SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getContext());
                                        SharedPreferences.Editor editor2 = sharedPreferences.edit();
                                        editor.putInt("sifrekontrol", 0);
                                        editor.apply();
                                        Toast.makeText(ff.getContext(),     "Hesabınız Başarıyla Silindi", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getContext(), introo.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(ff.getContext(),     "Hesabınız Silinirken bir hata oluştu", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }




            }
        });
        layout28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Log.e("click","click");
                ArrayList<veriaktarimi> v=new ArrayList<>();
                veriaktarimi ver=new veriaktarimi("varsayılan","veri",1, (long)111,"Ev",0,0,0,0,0,0,0,0,0, 3.5f);
                v.add(ver);
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                FirebaseUser currentUser = mAuth.getCurrentUser();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseRef2 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("kayitsayisi");
                DatabaseReference databaseRef3 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("toplamortalama");
                DatabaseReference databaseRef4 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("metalortlama");
                DatabaseReference databaseRef5 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("kagitortalama");
                DatabaseReference databaseRef6 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("camortalama");
                DatabaseReference databaseRef7 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("plastikortalama");

                DatabaseReference databaseRef1 = database.getReference("kullanicilar/" + mAuth.getUid().toString()).child("veriListesi");
                databaseRef1.setValue(v)
                        .addOnSuccessListener(aVoid -> {
                            Toast.makeText(ff.getContext(),     "Hesap verileriniz başarıyla silindi.", Toast.LENGTH_SHORT).show();
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(ff.getContext(),     "Hesap verileriniz silinirken bir hata oluştu.", Toast.LENGTH_SHORT).show();
                        });
databaseRef2.setValue(1);
                databaseRef3.setValue(0);
                databaseRef4.setValue(0);
                databaseRef5.setValue(0);
                databaseRef6.setValue(0);
                databaseRef7.setValue(0);
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("sifre", "");
                editor.apply();

                SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor2 = sharedPreferences.edit();
                editor.putInt("sifrekontrol", 0);
                editor.apply();


                Intent intent = new Intent(getContext(), introo.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });layout22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Log.e("click","click");

                Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_ana_to_fragment_ayarlar_hakkinda);
            }
        });layout26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Log.e("click","click");

                Navigation.findNavController(ff).navigate(R.id.action_fragment_ayarlar_ana_to_fragment_ayarlar_bilgisayarsrm);
            }
        });
        layout19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Log.e("click","click");

                Uri uri = Uri.parse("https://www.seazer.xyz/balnature/document/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });layout25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Log.e("click","click");

                AlertDialog.Builder builder = new AlertDialog.Builder(ff.getContext());
                builder.setMessage("Uygulama Henüz Play Store'de olmadığı için bu özellik aktif değil.")
                        .setTitle("Tamam")
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        layout20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Log.e("click","click");

                Uri uri = Uri.parse("https://www.seazer.xyz/balnature/faq/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        layout21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Log.e("click","click");
                Navigation.findNavController(view).navigate(R.id.fragment_ayarlar_language);
                Log.e("click","click");
            }
        });
layout1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_fragment_ayarlar_ana_to_fragment_ayarlar_plan);
    }
});
        layout24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_ayarlar_ana_to_fragment_ayarlar_iletisim);
            }
        });
        layout11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_ayarlar_ana_to_fragment_ayarlar_sifrailk2);
            }
        });
        layout30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_ayarlar_ana_to_fragment_ayarlar_sozlesme);
            }
        });


        setTouchListener(layout1);
        setTouchListener(layout2);
        setTouchListener(layout3);
        setTouchListener(layout4);
        setTouchListener(layout5);
        setTouchListener(layout6);
        setTouchListener(layout7);
        setTouchListener(layout8);
        setTouchListener(layout9);
        setTouchListener(layout10);
        setTouchListener(layout11);
        setTouchListener(layout12);
        setTouchListener(layout13);
        setTouchListener(layout14);

        setTouchListener(layout16);
        setTouchListener(layout17);
        setTouchListener(layout18);
        setTouchListener(layout19);
        setTouchListener(layout20);
        setTouchListener(layout21);
        setTouchListener(layout22);
        setTouchListener(layout23);
        setTouchListener(layout24);
        setTouchListener(layout25);
        setTouchListener(layout26);
        setTouchListener(layout27);
        setTouchListener(layout28);
        setTouchListener(layout29);
        setTouchListener(layout30);









        return ff;
    }
    private void setTouchListener(final ConstraintLayout layout) {
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Üzerine gelindiğinde buraya kod ekleyin
                        // Arka plan rengini değiştirin veya diğer işlemleri gerçekleştirin
                        layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.renkiste));
                        break;
                    case MotionEvent.ACTION_UP:
                        // Dokunma bittiğinde buraya kod ekleyin
                        // Arka plan rengini geri döndürün veya diğer işlemleri gerçekleştirin
                        layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.renkaa));

                            // Eğer bu bir tıklama ise OnClickListener'ı çağırın
                            v.performClick();


                        break;
                    case MotionEvent.ACTION_CANCEL:
                        // Dokunma iptal edildiğinde buraya kod ekleyin
                        // Arka plan rengini geri döndürün veya diğer işlemleri gerçekleştirin
                        layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.renkaa));
                        break;
                }
                return true; // true döndürerek olayın tüketildiğini belirtin
            }
        });
    }
}