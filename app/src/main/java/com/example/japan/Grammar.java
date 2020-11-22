package com.example.japan;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.japan.adapter.ObjectAdapter;
import com.example.japan.model.GrammarCall;
import com.example.japan.model.ObjectGeneral;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Grammar extends Fragment{
    ListView listView;
    ObjectAdapter adapter;
    List<ObjectGeneral> listGrammar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grammar, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        loadDataBase();
        adapter = new ObjectAdapter(getActivity(),R.layout.row,listGrammar);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showContentGrammar(i);
            }
        });

        return view;
    }


    public void loadDataBase(){
        listGrammar = new ArrayList<ObjectGeneral>();
        listGrammar.add(new ObjectGeneral(1,"Bai 1","qwertyui"));
        listGrammar.add(new ObjectGeneral(2,"Bai 2","qwertyui"));
        listGrammar.add(new ObjectGeneral(3,"Bai 3","qwertyui"));
        listGrammar.add(new ObjectGeneral(4,"Bai 4","qwertyui"));
        listGrammar.add(new ObjectGeneral(5,"Bai 5","qwertyui"));
    }

    public ObjectGeneral findObject(int id){
        loadDataBase();
        for ( ObjectGeneral object:
             listGrammar) {
            if(object.getId() == id){
                return object;
            }
        }
        return null;
    }


    public void showContentGrammar(int id){
        Intent intent = new Intent(getActivity(),ContentGrammar.class);
        Bundle bundle = new Bundle();
        ObjectGeneral objectGeneral = findObject(id);
        Log.d("aaa", objectGeneral.toString());
        bundle.putSerializable("object",objectGeneral);
        intent.putExtra("objectGrammar",bundle);

        startActivity(intent);
    }

}