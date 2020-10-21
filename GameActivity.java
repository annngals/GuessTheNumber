package com.example.guessthenumber;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    TextView questionText;
    int min, max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        questionText = (TextView) findViewById(R.id.text_g);
        Intent i = getIntent();
        String minStr = i.getStringExtra("min");
        String maxStr = i.getStringExtra("max");
        min = Integer.parseInt(minStr);
        max = Integer.parseInt(maxStr);

        Log.d("my", "min = " + minStr + " max = "+maxStr);
        questionText.setText("Guessing the number from " + minStr + " to "+ maxStr + "\nIs your number bigger than " + (max-min)/2 + "?");

    }

    public void onYesNoClick(View v)
    {
        if (v.getId() == R.id.yes)
        {
            min = (max+min)/2;
            Intent i = getIntent();
            String minStr = i.getStringExtra("min");
            String maxStr = i.getStringExtra("max");
            questionText.setText("Guessing the number from " + minStr + " to "+ maxStr + "\nIs your number bigger than " + (max+min)/2 + "?");
        }
        if (v.getId() == R.id.no)
        {
            max = (max-min)/2;
            Intent i = getIntent();
            String minStr = i.getStringExtra("min");
            String maxStr = i.getStringExtra("max");
            questionText.setText("Guessing the number from " + minStr + " to "+ maxStr + "\nIs your number bigger than " + (max-min)/2 + "?");
        }
    }
}
