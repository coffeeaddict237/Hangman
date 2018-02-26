package com.example.saraglattstein.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;
    private TextView tv_5;

    private Button btn_new;

    private Button btn_a;
    private Button btn_b;
    //all the rest...

    public String hint;
    public String answer;
    public int places;
    private NewGame hang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        tv_3 = findViewById(R.id.tv_3);
        tv_4 = findViewById(R.id.tv_4);
        tv_5 = findViewById(R.id.tv_5);

        btn_new = findViewById(R.id.btn_new);

        btn_a = findViewById(R.id.btn_a);
        btn_b = findViewById(R.id.btn_b);

        //all the rest...


        hang = new NewGame();
        hint = hang.getHint();
        answer = hang.getAnswer();
        places = hang.getLength();

        //if only three, only show middle three places
        if(places == 3) {
            tv_1.setVisibility(View.INVISIBLE);
            tv_5.setVisibility(View.INVISIBLE);
        }

        //if four, show first four
        else if(places == 4) {
            tv_5.setVisibility(View.INVISIBLE);
        }

        //otherwise show them all


        //set tag for new game
        btn_new.setTag(100);

        //set tags for keys a -> z to be 1 -> 26
        btn_a.setTag(1);
        btn_b.setTag(2);

        //all the rest...


        //need on key listener for letter input
        View.OnClickListener textListener = new View.OnClickListener() {
            public void onClick(View view) {
                char in;
                int tag = (Integer) view.getTag();


                switch (tag) {
                    case(1):
                        in = 'a';
                        break;
                    case(2):
                        in = 'b';
                        break;
                    case(3):
                        in = 'c';
                        break;
                    case(4):
                        in = 'd';
                        break;
                    case(5):
                        in = 'e';
                        break;
                    case(6):
                        in = 'f';
                        break;
                    case(7):
                        in = 'g';
                        break;

                        //all the rest...

                    case(100):
                        //start a new game

                }
                boolean correct = hang.guess(in);
                if(correct) {
                    Toast.makeText(MainActivity.this, "CORRECT!", Toast.LENGTH_SHORT).show();

                    //find indices of guessed char and show in view, possible that game will end in win
                    List indices = hang.getIndex(in);

                    for(int i = 0; i < indices.size(); i++) {
                        if(indices.get(i).toString().equals("1") ) {

                        }
                        else if(indices.get(i).toString().equals("2") ) {

                        }
                        else if(indices.get(i).toString().equals("3") ) {

                        }
                        else if(indices.get(i).toString().equals("4") ) {

                        }
                        else { //index is 5

                        }
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "INCORRECT!", Toast.LENGTH_SHORT).show();

                    //show another body part, possible that game will end if on last life

                }
            }
        };

        btn_new.setOnClickListener(textListener);
    }
}
