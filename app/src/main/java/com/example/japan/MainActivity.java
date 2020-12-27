package com.example.japan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        if (savedInstanceState == null) {
            Fragment fragment_Default = new Home();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment_Default).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_search){
            Intent intent = new Intent(MainActivity.this,ContentSearch.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

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
