package com.example.saraglattstein.hangman;

import android.app.Fragment;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by saraglattstein on 3/1/18.
 */

//this fragment contains the hangman display and letters
public class fragment_3 extends Fragment implements View.OnClickListener {
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;
    private TextView tv_5;

    private TextView tv_lives;

    private ImageView img_gallows;
    private ImageView img_head;
    private ImageView img_body;
    private ImageView img_arm1;
    private ImageView img_arm2;
    private ImageView img_leg1;
    private ImageView img_leg2;

    private ImageView[] hangman;
    private Button btn_new;
    private TextView[] letters;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //setUpFragmentGUI( container );
        View fragmentView = inflater.inflate(R.layout.fragment_3, container, false);

        tv_1 = fragmentView.findViewById(R.id.tv_1);
        tv_2 = fragmentView.findViewById(R.id.tv_2);
        tv_3 = fragmentView.findViewById(R.id.tv_3);
        tv_4 = fragmentView.findViewById(R.id.tv_4);
        tv_5 = fragmentView.findViewById(R.id.tv_5);

        tv_lives = fragmentView.findViewById(R.id.tv_lives);

        btn_new = fragmentView.findViewById(R.id.btn_new);

        img_head = fragmentView.findViewById(R.id.img_head);
        img_body = fragmentView.findViewById(R.id.img_body);
        img_arm1 = fragmentView.findViewById(R.id.img_arm1);
        img_arm2 = fragmentView.findViewById(R.id.img_arm2);
        img_leg1 = fragmentView.findViewById(R.id.img_leg1);
        img_leg2 = fragmentView.findViewById(R.id.img_leg2);

        hangman = new ImageView[]{img_head, img_body, img_arm1, img_arm2, img_leg1, img_leg2};
        letters = new TextView[]{tv_1, tv_2, tv_3, tv_4, tv_5};

        btn_new.setTag(100);
        btn_new.setOnClickListener(this);

        return fragmentView;
    }

    @Override
    public void onClick(View view) {
        //only used for new game button
        int tag = (Integer) view.getTag();
        MainActivity act = (MainActivity) getActivity();

        switch( tag ) {
            case(100):
                //send new game action to Main
                Toast.makeText(act, "starting new game...", Toast.LENGTH_SHORT).show();
                Intent intent = act.getIntent();
                act.finish();
                startActivity(intent);
        }
    }

    public void setUpFragmentGUI( ViewGroup container ) {
        if( btn_new == null ) {
            btn_new = new Button( getActivity() );
            container.addView( btn_new );
        }
        if( tv_1 == null ) {
            tv_1 = new TextView( getActivity() );
            container.addView( tv_1 );
        }
        if( tv_2 == null ) {
            tv_2 = new TextView( getActivity() );
            container.addView( tv_2 );
        }
        if( tv_3 == null ) {
            tv_3 = new TextView( getActivity() );
            container.addView( tv_3 );
        }
        if( tv_4 == null ) {
            tv_4 = new TextView( getActivity() );
            container.addView( tv_4 );
        }
        if( tv_5 == null ) {
            tv_5 = new TextView( getActivity() );
            container.addView( tv_5 );
        }
        if( img_arm1 == null ) {
            img_arm1 = new ImageView( getActivity() );
            container.addView( img_arm1 );
        }
        if( img_arm2 == null ) {
            img_arm2 = new ImageView( getActivity() );
            container.addView( img_arm2 );
        }
        if( img_body == null ) {
            img_body = new ImageView( getActivity() );
            container.addView( img_body );
        }
        if( img_head == null ) {
            img_head = new ImageView( getActivity() );
            container.addView( img_head );
        }
        if( img_leg1 == null ) {
            img_leg1 = new ImageView( getActivity() );
            container.addView( img_leg1 );
        }
        if( img_leg2 == null ) {
            img_leg2 = new ImageView( getActivity() );
            container.addView( img_leg2 );
        }

    }

    public void onStart() {
        Log.e("Testing", "Starting fragment 3");
        super.onStart();
        View fragmentView = getView();
        MainActivity act = (MainActivity) getActivity();

        //if four, show first four only
        if(act.getHang().getLength() == 4) {
            tv_5.setVisibility(View.INVISIBLE);
        }
        //otherwise show them all
    }

    public void lostLife(int life) {
        Log.e("Testing", "On life: " + (life-1));
        hangman[6-life].setVisibility(View.VISIBLE);
        setLives(life-1);
    }

    //unsure if this method will be needed or not if on restart, onStart is always called
    public void setHide() {
        Log.e("Testing", "Only 4 places need to be shown");
        tv_5.setVisibility(View.INVISIBLE);
    }

    public void showLetter(char c, List indices) {
        Log.e("Testing", indices.toString());
        for(int i = 0; i < indices.size(); i++ ) {
            for(int k = 0; k < 5; k++ ) {
                if (indices.get(i).equals(k)) {
                    letters[k].setText(Character.toString(c));
                }
            }
        }
    }

    public void setLives(int current) {
        tv_lives.setText(Integer.toString(current));
    }
}
