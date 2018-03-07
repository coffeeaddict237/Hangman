package com.example.saraglattstein.hangman;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by saraglattstein on 3/1/18.
 */

//this fragment contains the keyboard and choose a letter tv
public class fragment_1 extends Fragment implements View.OnClickListener {
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

    private Button[] keys;
    private int[] used = new int[26];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragmentView = inflater.inflate(R.layout.fragment_1, container, false);

        btn_a = fragmentView.findViewById(R.id.btn_a);
        btn_b = fragmentView.findViewById(R.id.btn_b);
        btn_c = fragmentView.findViewById(R.id.btn_c);
        btn_d = fragmentView.findViewById(R.id.btn_d);
        btn_e = fragmentView.findViewById(R.id.btn_e);
        btn_f = fragmentView.findViewById(R.id.btn_f);
        btn_g = fragmentView.findViewById(R.id.btn_g);
        btn_h = fragmentView.findViewById(R.id.btn_h);
        btn_i = fragmentView.findViewById(R.id.btn_i);
        btn_j = fragmentView.findViewById(R.id.btn_j);
        btn_k = fragmentView.findViewById(R.id.btn_k);
        btn_l = fragmentView.findViewById(R.id.btn_l);
        btn_m = fragmentView.findViewById(R.id.btn_m);
        btn_n = fragmentView.findViewById(R.id.btn_n);
        btn_o = fragmentView.findViewById(R.id.btn_o);
        btn_p = fragmentView.findViewById(R.id.btn_p);
        btn_q = fragmentView.findViewById(R.id.btn_q);
        btn_r = fragmentView.findViewById(R.id.btn_r);
        btn_s = fragmentView.findViewById(R.id.btn_s);
        btn_t = fragmentView.findViewById(R.id.btn_t);
        btn_u = fragmentView.findViewById(R.id.btn_u);
        btn_v = fragmentView.findViewById(R.id.btn_v);
        btn_w = fragmentView.findViewById(R.id.btn_w);
        btn_x = fragmentView.findViewById(R.id.btn_x);
        btn_y = fragmentView.findViewById(R.id.btn_y);
        btn_z = fragmentView.findViewById(R.id.btn_z);

        keys = new Button[]{btn_a, btn_b, btn_c, btn_d, btn_e, btn_f, btn_g, btn_h, btn_i, btn_j, btn_k, btn_l, btn_m, btn_n, btn_o, btn_p, btn_q, btn_r, btn_s, btn_t, btn_u, btn_v, btn_w, btn_x, btn_y, btn_z};

        for(int i = 0; i< 26; i++) {
            keys[i].setTag(i+1);
            keys[i].setOnClickListener(this);
        }

        return fragmentView;
    }

    @Override
    public void onClick(View view) {
        MainActivity act = (MainActivity) getActivity();
        int tag = (Integer) view.getTag();

        if(tag != 0 && tag < 100) {
            used[tag-1] = 1;
        }

        char in = keys[tag-1].getText().charAt(0);
        Log.e("Testing", "User guessed: " + in);
        setKey(tag-1);

        //send letter pressed to Main, update lives
        act.play(in);
    }

    @Override
    public void onStart() {
        Log.e("Testing", "Starting fragment 1");
        super.onStart();

    }

    public void setKey(int i) {
        Log.e("Testing", "Disabling key " + i);
        keys[i].setEnabled(false);
        keys[i].setBackgroundColor(Color.DKGRAY);
        keys[i].setClickable(false);
    }
}
