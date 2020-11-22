package com.example.japan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
//
        if (savedInstanceState == null) {
            Fragment fragment_Default = new Home();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment_Default).commit();
        }
    }
//
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment = new Home();
            int id = menuItem.getItemId();
            switch (id) {
                case R.id.homePage:
                    fragment = new Home();
                    break;
                case R.id.handbook:
                    fragment = new Handbook();
                    break;
                case R.id.grammar:
                    fragment = new Grammar();
                    break;
                case R.id.vocabulary:
                    fragment = new Vocabulary();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
    };
    }
