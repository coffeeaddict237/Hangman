package com.example.saraglattstein.hangman;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NewGame hang;
    public String hint; //topic
    public String answer; //word to be guessed
    public int places; //number letters in word
    private int current = 0; //correct letters guessed
    private int lives = 6; //head, body, arm, arm, leg, leg(dead)
    private int[] letters = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hang = new NewGame();
        hint = hang.getHint();
        answer = hang.getAnswer();
        places = hang.getLength();

        Log.e("Testing", hint);
        Log.e("Testing", answer);

        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(R.id.frag_1) == null && fm.findFragmentById(R.id.frag_2) == null && fm.findFragmentById(R.id.frag_3) == null) {
            FragmentTransaction trans = fm.beginTransaction();
            fragment_1 frag_1 = new fragment_1();
            fragment_2 frag_2 = new fragment_2();
            fragment_3 frag_3 = new fragment_3();
            trans.add(R.id.frag_1, frag_1);
            trans.add(R.id.frag_2, frag_2);
            trans.add(R.id.frag_3, frag_3);
            trans.commit();
        }

    }

    public NewGame getHang() {
        return hang;
    }

    //takes char user input, check if in word and update accordingly in fragment 3
    public void play(char input) {
        fragment_1 frag_1 = (fragment_1) getFragmentManager().findFragmentById(R.id.frag_1);
        fragment_3 frag_3 = (fragment_3) getFragmentManager().findFragmentById(R.id.frag_3);
        boolean correct = hang.guess(input);

        if(correct) { //if correct, show letter in correct spots and toast to our accomplishments
            Toast.makeText(MainActivity.this, "CORRECT!", Toast.LENGTH_SHORT).show();
            frag_3.showLetter(input, hang.getIndex(input));
        }
        else { //lost a life, show a limb and toast
            Toast.makeText(MainActivity.this, "incorrect", Toast.LENGTH_SHORT).show();
            frag_3.lostLife(hang.getLives() + 1);
        }

        //check if won/lost
        if(hang.getLives() == 0) {
            Toast.makeText(MainActivity.this, "Sorry, you've been hanged", Toast.LENGTH_SHORT).show();

        }
        if(hang.isWin()) {
            Toast.makeText(MainActivity.this, "You won!!", Toast.LENGTH_SHORT).show();

        }
        if(hang.isWin() || hang.getLives() == 0) { //disable all keys
            for(int i = 0; i < 26; i++ ) {
                frag_1.setKey(i);
            }
        }
    }
}
