package com.example.japan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.japan.model.ObjectGeneral;

public class ContentGrammar extends AppCompatActivity {
    TextView textView;
    ObjectGeneral objectGeneral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_grammar);
        textView = (TextView) findViewById(R.id.textContentGrammar);
        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getBundleExtra("objectPackageGrammar");
            objectGeneral = (ObjectGeneral) bundle.getSerializable("object");
//            objectGeneral = (ObjectGeneral) getIntent().getParcelableExtra("objectPackageGrammar");
//            objectGeneral = (ObjectGeneral) bundle.getSerializable("objectGrammar");

            textView.setText(objectGeneral.getName());
        }
    }
}