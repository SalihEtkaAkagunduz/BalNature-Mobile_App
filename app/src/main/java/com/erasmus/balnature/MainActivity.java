package com.erasmus.balnature;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextPaint;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.erasmus.balnature.databinding.ActivityMainBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    NavController navControllerr;
    View headerView;
    String eposta, kullaniciadi, kullanici_id, randomString;
    TextView textviewnavigationüst, textviewnavigationalt;
    ImageView imageviewnavigationust,imgg;
    NavHostFragment navHostFragment;
    ArrayList<String> soz;

    int randomIndex,oturumacikmi=0,hesapmenüsüaçıkmı=0;
    int menuu=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.textView3.setSelected(true);
        binding.setTasar(this);


        arraytanımla();
        Random random = new Random();
          randomIndex = random.nextInt(soz.size());
          randomString = soz.get(randomIndex);
        binding.setCumle(randomString);
        binding.navvi.inflateHeaderView(R.layout.navigation_drawer_ust);
        headerView = binding.navvi.getHeaderView(0);
        imageviewnavigationust = headerView.findViewById(R.id.imageView4);


        textviewnavigationüst = headerView.findViewById(R.id.textView4);
        textviewnavigationalt = headerView.findViewById(R.id.textView5);
        textviewnavigationüst.setText(kullaniciadi);

        textviewnavigationalt.setText(eposta);
        kullanıcıkontrol();
        tamekran();

        navhostfragmentişlemleri();

        listener();
    }


    void navhostfragmentişlemleri() {
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (navHostFragment != null) {
            navControllerr = navHostFragment.getNavController();
            Log.e("aa", "var");
            drawerLayout = binding.drawer;
            navigationView = binding.navvi;
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navControllerr.getGraph())
                    .setDrawerLayout(drawerLayout)
                    .build();
            NavigationUI.setupWithNavController(navigationView, navControllerr);
        } else {
            Log.e("aa", "yok");
        }
    }


    void arraytanımla() {
        soz = new ArrayList<String>() {
            {


                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                if (selectedLanguage.equals("es")) {

                    add("\"One thing is clear: Our world is not in safe hands. The 'New World Order' has condemned our planet to death.\"");
                    add("\"Ya la contaminación en nuestras ciudades la eliminamos, o la contaminación en nuestras ciudades nos eliminará.\"");
                    add("\"En sociedades que tratan la naturaleza de manera imprudente, las relaciones entre las personas también se vuelven imprudentes.\"");
                    add("\"No contaminar es más barato que limpiar.\"");
                    add("\"Nuestros esfuerzos por proteger el aire, el agua y la vida natural son en realidad esfuerzos por protegernos a nosotros mismos.\"");
                    add("\"Si todos barren frente a su propia casa, toda la ciudad estará limpia.\"");
                    add("\"Las personas limpian cosas no limpias con agua. Si el agua está contaminada, ¿cómo la limpiarán?\"");
                    add("\"Los peligros ambientales ya no solo conciernen a los entusiastas de las aves; las campanas de este peligro tocan para todos nosotros.\"");
                    add("\"El medio ambiente es un asunto demasiado serio para dejarlo solo en manos de los ecologistas.\"");
                    add("\"Un entorno sucio contamina el alma humana, y las almas contaminadas contaminan el entorno.\"");
                    add("\"A medida que protegemos la naturaleza, la naturaleza también nos protege a nosotros.\"");
                    add("\"La limpieza es una cuestión de respeto y de una persona moderna y exitosa.\"");
                    add("\"Mantén tu entorno limpio para que el futuro se mantenga limpio.\"");
                    add("\"Todos tienen el derecho de vivir en un entorno natural saludable y equilibrado.\"");
                    add("\"La contaminación ambiental es un problema que afecta cada momento de nuestras vidas.\"");
                    add("\"Una vida saludable viene con un entorno saludable.\"");
                    add("\"El medio ambiente no es una herencia, sino un legado que se transmitirá a las generaciones futuras.\"");
                    add("\"Mantén el aire limpio e ilumina el entorno.\"");
                    add("\"Ama lo verde, ama la vida.\"");
                    add("\"La naturaleza del mañana se crea a partir de hoy.\"");
                    add("\"Si los pájaros no vuelan y los peces mueren, ¿cómo vivirán las personas?\"");
                } else if (selectedLanguage.equals("en")) {
                    add("\"One thing is clear: Our world is not in safe hands. The 'New World Order' has condemned our planet to death.\"");
                    add("\"Either we will eliminate the pollution in our cities, or the pollution in our cities will eliminate us.\"");
                    add("\"In societies that treat nature recklessly, relationships among people also become reckless.\"");
                    add("\"Not polluting is cheaper than cleaning up.\"");
                    add("\"Our efforts to protect the air, water, and natural life are actually efforts to protect ourselves.\"");
                    add("\"If everyone sweeps in front of their own house, the entire city will be clean.\"");
                    add("\"People clean unclean things with water. If the water is polluted, how will they clean it?\"");
                    add("\"Environmental dangers no longer concern only bird enthusiasts; the bells of this danger toll for all of us.\"");
                    add("\"The environment is a matter too serious to be left to environmentalists alone.\"");
                    add("\"A dirty environment pollutes the human soul, and polluted souls pollute the environment.\"");
                    add("\"As we protect nature, nature also protects us.\"");
                    add("\"Cleanliness is a matter of respect, and a successful modern person.\"");
                    add("\"Keep your environment clean so that the future stays clean.\"");
                    add("\"Everyone has the right to live in a healthy, balanced natural environment.\"");
                    add("\"Environmental pollution is an issue that affects every moment of our lives.\"");
                    add("\"Healthy living comes with a healthy environment.\"");
                    add("\"The environment is not an inheritance but a legacy to be passed on to future generations.\"");
                    add("\"Keep the air clean and illuminate the environment!\"");
                    add("\"Love the green, love life.\"");
                    add("\"Tomorrow's nature is created from today.\"");
                    add("\"If birds don't fly and fish die, how will people live?\"");
                } else if (selectedLanguage.equals("tr")) {
                    add("\"Bir nokta açıktır: Dünyamız emin ellerde değildir ” Yeni dünya düzeni” yeryüzünü ölüme mahkum etmiştir.\"");
                    add("\"Ya bizler kentlerimizin kirlenmesini ortadan kaldıracağız ya da kentlerimizin kirlenmesi bizleri.\"");
                    add("\"Doğaya hoyratça davranan toplumlarda insanlar arasındaki ilişkiler de hoyratça oluyorlar.\"");
                    add("\"Kirletmemek, temizlemekten daha ucuzdur.\"");
                    add("\"Havayı, suyu, doğal yaşamı koruma çabalarımız, aslında kendimizi koruma çabalarımızdır.\"");
                    add("\"Herkes evinin önünü süpürürse, bütün şehir temiz olur.\"");
                    add("\"İnsan, temiz olmayan şeyleri su ile yıkayıp temizler, eğer su kirlenirse, o ne ile nasıl temizlenir?\"");
                    add("\"Çevresel tehlikeler, artık yalnızca kuş meraklılarını ilgilendirmiyor, bu tehlikenin çanları hepimiz için çalıyor.\"");
                    add("\"Çevre, çevrecilere bırakılmayacak kadar ciddi bir meseledir.\"");
                    add("\"Kirli çevre insanın ruhunu kirletir, kirli ruhlar çevreyi kirletir.\"");
                    add("\"Biz doğayı korudukça doğa da bizi korur.\"");
                    add("\"Temizlik saygı işidir, başaran çağdaş kişidir.\"");
                    add("\"Çevreni temiz tut ki geleceğin kirlenmesin.\"");
                    add("\"Herkes sağlıklı, dengeli bir doğal çevrede yaşamak hakkına sahiptir.\"");
                    add("\"Çevre kirliliği, her anımızı etkileyen sağlıklı bir yaşam konusudur.\"");
                    add("\"Sağlıklı yaşam, sağlıklı çevre ile olur.\"");
                    add("\"Çevre; miras değil gelecek nesillere devredilecek emanettir.\"");
                    add("\"Havayı temiz tutun çevreyi aydınlatın!\"");
                    add("\"Yeşili sev, hayatı sev.\"");
                    add("\"Yarının doğası bugünden yaratılır.\"");
                    add("\"Uçmuyorsa kuşlar, ölüyorsa balıklar, nasıl yaşar insanlar?\"");
                } else {
                    Locale currentLocale = Locale.getDefault();
                    String currentLanguageCode = currentLocale.getLanguage();

                    if ("es".equals(currentLanguageCode)) {

                        add("\"One thing is clear: Our world is not in safe hands. The 'New World Order' has condemned our planet to death.\"");
                        add("\"Ya la contaminación en nuestras ciudades la eliminamos, o la contaminación en nuestras ciudades nos eliminará.\"");
                        add("\"En sociedades que tratan la naturaleza de manera imprudente, las relaciones entre las personas también se vuelven imprudentes.\"");
                        add("\"No contaminar es más barato que limpiar.\"");
                        add("\"Nuestros esfuerzos por proteger el aire, el agua y la vida natural son en realidad esfuerzos por protegernos a nosotros mismos.\"");
                        add("\"Si todos barren frente a su propia casa, toda la ciudad estará limpia.\"");
                        add("\"Las personas limpian cosas no limpias con agua. Si el agua está contaminada, ¿cómo la limpiarán?\"");
                        add("\"Los peligros ambientales ya no solo conciernen a los entusiastas de las aves; las campanas de este peligro tocan para todos nosotros.\"");
                        add("\"El medio ambiente es un asunto demasiado serio para dejarlo solo en manos de los ecologistas.\"");
                        add("\"Un entorno sucio contamina el alma humana, y las almas contaminadas contaminan el entorno.\"");
                        add("\"A medida que protegemos la naturaleza, la naturaleza también nos protege a nosotros.\"");
                        add("\"La limpieza es una cuestión de respeto y de una persona moderna y exitosa.\"");
                        add("\"Mantén tu entorno limpio para que el futuro se mantenga limpio.\"");
                        add("\"Todos tienen el derecho de vivir en un entorno natural saludable y equilibrado.\"");
                        add("\"La contaminación ambiental es un problema que afecta cada momento de nuestras vidas.\"");
                        add("\"Una vida saludable viene con un entorno saludable.\"");
                        add("\"El medio ambiente no es una herencia, sino un legado que se transmitirá a las generaciones futuras.\"");
                        add("\"Mantén el aire limpio e ilumina el entorno.\"");
                        add("\"Ama lo verde, ama la vida.\"");
                        add("\"La naturaleza del mañana se crea a partir de hoy.\"");
                        add("\"Si los pájaros no vuelan y los peces mueren, ¿cómo vivirán las personas?\"");


                    } else if ("en".equals(currentLanguageCode)) {
                        add("\"One thing is clear: Our world is not in safe hands. The 'New World Order' has condemned our planet to death.\"");
                        add("\"Either we will eliminate the pollution in our cities, or the pollution in our cities will eliminate us.\"");
                        add("\"In societies that treat nature recklessly, relationships among people also become reckless.\"");
                        add("\"Not polluting is cheaper than cleaning up.\"");
                        add("\"Our efforts to protect the air, water, and natural life are actually efforts to protect ourselves.\"");
                        add("\"If everyone sweeps in front of their own house, the entire city will be clean.\"");
                        add("\"People clean unclean things with water. If the water is polluted, how will they clean it?\"");
                        add("\"Environmental dangers no longer concern only bird enthusiasts; the bells of this danger toll for all of us.\"");
                        add("\"The environment is a matter too serious to be left to environmentalists alone.\"");
                        add("\"A dirty environment pollutes the human soul, and polluted souls pollute the environment.\"");
                        add("\"As we protect nature, nature also protects us.\"");
                        add("\"Cleanliness is a matter of respect, and a successful modern person.\"");
                        add("\"Keep your environment clean so that the future stays clean.\"");
                        add("\"Everyone has the right to live in a healthy, balanced natural environment.\"");
                        add("\"Environmental pollution is an issue that affects every moment of our lives.\"");
                        add("\"Healthy living comes with a healthy environment.\"");
                        add("\"The environment is not an inheritance but a legacy to be passed on to future generations.\"");
                        add("\"Keep the air clean and illuminate the environment!\"");
                        add("\"Love the green, love life.\"");
                        add("\"Tomorrow's nature is created from today.\"");
                        add("\"If birds don't fly and fish die, how will people live?\"");


                    } else if ("tr".equals(currentLanguageCode)) {
                        add("\"Bir nokta açıktır: Dünyamız emin ellerde değildir ” Yeni dünya düzeni” yeryüzünü ölüme mahkum etmiştir.\"");
                        add("\"Ya bizler kentlerimizin kirlenmesini ortadan kaldıracağız ya da kentlerimizin kirlenmesi bizleri.\"");
                        add("\"Doğaya hoyratça davranan toplumlarda insanlar arasındaki ilişkiler de hoyratça oluyorlar.\"");
                        add("\"Kirletmemek, temizlemekten daha ucuzdur.\"");
                        add("\"Havayı, suyu, doğal yaşamı koruma çabalarımız, aslında kendimizi koruma çabalarımızdır.\"");
                        add("\"Herkes evinin önünü süpürürse, bütün şehir temiz olur.\"");
                        add("\"İnsan, temiz olmayan şeyleri su ile yıkayıp temizler, eğer su kirlenirse, o ne ile nasıl temizlenir?\"");
                        add("\"Çevresel tehlikeler, artık yalnızca kuş meraklılarını ilgilendirmiyor, bu tehlikenin çanları hepimiz için çalıyor.\"");
                        add("\"Çevre, çevrecilere bırakılmayacak kadar ciddi bir meseledir.\"");
                        add("\"Kirli çevre insanın ruhunu kirletir, kirli ruhlar çevreyi kirletir.\"");
                        add("\"Biz doğayı korudukça doğa da bizi korur.\"");
                        add("\"Temizlik saygı işidir, başaran çağdaş kişidir.\"");
                        add("\"Çevreni temiz tut ki geleceğin kirlenmesin.\"");
                        add("\"Herkes sağlıklı, dengeli bir doğal çevrede yaşamak hakkına sahiptir.\"");
                        add("\"Çevre kirliliği, her anımızı etkileyen sağlıklı bir yaşam konusudur.\"");
                        add("\"Sağlıklı yaşam, sağlıklı çevre ile olur.\"");
                        add("\"Çevre; miras değil gelecek nesillere devredilecek emanettir.\"");
                        add("\"Havayı temiz tutun çevreyi aydınlatın!\"");
                        add("\"Yeşili sev, hayatı sev.\"");
                        add("\"Yarının doğası bugünden yaratılır.\"");
                        add("\"Uçmuyorsa kuşlar, ölüyorsa balıklar, nasıl yaşar insanlar?\"");
                    } else {
                        add("\"Bir nokta açıktır: Dünyamız emin ellerde değildir ” Yeni dünya düzeni” yeryüzünü ölüme mahkum etmiştir.\"");
                        add("\"Ya bizler kentlerimizin kirlenmesini ortadan kaldıracağız ya da kentlerimizin kirlenmesi bizleri.\"");
                        add("\"Doğaya hoyratça davranan toplumlarda insanlar arasındaki ilişkiler de hoyratça oluyorlar.\"");
                        add("\"Kirletmemek, temizlemekten daha ucuzdur.\"");
                        add("\"Havayı, suyu, doğal yaşamı koruma çabalarımız, aslında kendimizi koruma çabalarımızdır.\"");
                        add("\"Herkes evinin önünü süpürürse, bütün şehir temiz olur.\"");
                        add("\"İnsan, temiz olmayan şeyleri su ile yıkayıp temizler, eğer su kirlenirse, o ne ile nasıl temizlenir?\"");
                        add("\"Çevresel tehlikeler, artık yalnızca kuş meraklılarını ilgilendirmiyor, bu tehlikenin çanları hepimiz için çalıyor.\"");
                        add("\"Çevre, çevrecilere bırakılmayacak kadar ciddi bir meseledir.\"");
                        add("\"Kirli çevre insanın ruhunu kirletir, kirli ruhlar çevreyi kirletir.\"");
                        add("\"Biz doğayı korudukça doğa da bizi korur.\"");
                        add("\"Temizlik saygı işidir, başaran çağdaş kişidir.\"");
                        add("\"Çevreni temiz tut ki geleceğin kirlenmesin.\"");
                        add("\"Herkes sağlıklı, dengeli bir doğal çevrede yaşamak hakkına sahiptir.\"");
                        add("\"Çevre kirliliği, her anımızı etkileyen sağlıklı bir yaşam konusudur.\"");
                        add("\"Sağlıklı yaşam, sağlıklı çevre ile olur.\"");
                        add("\"Çevre; miras değil gelecek nesillere devredilecek emanettir.\"");
                        add("\"Havayı temiz tutun çevreyi aydınlatın!\"");
                        add("\"Yeşili sev, hayatı sev.\"");
                        add("\"Yarının doğası bugünden yaratılır.\"");
                        add("\"Uçmuyorsa kuşlar, ölüyorsa balıklar, nasıl yaşar insanlar?\"");
                    }
                }


            }
        };

    }
