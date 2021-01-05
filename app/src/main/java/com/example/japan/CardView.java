package com.example.japan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class CardView extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    private Button btn_speak;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview_main);

        btn_speak = findViewById(R.id.speaker);


//   speak japan

//        textToSpeech =new TextToSpeech(this, new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//                if(status == TextToSpeech.SUCCESS) {
//                    int result = textToSpeech.setLanguage(Locale.JAPAN);
//
//                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                        Log.e("erroSpeak","Languges not support");
//                    }else {
//                        btn_speak.setEnabled(true);
//
//                    }
//                }else {
//                    Log.e("erroSpeak","Initialization failed");
//                }
//            }
//        });
//
//        btn_speak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                speakJapan();
//                Log.e("a","Begin");
//                Toast.makeText(getApplicationContext(),"acd",Toast.LENGTH_LONG).show();
//            }
//        });
//
//

    }
    public void speakJapan() {
        String msg ="お兄ちゃん";
        textToSpeech.setPitch(0.6f);
        textToSpeech.setSpeechRate(2);
        textToSpeech.speak(msg,TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    protected void onDestroy() {
        if(textToSpeech != null) {
            textToSpeech.stop();
        }
        super.onDestroy();
    }


}