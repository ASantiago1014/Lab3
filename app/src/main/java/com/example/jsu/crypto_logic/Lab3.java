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

    private ArrayList secretWords;

    private String secretWord;

    private ArrayList<String> splitWord;

    private int index;

    private ArrayList<String> wordSplitBeforeShuffle;

    private String shuffledWord;


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

        w.setText("Try to guess the secret word, one letter at a time!");

        secretWords = new ArrayList(Arrays.asList("APPLE", "BANANA", "CHERRY"));

        int randomInt = (int)(Math.random() * 3 + 1);

        secretWord = String.valueOf(secretWords.get(randomInt));

        shuffledWord = "";

        splitWord = new ArrayList(Arrays.asList(secretWord.split("")));

        wordSplitBeforeShuffle = new ArrayList(Arrays.asList(secretWord.split("")));

        Collections.shuffle(splitWord);

        for (String c : splitWord)
            shuffledWord += c;

        setShuffledWordText(shuffledWord);


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lab3, menu);
        return true;
    }


    public void setShuffledWordText(String s) {

        TextView sw = (TextView) findViewById(R.id.scrambledWord);

        sw.setText(s);
    }

    public void enterButtonClicked(View v) {

        TextView gl = findViewById(R.id.guessLetter);

        TextView uw = findViewById(R.id.unscrambledWord);

        TextView gc = findViewById(R.id.incorrectGuessCounter);

        String guess = gl.getText().toString();

        if (guess.length() > 1) {

            gl.setText("");

        }

        else {

            if (guess.equalsIgnoreCase(wordSplitBeforeShuffle.get(index))) {

                String partialWord = uw.getText().toString();

                uw.setText((partialWord + guess).toUpperCase());

                gl.setText("");

                index++;

            }

            else {

                gl.setText("");

                incorrectGuesses++;
            }

        }

        if (index == splitWord.size())
            gc.setText("You had " + incorrectGuesses + " incorrect guesses!");



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
