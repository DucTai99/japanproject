package com.example.japan;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.japan.adapter.ObjectAdapter;
import com.example.japan.model.ObjectGeneral;

import java.util.ArrayList;

public class Vocabulary extends Fragment {
    private ArrayList<ObjectGeneral> listVocabulary;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_vocabulary, container, false);
        listVocabulary = new ArrayList<>();

        listVocabulary.add(new ObjectGeneral(1, "Bài 1", "abcd"));
        listVocabulary.add(new ObjectGeneral(2, "Bài 2", "abcd"));
        listVocabulary.add(new ObjectGeneral(3, "Bài 3", "abcd"));


        listView = view.findViewById(R.id.list_unit_vocabulary);
        ObjectAdapter objectAdapter = new ObjectAdapter(getContext(), R.layout.row, listVocabulary);
        listView.setAdapter(objectAdapter);
        return view;
    }
}