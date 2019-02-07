package com.example.jsu.crypto_logic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.*;
import java.util.*;

public class Lab3 extends AppCompatActivity {

    private int incorrectGuesses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView w = (TextView) findViewById(R.id.welcomeMessage);

        w.setText("Welcome to Crypto-Logic! Try to guess the secret word, one letter at a time!");

        ArrayList secretWords = new ArrayList(Arrays.asList("APPLE", "BANANA", "CHERRY"));

        int randomInt = (int)(Math.random() * 3 + 1);

        String secretWord = String.valueOf(secretWords.get(randomInt));

        String shuffledWord = shuffleSecretWord(secretWord);

        setShuffledWordText(shuffledWord);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lab3, menu);
        return true;
    }

    public String shuffleSecretWord(String s) {

        String shuffledWord = "";

        ArrayList<String> splitWord = new ArrayList(Arrays.asList(s.split("")));

        Collections.shuffle(splitWord);

        for (String c : splitWord)
            shuffledWord += c;

        return shuffledWord;
    }

    public void setShuffledWordText(String s) {

        TextView sw = (TextView) findViewById(R.id.scrambledWord);

        sw.setText(s);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
