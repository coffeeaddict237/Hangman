package com.example.saraglattstein.hangman;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private Button btn_h;
    private Button btn_i;
    private Button btn_j;
    private Button btn_k;
    private Button btn_l;
    private Button btn_m;
    private Button btn_n;
    private Button btn_o;
    private Button btn_p;
    private Button btn_q;
    private Button btn_r;
    private Button btn_s;
    private Button btn_t;
    private Button btn_u;
    private Button btn_v;
    private Button btn_w;
    private Button btn_x;
    private Button btn_y;
    private Button btn_z;

    public String hint; //topic
    public String answer; //word to be guessed
    public int places; //number letters in word
    private NewGame hang;
    private int current = 0; //correct letters guessed
    private int lives = 6; //head, body, arm, arm, leg, leg(dead)

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
        btn_h = findViewById(R.id.btn_h);
        btn_i = findViewById(R.id.btn_i);
        btn_j = findViewById(R.id.btn_j);
        btn_k = findViewById(R.id.btn_k);
        btn_l = findViewById(R.id.btn_l);
        btn_m = findViewById(R.id.btn_m);
        btn_n = findViewById(R.id.btn_n);
        btn_o = findViewById(R.id.btn_o);
        btn_p = findViewById(R.id.btn_p);
        btn_q = findViewById(R.id.btn_q);
        btn_r = findViewById(R.id.btn_r);
        btn_s = findViewById(R.id.btn_s);
        btn_t = findViewById(R.id.btn_t);
        btn_u = findViewById(R.id.btn_u);
        btn_v = findViewById(R.id.btn_v);
        btn_w = findViewById(R.id.btn_w);
        btn_x = findViewById(R.id.btn_x);
        btn_y = findViewById(R.id.btn_y);
        btn_z = findViewById(R.id.btn_z);

        hang = new NewGame();
        hint = hang.getHint();
        answer = hang.getAnswer();
        places = hang.getLength();

        //if four, show first four only
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
        btn_h.setTag(8);
        btn_i.setTag(9);
        btn_j.setTag(10);
        btn_k.setTag(11);
        btn_l.setTag(12);
        btn_m.setTag(13);
        btn_n.setTag(14);
        btn_o.setTag(15);
        btn_p.setTag(16);
        btn_q.setTag(17);
        btn_r.setTag(18);
        btn_s.setTag(19);
        btn_t.setTag(20);
        btn_u.setTag(21);
        btn_v.setTag(22);
        btn_w.setTag(23);
        btn_x.setTag(24);
        btn_y.setTag(25);
        btn_z.setTag(26);

        //need on key listener for letter input
        View.OnClickListener textListener = new View.OnClickListener() {
            public void onClick(View view) {
                char in = 'a'; //default
                int tag = (Integer) view.getTag();
                Button choice = btn_a; //default

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
                    case(8):
                        in = 'h';
                        choice = btn_h;
                        break;
                    case(9):
                        in = 'i';
                        choice = btn_i;
                        break;
                    case(10):
                        in = 'j';
                        choice = btn_j;
                        break;
                    case(11):
                        in = 'k';
                        choice = btn_k;
                        break;
                    case(12):
                        in = 'l';
                        choice = btn_l;
                        break;
                    case(13):
                        in = 'm';
                        choice = btn_m;
                        break;
                    case(14):
                        in = 'n';
                        choice = btn_n;
                        break;
                    case(15):
                        in = 'o';
                        choice = btn_o;
                        break;
                    case(16):
                        in = 'p';
                        choice = btn_p;
                        break;
                    case(17):
                        in = 'q';
                        choice = btn_q;
                        break;
                    case(18):
                        in = 'r';
                        choice = btn_r;
                        break;
                    case(19):
                        in = 's';
                        choice = btn_s;
                        break;
                    case(20):
                        in = 't';
                        choice = btn_t;
                        break;
                    case(21):
                        in = 'u';
                        choice = btn_u;
                        break;
                    case(22):
                        in = 'v';
                        choice = btn_v;
                        break;
                    case(23):
                        in = 'w';
                        choice = btn_w;
                        break;
                    case(24):
                        in = 'x';
                        choice = btn_x;
                        break;
                    case(25):
                        in = 'y';
                        choice = btn_y;
                        break;
                    case(26):
                        in = 'z';
                        choice = btn_z;
                        break;

                    case(100): //start a new game
                        Toast.makeText(MainActivity.this, "starting new game...", Toast.LENGTH_SHORT).show();
                        finish();
                        recreate();

                }
                choice.setBackgroundColor(Color.DKGRAY);
                choice.setEnabled(false);
                choice.setClickable(false);

                boolean correct = hang.guess(in);
                if(correct) { //find indices of guessed char and show in view, possible that game will end in win
                    Log.e("Testing", "user guessed a correct letter");
                    Toast.makeText(MainActivity.this, "CORRECT!", Toast.LENGTH_SHORT).show();

                    List indices = hang.getIndex(in);
                    current += indices.size();
                    Log.e("Testing", "found at indices: "+ indices);

                    String letter = Character.toString(in);
                    for(int i = 0; i < indices.size(); i++) {
                        if(indices.get(i).toString().equals("0") ) {
                            tv_1.setText(letter);
                        }
                        if(indices.get(i).toString().equals("1") ) {
                            tv_2.setText(letter);
                        }
                        if(indices.get(i).toString().equals("2") ) {
                            tv_3.setText(letter);
                        }
                        if(indices.get(i).toString().equals("3") ) {
                            tv_4.setText(letter);
                        }
                        if(indices.get(i).toString().equals("4")) {
                            tv_5.setText(letter);
                        }
                    }

                    if(current == places) { //game is over, user has won, start new game
                        Toast.makeText(MainActivity.this, "YOU WON!", Toast.LENGTH_SHORT).show();
                        btn_finish.setVisibility(View.VISIBLE);
                        btn_finish.setTag(100);
                    }
                }
                else { //show another body part, possible that game will end if on last life
                    Toast.makeText(MainActivity.this, "incorrect", Toast.LENGTH_SHORT).show();
                    lives --;
                    if(lives == 5) {
                        img_head.setVisibility(View.VISIBLE);
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
        btn_finish.setOnClickListener(textListener);

        btn_a.setOnClickListener(textListener);
        btn_b.setOnClickListener(textListener);
        btn_c.setOnClickListener(textListener);
        btn_d.setOnClickListener(textListener);
        btn_e.setOnClickListener(textListener);
        btn_f.setOnClickListener(textListener);
        btn_g.setOnClickListener(textListener);
        btn_h.setOnClickListener(textListener);
        btn_i.setOnClickListener(textListener);
        btn_j.setOnClickListener(textListener);
        btn_k.setOnClickListener(textListener);
        btn_l.setOnClickListener(textListener);
        btn_m.setOnClickListener(textListener);
        btn_n.setOnClickListener(textListener);
        btn_o.setOnClickListener(textListener);
        btn_p.setOnClickListener(textListener);
        btn_q.setOnClickListener(textListener);
        btn_r.setOnClickListener(textListener);
        btn_s.setOnClickListener(textListener);
        btn_t.setOnClickListener(textListener);
        btn_u.setOnClickListener(textListener);
        btn_v.setOnClickListener(textListener);
        btn_w.setOnClickListener(textListener);
        btn_x.setOnClickListener(textListener);
        btn_y.setOnClickListener(textListener);
        btn_z.setOnClickListener(textListener);

    }
}
