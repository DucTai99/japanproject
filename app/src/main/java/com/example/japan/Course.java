package com.example.japan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);


        if(savedInstanceState == null) {
            Fragment fragment = new fragment_home_learn_op1();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_course,fragment).commit();
        }

    }
}