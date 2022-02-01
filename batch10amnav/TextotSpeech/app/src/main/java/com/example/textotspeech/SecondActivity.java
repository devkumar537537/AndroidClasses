package com.example.textotspeech;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Locale;
@SuppressLint("ClickableViewAccessibility")
public class SecondActivity extends AppCompatActivity {
EditText editText;
ImageView imageView;

    private SpeechRecognizer speechRecognizer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bindview();


        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        final  Intent speechintent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechintent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechintent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.getDefault());

speechRecognizer.setRecognitionListener(new RecognitionListener() {
    @Override
    public void onReadyForSpeech(Bundle params) {
        editText.setText("");
        editText.setHint("Listening...");
    }

    @Override
    public void onBeginningOfSpeech() {

    }

    @Override
    public void onRmsChanged(float rmsdB) {

    }

    @Override
    public void onBufferReceived(byte[] buffer) {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onError(int error) {

    }

    @Override
    public void onResults(Bundle results) {
        imageView.setImageResource(R.drawable.mic);

        ArrayList<String> data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        String datatext = data.get(0);
        editText.setHint(data.get(0));

    }

    @Override
    public void onPartialResults(Bundle partialResults) {

    }

    @Override
    public void onEvent(int eventType, Bundle params) {

    }
});

        imageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    speechRecognizer.stopListening();
                }

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    imageView.setImageResource(R.drawable.mic2);
                    speechRecognizer.startListening(speechintent);
                }
                return false;
            }
        });
    }

    private void bindview() {
        editText = findViewById(R.id.convert_to_speectedit);
        imageView = findViewById(R.id.mic_btn);
    }
}