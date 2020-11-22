package com.example.japan;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.japan.adapter.ObjectAdapter;
import com.example.japan.model.ObjectGeneral;

import java.util.ArrayList;
import java.util.List;

public class Grammar extends Fragment {
    ListView listView;
    ObjectAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("AAA","KO2");
        View view = inflater.inflate(R.layout.fragment_grammar, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
//        listView.findViewById(R.id.listView);
        Log.d("AAA","KO");
        List<ObjectGeneral> listGrammar = new ArrayList<ObjectGeneral>();
        listGrammar.add(new ObjectGeneral(1,"Bai 1","qwertyui"));
        listGrammar.add(new ObjectGeneral(2,"Bai 2","qwertyui"));
        listGrammar.add(new ObjectGeneral(3,"Bai 3","qwertyui"));
        listGrammar.add(new ObjectGeneral(4,"Bai 4","qwertyui"));
        listGrammar.add(new ObjectGeneral(5,"Bai 5","qwertyui"));
        Log.d("AAA",listGrammar.toString());
        adapter = new ObjectAdapter(getActivity(),R.layout.row,listGrammar);
        Log.d("AAA","OKOK");
        listView.setAdapter(adapter);
        return view;
    }
}