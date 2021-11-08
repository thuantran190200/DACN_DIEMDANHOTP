package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        frament_home frament_home= new frament_home();

        loadFragment(frament_home);
        bottomNavigationView = findViewById(R.id.nav_menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()){
                    case R.id.homeid:
                        loadFragment(frament_home);
                        return true;

                    case R.id.session:
                        fragment = new sesion0();
                        loadFragment(fragment);
                        return true;

                    case R.id.search:
                        fragment = new fragment_session();
                        loadFragment(fragment);
                        return true;
                    /*case R.id.nav_giaohang:
                        fragment = new Giaohang();
                        loadFragment(fragment);
                        return true;

                    case R.id.nav_thongtin:
                        fragment = new Toi();
                        loadFragment(fragment);
                        return true;*/
                }
                return false;
            }
        });







    }





    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.continer,fragment);
        fragmentTransaction.commit();
    }
}