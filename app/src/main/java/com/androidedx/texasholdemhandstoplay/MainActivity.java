package com.androidedx.texasholdemhandstoplay;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener{

    public Spinner spinner1;
    public Spinner spinner2;
    public Spinner spinner3;
    public int index1;
    public static String play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //num1
        spinner1 = (Spinner) findViewById(R.id.card1);
        //num2
        spinner2 = (Spinner) findViewById(R.id.card2);
        //num3
        spinner3 = (Spinner) findViewById(R.id.suit);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.cards_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.suits_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        spinner2.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        spinner3.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        //num1
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);
        //num2
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(this);
        //num3
        spinner3.setAdapter(adapter2);
        spinner3.setOnItemSelectedListener(this);

    }

    public void sendMessage(View view) {

        calculate();
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(play,play);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //nothing
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        play = "Please select your cards";
    }

    private int getIndex(Spinner spinner, String myString) {
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)) {
                return i;
            }
        }
        return -1;
    }

    /*@Override
    public void onClick(View v){
        calculate();
        display();
    }*/

    public void calculate(){
        String card1Val = spinner1.getSelectedItem().toString();
        String card2Val = spinner2.getSelectedItem().toString();
        String suitVal = spinner3.getSelectedItem().toString();
        if(suitVal.equals("Same Suit") && !card1Val.equals(card2Val)){
            if(formula("A","K")||
                    formula("A","Q")||
                    formula("A","J")||
                    formula("A","10")||
                    formula("K","Q")||
                    formula("K","J")||
                    formula("K","10")||
                    formula("Q","J")||
                    formula("Q","10")||
                    formula("J","10")||
                    formula("J","9")||
                    formula("10","9")){
                    play = "Playable in all positions!";
            }

            else if(formula("A","9")||
                    formula("A","8")||
                    formula("A","7")||
                    formula("A","6")||
                    formula("K","9")||
                    formula("Q","9")||
                    formula("Q","8")||
                    formula("J","8")||
                    formula("10","8")||
                    formula("9","8")){
                    play = "Playable in middle/late positions!";
            }

            else if(formula("A","5")||
                    formula("A","4")||
                    formula("A","3")||
                    formula("A","2")||
                    formula("K","8")||
                    formula("K","7")||
                    formula("K","6")||
                    formula("K","5")||
                    formula("K","4")||
                    formula("K","3")||
                    formula("K","2")||
                    formula("J","7")||
                    formula("10","7")||
                    formula("9","7")||
                    formula("9","6")||
                    formula("8","7")||
                    formula("8","6")||
                    formula("7","6")||
                    formula("7","5")||
                    formula("6","5")||
                    formula("5","4")){
                    play = "Only playable in late positions!";
            }
            else{
                play = "Should never be played!";
            }
        }
        else if(suitVal.equals("Different Suit") && !card1Val.equals(card2Val)){
            if(formula("A","K")||
                    formula("A","Q")||
                    formula("A","J")||
                    formula("A","10")||
                    formula("K","Q")||
                    formula("K","J")){
                play = "Playable in all positions!";
            }

            else if(formula("K","10")||
                    formula("Q","J")||
                    formula("Q","10")||
                    formula("J","10")){
                play = "Playable in middle/late positions!";
            }

            else if(formula("A","9")||
                    formula("A","8")||
                    formula("A","7")||
                    formula("K","9")||
                    formula("Q","9")||
                    formula("J","9")||
                    formula("J","8")||
                    formula("10","9")||
                    formula("10","8")||
                    formula("9","8")||
                    formula("9","7")||
                    formula("8","7")){
                play = "Only playable in late positions!";
            }
            else{
                play = "Should never be played!";
            }

        }

        else if(card1Val.equals(card2Val) && suitVal.equals("Different Suit")){
            if(formula("A","A")||
                    formula("K","K") ||
                    formula("Q","Q")||
                    formula("J","J")||
                    formula("10","10")||
                    formula("9","9")||
                    formula("8","8")||
                    formula("7","7")){
                play = "Playable in all positions!";
            }

            else if(formula("6","6")||
                    formula("5","5")){
                play = "Playable in middle/late positions!";
            }

            else if(formula("4","4")||
                    formula("3","3") ||
                    formula("2","2")){
                play = "Only playable in late positions!";
            }

        }

        else if(card1Val.equals(card2Val) && suitVal.equals("Same Suit")){
            play = "Error! Pairs must be different suits. Please try again.";
        }

        else{
            play = "Error! Please try again";
        }

    }

    public boolean formula(String c1, String c2){
        String card1Val = spinner1.getSelectedItem().toString();
        String card2Val = spinner2.getSelectedItem().toString();
        if((card1Val.equals(c1) && card2Val.equals(c2)) || (card1Val.equals(c2) && card2Val.equals(c1))){
            return true;
        }
        else{
            return false;
        }
    }





}

