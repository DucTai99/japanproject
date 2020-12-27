package com.example.japan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.japan.databse.DatabaseManager;
import com.example.japan.model.VocabularyHandBook;

import java.util.ArrayList;

public class ContentHandbook extends AppCompatActivity {
    DatabaseManager databaseManager;
    ArrayList<VocabularyHandBook> vocabularyHandBooks;
    int idHandBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_handbook);
        databaseManager = new DatabaseManager(this);
        Intent intent = getIntent();
        if(intent != null){
            idHandBook = intent.getIntExtra("idHandBook",-1);
            loadData();
            vocabularyHandBooks = databaseManager.getListDataVocabularyByIdHandBook(idHandBook);
            System.out.println(vocabularyHandBooks.size());
        }
    }

    public void loadData(){
        databaseManager.insertRowContentHandBook("a","b","c","27/12/2020",idHandBook);
    }
}