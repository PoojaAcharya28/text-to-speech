package com.example.texttospeech;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText inputText;
    Button hitbutton;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = (EditText)findViewById(R.id.editText);
        hitbutton = (Button)findViewById(R.id.button);

        textToSpeech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    //System.out.println("hello entered if condition");
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }else{
                    Log.e("e", "text to speech engine not initialized.. ");
                }
            }
        });

        hitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = inputText.getText().toString();
                textToSpeech.speak(inputString, TextToSpeech.QUEUE_FLUSH, null);
            }
        });



    }
}