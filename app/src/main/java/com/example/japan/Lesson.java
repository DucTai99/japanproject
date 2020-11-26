package com.example.japan.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.japan.R;
import com.example.japan.adapter.LessonAdapter;

import java.util.ArrayList;

public class Lesson extends AppCompatActivity {

    private RecyclerView lessonRecycler;
    private RecyclerView.LayoutManager layoutRecycler;
    private RecyclerView.Adapter lessonAdapter;
    private ArrayList<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        for(int i = 0; i < 20; i++) {
            listData.add("Text Vocabulary "+i);
        }

        listData = new ArrayList<>();
        lessonRecycler = findViewById(R.id.recycler_lesson);
        lessonRecycler.setHasFixedSize(true);
        layoutRecycler = new LinearLayoutManager(this);
        lessonRecycler.setLayoutManager(layoutRecycler);
        lessonAdapter = new LessonAdapter(listData);
        lessonRecycler.setAdapter(lessonAdapter);
    }
}