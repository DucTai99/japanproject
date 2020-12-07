package com.example.japan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.japan.adapter.ObjectAdapter;
import com.example.japan.model.ObjectGeneral;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ContentGrammar extends AppCompatActivity {
    TextView textView;
    ObjectGeneral objectGeneral;
    String url = "https://apijapanese.herokuapp.com/api/vocabulary/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_grammar);
        textView = (TextView) findViewById(R.id.textContentGrammar);
        Intent intent = getIntent();
        if(intent != null){
            int idGrammar = intent.getIntExtra("idGrammar",-1);
            url+=idGrammar;
            getData(url);
        }
    }
    private void getData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        textView.setText(response.toString());
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