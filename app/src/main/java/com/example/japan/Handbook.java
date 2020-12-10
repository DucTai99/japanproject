package com.example.japan;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.japan.adapter.ObjectAdapter;
import com.example.japan.model.ObjectGeneral;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Handbook extends Fragment {
    SwipeMenuListView listView;
    ObjectAdapter adapter;
    String url = "https://apijapanese.herokuapp.com/api/vocabulary";
    List<ObjectGeneral> listGrammar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_handbook, container, false);
        listView = (SwipeMenuListView) view.findViewById(R.id.listView);
        getDataAndCreateView(url);
        return view;
    }

    public void showContentHandBook(int id){
        Intent intent = new Intent(getActivity(),ContentGrammar.class);
        intent.putExtra("idGrammar",id);
        startActivity(intent);
    }
    private void getDataAndCreateView(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        listGrammar = new ArrayList<ObjectGeneral>();
                        for (int i = 0; i < response.length();i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                listGrammar.add(new ObjectGeneral(jsonObject.getInt("id"),jsonObject.getString("name"),""));
                            }
                            catch (JSONException ex){
                                ex.printStackTrace();
                            }
                        }
                        adapter = new ObjectAdapter(getActivity(),R.layout.row,listGrammar);
                        listView.setAdapter(adapter);
                        SwipeMenuCreator creator = new SwipeMenuCreator() {

                            @Override
                            public void create(SwipeMenu menu) {
                                // create "delete" item
                                SwipeMenuItem deleteItem = new SwipeMenuItem(getContext());
                                // set item background
                                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                                        0x3F, 0x25)));
                                // set item width
                                deleteItem.setWidth(100);
                                // set a icon
                                deleteItem.setIcon(R.drawable.ic_delete);
                                // add to menu
                                menu.addMenuItem(deleteItem);

                                // create "edit" item
                                SwipeMenuItem openItem = new SwipeMenuItem(getContext());
                                // set item background
                                openItem.setBackground(new ColorDrawable(Color.rgb(0x00, 0x66,
                                        0xff)));
                                // set item width
                                openItem.setWidth(100);
                                // set a icon
                                openItem.setIcon(R.drawable.ic_edit);
                                // add to menu
                                menu.addMenuItem(openItem);
                            }
                        };

                        listView.setMenuCreator(creator);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                showContentHandBook(i+1);
                            }
                        });

                        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                                switch (index) {
                                    case 0:
                                        Log.d("AAAA",position+" delete");
                                        break;
                                    case 1:
                                        Log.d("AAAA",position+" edit");
                                        break;
                                }
                                // false : close the menu; true : not close the menu
                                return false;
                            }
                        });

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("AAAA","loi r");
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }
}