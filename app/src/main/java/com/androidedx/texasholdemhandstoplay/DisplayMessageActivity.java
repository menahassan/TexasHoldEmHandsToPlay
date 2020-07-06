package com.androidedx.texasholdemhandstoplay;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayMessageActivity extends MainActivity {

    TextView textView;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.play);

        textView = findViewById(R.id.textView1);
        tv = findViewById(R.id.textView2);
        // Create the text view
        textView = new TextView(this);
        textView.setTextSize(40);
        textView.setPadding(5,5,5,0);
        if(message.contains("positions")){
            textView.setText(message + "\n" + "\n" + "*position = a player's seating order in a round" );
        }
        else{
            textView.setText(message);
        }
        textView.setBackgroundResource(R.drawable.pokerfelt);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        // Set the text view as the activity layout
        setContentView(textView);
    }
}