void oyungit(){
    binding.textView3.setVisibility(View.VISIBLE);
    binding.cl1.setVisibility(View.INVISIBLE);
    binding.imageButton3.setImageResource(R.drawable.indirme);
    menuu=0;
}
Button bten;
    void listener() {
        binding.navvi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                NavController navController = navHostFragment.getNavController();
                binding.setCumle(randomString);
                if (item.getItemId() == R.id.fragment_menuu) {
                    changeTab(0);
                } else if (item.getItemId() == R.id.fragment_haber) {
                    changeTab(1);
                } else if (item.getItemId() == R.id.fragment_veri) {
                    changeTab(2);
                } else if (item.getItemId() == R.id.fragment_veri2) {
                    FirebaseAuth mAuth2;
                    mAuth2 = FirebaseAuth.getInstance();
                    FirebaseUser currentUser2 = mAuth2.getCurrentUser();

                    if (currentUser2 != null) {
                        drawerLayout.closeDrawer(GravityCompat.START);
                        oyungit();
                        navController.navigate(R.id.fragment_veri2);

                    } else {
                        drawerLayout.closeDrawer(GravityCompat.START);

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Uyarı");
                        builder.setMessage("Bu özelliği kullanabilmek için oturum açmalısınız.");

                        builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // "Tamam" düğmesine tıklandığında yapılacak işlemler
                            }
                        });


                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                } else if (item.getItemId() == R.id.yanmenuhakkinda) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    oyungit();
                    navController.navigate(R.id.hakkinda);
                } else if (item.getItemId() == R.id.yanmenuayarlar) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    oyungit();
                    navController.navigate(R.id.ayarlar);
                } else if (item.getItemId() == R.id.yanmenuistatistikler) {
                    FirebaseAuth mAuth2;
                    mAuth2 = FirebaseAuth.getInstance();
                    FirebaseUser currentUser2 = mAuth2.getCurrentUser();

                    if (currentUser2 != null) {
                        drawerLayout.closeDrawer(GravityCompat.START);
                        oyungit();
                        navController.navigate(R.id.iststistikler);

                    } else {
                        drawerLayout.closeDrawer(GravityCompat.START);

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Uyarı");
                        builder.setMessage("Bu özelliği kullanabilmek için oturum açmalısınız.");

                        builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // "Tamam" düğmesine tıklandığında yapılacak işlemler
                            }
                        });



                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                } else if (item.getItemId() == R.id.yanmenuaraclar) {
                    drawerLayout.closeDrawer(GravityCompat.START);

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Uyarı");
                            builder.setMessage("Bu özellik demo sürümünde sınırlıdır.");

                            builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // "Tamam" düğmesine tıklandığında yapılacak işlemler
                                }
                            });



                            AlertDialog dialog = builder.create();
                            dialog.show();

                } else if (item.getItemId() == R.id.yanmenüöneriler) {
                    drawerLayout.closeDrawer(GravityCompat.START);

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Uyarı");
                    builder.setMessage("Bu özellik demo sürümünde sınırlıdır.");

                    builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // "Tamam" düğmesine tıklandığında yapılacak işlemler
                        }
                    });



                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                return false;
            }
        });


        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
                hesapmenüsüaçıkmı=0;

            }

        });


        View.OnTouchListener imageButtonTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        binding.imageButton4.setImageResource(R.drawable.alerton);
                        break;
                    case MotionEvent.ACTION_UP:
                        binding.imageButton4.setImageResource(R.drawable.bildirim);
                        break;
                }
                return false;
            }
        };

        NavController navController = navHostFragment.getNavController();
        binding.imageButton4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        binding.imageButton4.setImageResource(R.drawable.alerton);
                        break;
                    case MotionEvent.ACTION_UP:
                        FirebaseAuth mAuth2;
                        mAuth2 = FirebaseAuth.getInstance();
                        FirebaseUser currentUser2 = mAuth2.getCurrentUser();

                        if (currentUser2 != null) {
                            oyungit();
                            navController.navigate(R.id.bildirim);
                            binding.imageButton4.setImageResource(R.drawable.bildirim);

                        } else {

                            binding.imageButton4.setImageResource(R.drawable.bildirim);
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Uyarı");
                            builder.setMessage("Oturum açmayan kişilere bildirim gelemez.");

                            builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // "Tamam" düğmesine tıklandığında yapılacak işlemler
                                }
                            });


                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }

                        break;
                }
                return false;
            }
        });


        binding.imageButton3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        if (menuu==0){
                            menuu =1;
                            navController.navigate(R.id.oyun);
                            binding.textView3.setVisibility(View.INVISIBLE);
                            binding.cl1.setVisibility(View.VISIBLE);
                            binding.imageButton3.setImageResource(R.drawable.indirildi);
                            break;

                        }
                        else{
                            navController.navigate(R.id.anamenu);
                            binding.textView3.setVisibility(View.VISIBLE);
                            binding.cl1.setVisibility(View.INVISIBLE);
                            binding.imageButton3.setImageResource(R.drawable.indirme);
                            menuu=0;
                            break;
                        }



                }
                return false;
            }
        });

        binding.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth mAuth2;
                mAuth2 = FirebaseAuth.getInstance();
                FirebaseUser currentUser2 = mAuth2.getCurrentUser();
                NavController navController = navHostFragment.getNavController();
                if (currentUser2 != null) {
                    if(hesapmenüsüaçıkmı==0){
                        oyungit();
                        navController.navigate(R.id.hesapayarlari);
                        hesapmenüsüaçıkmı=1;

                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        String selectedLanguage = sharedPreferences.getString("selectedLanguage", "tr"); // defaultLanguage varsayılan dil
                        if (selectedLanguage.equals("es")) {
                            binding.setCumle("-Configuración de la cuenta-");
                        } else if (selectedLanguage.equals("en")) {
                            // İngilizce için özel işlemler
                            binding.setCumle("-Account Settings-");
                        } else if (selectedLanguage.equals("tr")) {
                            // Türkçe için özel işlemler
                            binding.setCumle("-Hesap Ayarları-");
                        } else {
                            Locale currentLocale = Locale.getDefault();
                            String currentLanguageCode = currentLocale.getLanguage();

                            if ("es".equals(currentLanguageCode)) {


                                binding.setCumle("-Configuración de la cuenta-");
                            } else if ("en".equals(currentLanguageCode)) {

                                binding.setCumle("-Account Settings-");

                            } else if ("tr".equals(currentLanguageCode)) {
                                binding.setCumle("-Hesap Ayarları-");
                            } else {
                                binding.setCumle("-Hesap Ayarları-");
                            }
                        }





                    }
                    else{oyungit();
                        navController.navigate(R.id.anamenu);
                        changeTab(0);
                        hesapmenüsüaçıkmı=0;
                        binding.setCumle(randomString);
                    }

                } else {
                    Intent intent2 = new Intent(MainActivity.this, activity_login.class);
                    startActivity(intent2);
                }

            }
        });


        binding.imageButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                    if(oturumacikmi==1){
                        switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:

                            binding.imageButton2.setImageBitmap(createProfileImageDARK(kullaniciadi));
                            break;
                        case MotionEvent.ACTION_UP:
                            binding.imageButton2.setImageBitmap(createProfileImage(kullaniciadi));
                            break;
                    }
                }
                    else {
                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_DOWN:

                                binding.imageButton2.setImageResource(R.drawable.kullanicitikli);
                                break;
                            case MotionEvent.ACTION_UP:
                                binding.imageButton2.setImageResource(R.drawable.kullanici);
                                break;
                        }
                    }
                return false;
            }
        });


        imageviewnavigationust.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(oturumacikmi==1){
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            imageviewnavigationust.setImageBitmap(createProfileImageDARK(kullaniciadi));
                            break;
                        case MotionEvent.ACTION_UP:
                            imageviewnavigationust.setImageBitmap(createProfileImage(kullaniciadi));
                            break;
                    }
                }
                else {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            imageviewnavigationust.setImageResource(R.drawable.kullanicitikli);
                            break;
                        case MotionEvent.ACTION_UP:
                            imageviewnavigationust.setImageResource(R.drawable.kullanici);
                            break;
                    }
                }
                return false;
            }
        });


        imageviewnavigationust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("olay", "click");
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
    }


    private void hideSystemUI() {
        View decoorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // Android 11 ve üzeri için
            decoorView.getWindowInsetsController().hide(WindowInsets.Type.navigationBars());
        } else {
            // Eski sürümler için
            decoorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }


    private void changeTab(int tabIndex) {
        oyungit();
        navControllerr.navigate(R.id.anamenu);
        drawerLayout.closeDrawer(GravityCompat.START);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TabLayout tabLayout = findViewById(R.id.tabLayout);
                TabLayout.Tab tab = tabLayout.getTabAt(tabIndex);
                if (tab != null) {
                    tab.select();
                }
            }
        }, 200);
    }


    public Bitmap createProfileImage(String text) {
        int[] colors = {
                Color.parseColor("#FF0000"), Color.parseColor("#FF7F00"), Color.parseColor("#FFD700"),
                Color.parseColor("#00FF00"), Color.parseColor("#00FF7F"), Color.parseColor("#00FFFF"),
                Color.parseColor("#0000FF"), Color.parseColor("#8A2BE2"), Color.parseColor("#4B0082"),
                Color.parseColor("#9400D3"), Color.parseColor("#FF1493"), Color.parseColor("#FF00FF"),
                Color.parseColor("#DC143C"), Color.parseColor("#FF4500"), Color.parseColor("#FFA500"),
                Color.parseColor("#808000"), Color.parseColor("#006400"), Color.parseColor("#008080"),
                Color.parseColor("#000080"), Color.parseColor("#8B008B"), Color.parseColor("#800080"),
                Color.parseColor("#B22222"), Color.parseColor("#FF69B4"), Color.parseColor("#FFC0CB"),
                Color.parseColor("#F08080"), Color.parseColor("#FFA07A"), Color.parseColor("#ADFF2F"),
                Color.parseColor("#00FF00"), Color.parseColor("#32CD32")
        };
        String initial = String.valueOf(text.charAt(0));
        int size = 300;
        Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(120);
        textPaint.setTextAlign(Paint.Align.CENTER);
        int colorIndex = 0;
        if (initial.matches("[A-Za-zÇçĞğİıÖöŞşÜü]")) {
            char firstChar = initial.toUpperCase().charAt(0);
            if (firstChar >= 'A' && firstChar <= 'Z') {
                colorIndex = (firstChar - 'A') % colors.length;
            } else if (firstChar >= 'Ç' && firstChar <= 'Ü') {
                colorIndex = (firstChar - 'Ç') % colors.length;
            }
        }
        canvas.drawColor(colors[colorIndex]);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float yOffset = (fontMetrics.ascent + fontMetrics.descent) / 2;
        float xPos = canvas.getWidth() / 2;
        float yPos = (canvas.getHeight() / 2) - yOffset;
        canvas.drawText(initial, xPos, yPos, textPaint);
        Bitmap output = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas outputCanvas = new Canvas(output);
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, size, size);
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        outputCanvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.WHITE);
        outputCanvas.drawOval(rectF, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        outputCanvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }


    public Bitmap createProfileImageDARK(String text) {
        int[] colors = {
                Color.parseColor("#FF0000"), Color.parseColor("#FF7F00"), Color.parseColor("#FFD700"),
                Color.parseColor("#00FF00"), Color.parseColor("#00FF7F"), Color.parseColor("#00FFFF"),
                Color.parseColor("#0000FF"), Color.parseColor("#8A2BE2"), Color.parseColor("#4B0082"),
                Color.parseColor("#9400D3"), Color.parseColor("#FF1493"), Color.parseColor("#FF00FF"),
                Color.parseColor("#DC143C"), Color.parseColor("#FF4500"), Color.parseColor("#FFA500"),
                Color.parseColor("#808000"), Color.parseColor("#006400"), Color.parseColor("#008080"),
                Color.parseColor("#000080"), Color.parseColor("#8B008B"), Color.parseColor("#800080"),
                Color.parseColor("#B22222"), Color.parseColor("#FF69B4"), Color.parseColor("#FFC0CB"),
                Color.parseColor("#F08080"), Color.parseColor("#FFA07A"), Color.parseColor("#ADFF2F"),
                Color.parseColor("#00FF00"), Color.parseColor("#32CD32")
        };
        String initial = String.valueOf(text.charAt(0));
        int size = 300;
        Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK); // Harf rengi siyah
        textPaint.setTextSize(120);
        textPaint.setTextAlign(Paint.Align.CENTER);
        int colorIndex = 0;
        if (initial.matches("[A-Za-zÇçĞğİıÖöŞşÜü]")) {
            char firstChar = initial.toUpperCase().charAt(0);
            if (firstChar >= 'A' && firstChar <= 'Z') {
                colorIndex = (firstChar - 'A') % colors.length;
            } else if (firstChar >= 'Ç' && firstChar <= 'Ü') {
                colorIndex = (firstChar - 'Ç') % colors.length;
            }
        }
        canvas.drawColor(colors[colorIndex]);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float yOffset = (fontMetrics.ascent + fontMetrics.descent) / 2;
        float xPos = canvas.getWidth() / 2;
        float yPos = (canvas.getHeight() / 2) - yOffset;
        canvas.drawText(initial, xPos, yPos, textPaint);
        Bitmap output = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas outputCanvas = new Canvas(output);
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, size, size);
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        outputCanvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.WHITE);
        outputCanvas.drawOval(rectF, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        outputCanvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }


    void kullanıcıkontrol() {
        if (getIntent().getBooleanExtra("tekseferlikmi", false)) {

            kullaniciadi = "Anonim";
            kullanici_id = getIntent().getStringExtra("id");
            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("kullanicilar");
            DatabaseReference kullaniciRef = mDatabase.child(kullanici_id);

            kullaniciRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // UID'ye ait veri bulunduF
                        Kullanici kullanici = dataSnapshot.getValue(Kullanici.class);

                        if (kullanici != null) {
                            kullaniciadi = kullanici.getIsim()+" "+kullanici.getSoyisim();

                            eposta = kullanici.getEmail();
                            // Kullanıcı verilerini kullanarak istediğiniz işlemleri yapabilirsiniz
                            Log.e("Firebase", "Kullanıcının e-posta adresi: " + eposta);
                            textviewnavigationüst.setText(kullaniciadi);
                            imageviewnavigationust.setImageBitmap(createProfileImage(kullaniciadi));
                            binding.imageButton2.setImageBitmap(createProfileImage(kullaniciadi));
                            textviewnavigationalt.setText(eposta);
                            Log.e("Firebase", "Kullanıcının e-posta adresi: " + kullaniciadi);
                            oturumacikmi=1;
                        }
                    } else {

                        Log.e("Firebase", "UID'ye ait veri bulunamadı.");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Veri okuma işlemi iptal edildi veya hata oluştu
                    Log.e("Firebase", "Veri okunurken hata oluştu: " + databaseError.getMessage());
                }
            });
        } else {
            kullaniciadi = "Anonim";
            FirebaseAuth mAuth2;
            mAuth2 = FirebaseAuth.getInstance();
            FirebaseUser currentUser2 = mAuth2.getCurrentUser();
            if (currentUser2 != null) {
                // Kullanıcı oturum açık ise ana ekrana yönlendir
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("kullanicilar");
                DatabaseReference kullaniciRef = mDatabase.child(currentUser2.getUid());

                kullaniciRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            // UID'ye ait veri bulundu
                            Kullanici kullanici = dataSnapshot.getValue(Kullanici.class);

                            if (kullanici != null) {
                                kullaniciadi = kullanici.getIsim()+" "+kullanici.getSoyisim();
                                eposta = kullanici.getEmail();
                                textviewnavigationüst.setText(kullaniciadi);
                                imageviewnavigationust.setImageBitmap(createProfileImage(kullaniciadi));
                                binding.imageButton2.setImageBitmap(createProfileImage(kullaniciadi));
                                textviewnavigationalt.setText(eposta);
                                oturumacikmi=1;
                                // Kullanıcı verilerini kullanarak istediğiniz işlemleri yapabilirsiniz
                                Log.e("Firebase", "Kullanıcının adi- adresi: " + kullaniciadi);
                                Log.e("Firebase", "Kullanıcının e-posta adresi: " + eposta);
                            }
                        } else {
                            // UID'ye ait veri bulunamadı
                            Log.e("Firebase", "UID'ye ait veri bulunamadı.");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Veri okuma işlemi iptal edildi veya hata oluştu
                        Log.e("Firebase", "Veri okunurken hata oluştu: " + databaseError.getMessage());
                    }
                });
            } else {
                kullaniciadi = "Giriş Yap";
oturumacikmi=0;

                textviewnavigationüst.setText(kullaniciadi);


            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        oyungit();
    }

    void tamekran() {
        View decoorView = getWindow().getDecorView();
        int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decoorView.setSystemUiVisibility(flags);
    }
}