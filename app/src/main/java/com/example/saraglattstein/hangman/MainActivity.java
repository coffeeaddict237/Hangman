package com.example.saraglattstein.hangman;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;
    private TextView tv_5;

    private ImageView img_gallows;
    private ImageView img_head;
    private ImageView img_body;
    private ImageView img_arm1;
    private ImageView img_arm2;
    private ImageView img_leg1;
    private ImageView img_leg2;

    private Button btn_new;
    private Button btn_finish;

    private Button btn_a;
    private Button btn_b;
    private Button btn_c;
    private Button btn_d;
    private Button btn_e;
    private Button btn_f;
    private Button btn_g;
    //all the rest...

    public String hint; //topic
    public String answer; //word to be guessed
    public int places; //number letters in word
    private NewGame hang;
    private int current = 0; //correct letters guessed
    private int lives = 7; //head, body, arm, arm, leg, leg(dead)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        tv_3 = findViewById(R.id.tv_3);
        tv_4 = findViewById(R.id.tv_4);
        tv_5 = findViewById(R.id.tv_5);

        img_gallows = findViewById(R.id.img_gallows);
        img_head = findViewById(R.id.img_head);
        img_body = findViewById(R.id.img_body);
        img_arm1 = findViewById(R.id.img_arm1);
        img_arm2 = findViewById(R.id.img_arm2);
        img_leg1 = findViewById(R.id.img_leg1);
        img_leg2 = findViewById(R.id.img_leg2);

        btn_new = findViewById(R.id.btn_new);
        btn_finish = findViewById(R.id.btn_finish);

        btn_a = findViewById(R.id.btn_a);
        btn_b = findViewById(R.id.btn_b);
        btn_c = findViewById(R.id.btn_c);
        btn_d = findViewById(R.id.btn_d);
        btn_e = findViewById(R.id.btn_e);
        btn_f = findViewById(R.id.btn_f);
        btn_g = findViewById(R.id.btn_g);
        //all the rest...


        hang = new NewGame();
        hint = hang.getHint();
        answer = hang.getAnswer();
        places = hang.getLength();

        //if four, show first four
        if(places == 4) {
            tv_5.setVisibility(View.INVISIBLE);
        }
        //otherwise show them all

        //set tag for new game btn
        btn_new.setTag(100);

        //set tags for keys a -> z to be 1 -> 26
        btn_a.setTag(1);
        btn_b.setTag(2);
        btn_c.setTag(3);
        btn_d.setTag(4);
        btn_e.setTag(5);
        btn_f.setTag(6);
        btn_g.setTag(7);

        //all the rest...


        //need on key listener for letter input
        View.OnClickListener textListener = new View.OnClickListener() {
            public void onClick(View view) {
                char in = 'a'; //default
                int tag = (Integer) view.getTag();
                Button choice = btn_a;

                switch (tag) { //disable button after it is pressed

                    case(0): //button has already been pressed, do nothing

                    case(1):
                        in = 'a';
                        choice = btn_a;
                        break;
                    case(2):
                        in = 'b';
                        choice = btn_b;
                        break;
                    case(3):
                        in = 'c';
                        choice = btn_c;
                        break;
                    case(4):
                        in = 'd';
                        choice = btn_d;
                        break;
                    case(5):
                        in = 'e';
                        choice = btn_e;
                        break;
                    case(6):
                        in = 'f';
                        choice = btn_f;
                        break;
                    case(7):
                        in = 'g';
                        choice = btn_g;
                        break;

                        //all the rest...

                    case(100): //start a new game
                        Toast.makeText(MainActivity.this, "starting new game...", Toast.LENGTH_SHORT).show();

                }
                choice.setBackgroundColor(Color.DKGRAY);
                choice.setTag(0);

                boolean correct = hang.guess(in);
                if(correct) { //find indices of guessed char and show in view, possible that game will end in win
                    Toast.makeText(MainActivity.this, "CORRECT!", Toast.LENGTH_SHORT).show();

                    List indices = hang.getIndex(in);
                    current += indices.size();

                    for(int i = 0; i < indices.size(); i++) {
                        if(indices.get(i).toString().equals("1") ) {
                            tv_1.setText(in);
                        }
                        else if(indices.get(i).toString().equals("2") ) {
                            tv_2.setText(in);
                        }
                        else if(indices.get(i).toString().equals("3") ) {
                            tv_3.setText(in);
                        }
                        else if(indices.get(i).toString().equals("4") ) {
                            tv_4.setText(in);
                        }
                        else { //index is 5
                            tv_5.setText(in);
                        }
                    }

                    if(current == places) { //game is over, user has won, start new game
                        Toast.makeText(MainActivity.this, "YOU WON!", Toast.LENGTH_SHORT).show();
                        btn_finish.setVisibility(View.VISIBLE);
                    }
                }
                else { //show another body part, possible that game will end if on last life
                    Toast.makeText(MainActivity.this, "incorrect", Toast.LENGTH_SHORT).show();
                    lives --;
                    if(lives == 6) {
                        img_head.setVisibility(View.VISIBLE);
                    }
                    else if(lives == 5) {
                        img_body.setVisibility(View.VISIBLE);
                    }
                    else if(lives == 4) {
                        img_body.setVisibility(View.VISIBLE);
                    }
                    else if(lives == 3) {
                        img_arm1.setVisibility(View.VISIBLE);
                    }
                    else if(lives == 2) {
                        img_arm2.setVisibility(View.VISIBLE);
                    }
                    else if(lives == 1) {
                        img_leg1.setVisibility(View.VISIBLE);
                    }
                    else if(lives == 0) { //user has lost, start new game
                        img_leg2.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "you've been hanged", Toast.LENGTH_SHORT).show();
                        btn_finish.setTag("try again?");
                        btn_finish.setVisibility(View.VISIBLE);
                        btn_finish.setTag(100);
                    }
                }


            }
        };
        btn_new.setOnClickListener(textListener);

        btn_a.setOnClickListener(textListener);
        btn_b.setOnClickListener(textListener);
        btn_c.setOnClickListener(textListener);
        btn_d.setOnClickListener(textListener);
        btn_e.setOnClickListener(textListener);
        btn_f.setOnClickListener(textListener);
        btn_g.setOnClickListener(textListener);
        //all the rest...
    }
}
