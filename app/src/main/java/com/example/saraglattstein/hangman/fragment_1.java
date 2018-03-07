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

        //setUpFragmentGUI( container );
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

        btn_a.setOnClickListener(this);
        btn_b.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_d.setOnClickListener(this);
        btn_e.setOnClickListener(this);
        btn_f.setOnClickListener(this);
        btn_g.setOnClickListener(this);
        btn_h.setOnClickListener(this);
        btn_i.setOnClickListener(this);
        btn_j.setOnClickListener(this);
        btn_k.setOnClickListener(this);
        btn_l.setOnClickListener(this);
        btn_m.setOnClickListener(this);
        btn_n.setOnClickListener(this);
        btn_o.setOnClickListener(this);
        btn_p.setOnClickListener(this);
        btn_q.setOnClickListener(this);
        btn_r.setOnClickListener(this);
        btn_s.setOnClickListener(this);
        btn_t.setOnClickListener(this);
        btn_u.setOnClickListener(this);
        btn_v.setOnClickListener(this);
        btn_w.setOnClickListener(this);
        btn_x.setOnClickListener(this);
        btn_y.setOnClickListener(this);
        btn_z.setOnClickListener(this);

        return fragmentView;
    }

    @Override
    public void onClick(View view) {
        MainActivity act = (MainActivity) getActivity();
        NewGame hang = act.getHang();

        char in = '0'; //default
        int tag = (Integer) view.getTag();
        Button choice = btn_a; //default
        boolean correct = false;

        if(tag != 0 && tag < 100) {
            used[tag-1] = 1;
        }

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
        }
        setKey(tag-1);

        //send letter pressed to Main, update lives
        act.play(in);
    }

    public void setUpFragmentGUI( ViewGroup container ) {
        if( btn_a == null ) {
            btn_a = new Button( getActivity() );
            container.addView( btn_a );
        }
        if( btn_b == null ) {
            btn_b = new Button( getActivity() );
            container.addView( btn_b );
        }
        if( btn_c == null ) {
            btn_c = new Button( getActivity() );
            container.addView( btn_c );
        }
        if( btn_d == null ) {
            btn_d = new Button( getActivity() );
            container.addView( btn_d );
        }
        if( btn_e == null ) {
            btn_e = new Button( getActivity() );
            container.addView( btn_e );
        }
        if( btn_f == null ) {
            btn_f = new Button( getActivity() );
            container.addView( btn_f );
        }
        if( btn_g == null ) {
            btn_g = new Button( getActivity() );
            container.addView( btn_g );
        }
        if( btn_h == null ) {
            btn_h = new Button( getActivity() );
            container.addView( btn_h );
        }
        if( btn_i == null ) {
            btn_i = new Button( getActivity() );
            container.addView( btn_i );
        }
        if( btn_j == null ) {
            btn_j = new Button( getActivity() );
            container.addView( btn_j );
        }
        if( btn_k == null ) {
            btn_k = new Button( getActivity() );
            container.addView( btn_k );
        }
        if( btn_l == null ) {
            btn_l = new Button( getActivity() );
            container.addView( btn_l );
        }
        if( btn_m == null ) {
            btn_m = new Button( getActivity() );
            container.addView( btn_m );
        }
        if( btn_n == null ) {
            btn_n = new Button( getActivity() );
            container.addView( btn_n );
        }
        if( btn_o == null ) {
            btn_o = new Button( getActivity() );
            container.addView( btn_o );
        }
        if( btn_p == null ) {
            btn_p = new Button( getActivity() );
            container.addView( btn_p );
        }
        if( btn_q == null ) {
            btn_q = new Button( getActivity() );
            container.addView( btn_q );
        }
        if( btn_r == null ) {
            btn_r = new Button( getActivity() );
            container.addView( btn_r );
        }
        if( btn_s == null ) {
            btn_s = new Button( getActivity() );
            container.addView( btn_s );
        }
        if( btn_t == null ) {
            btn_t = new Button( getActivity() );
            container.addView( btn_t );
        }
        if( btn_u == null ) {
            btn_u = new Button( getActivity() );
            container.addView( btn_u );
        }
        if( btn_v == null ) {
            btn_v = new Button( getActivity() );
            container.addView( btn_v );
        }
        if( btn_w == null ) {
            btn_w = new Button( getActivity() );
            container.addView( btn_w );
        }
        if( btn_x == null ) {
            btn_x = new Button( getActivity() );
            container.addView( btn_x );
        }
        if( btn_y == null ) {
            btn_y = new Button( getActivity() );
            container.addView( btn_y );
        }
        if( btn_z == null ) {
            btn_z = new Button(getActivity());
            container.addView( btn_z );
        }

    }

    @Override
    public void onStart() {
        Log.e("Testing", "Starting fragment 1");
        super.onStart();
        //View fragmentView = getView();

        //MainActivity act = (MainActivity) getActivity();

    }

    public void setKey(int i) {
        Log.e("Testing", "Disabling key " + i);
        keys[i].setEnabled(false);
        keys[i].setBackgroundColor(Color.DKGRAY);
        keys[i].setClickable(false);
    }

    public int[] getUsed() {return used;}
}
