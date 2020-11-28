package com.example.japan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.AnimatorSet;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.japan.R;
import com.example.japan.adapter.LessonAdapter;

import java.util.ArrayList;

public class Lesson extends AppCompatActivity {
    AnimatorSet front_ani;
    AnimatorSet back_ani;
    private RecyclerView lessonRecycler;
    private RecyclerView.LayoutManager layoutRecycler;
    private RecyclerView.Adapter lessonAdapter;
    private ArrayList<String> listData;
    private LinearLayout card_front, card_back;
    private boolean isBackShow = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

       card_front = findViewById(R.id.layout_front);
       card_back = findViewById(R.id.layout_back);

        listData = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            listData.add("Text Vocabulary "+i);
        }

        lessonRecycler = findViewById(R.id.recycler_lesson);
        lessonRecycler.setHasFixedSize(true);
        layoutRecycler = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        lessonRecycler.setLayoutManager(layoutRecycler);
        lessonAdapter = new LessonAdapter(listData);
        lessonRecycler.setAdapter(lessonAdapter);

    }
}