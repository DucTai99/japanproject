package com.example.japan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Home extends Fragment {
    private LinearLayout linearLayout;
    private CardView card_basic1, card_basic2, card_food, card_sport, card_family, card_color;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        //
        card_basic1 = view.findViewById(R.id.basic1_course);
        card_basic2 = view.findViewById(R.id.basic2_course);
        card_food = view.findViewById(R.id.food_course);
        card_sport = view.findViewById(R.id.sport_course);
        card_family = view.findViewById(R.id.family_course);
        card_color = view.findViewById(R.id.color_course);

        card_basic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();

            }
        });

        card_basic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        card_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        card_sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        card_family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        card_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        return view;
    }
    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Cấp độ cơ bản1").setNegativeButton("BẮT ĐẦU", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(getActivity(), SplashScreenStartCourse.class);
                startActivity(intent);

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(R.color.dark);
        alertDialog.show();
        alertDialog.getWindow().setLayout(1000,350);
        //
        Button button = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        button.setMinWidth(1000);
        button.setBackgroundResource(R.drawable.button_design);

    }



}