package com.example.e_softwarica;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.example.e_softwarica.fragment.AboutUsFragment;
import com.example.e_softwarica.fragment.AddStudentFragment;
import com.example.e_softwarica.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enables fullscreen
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.itemhome:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.itemadd:
                            selectedFragment = new AddStudentFragment();
                            break;
                        case R.id.itemus:
                            selectedFragment = new AboutUsFragment();
                            break;
                    }

                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;

                }
            };
}
