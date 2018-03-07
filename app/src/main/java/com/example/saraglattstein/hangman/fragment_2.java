package com.example.saraglattstein.hangman;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by saraglattstein on 3/1/18.
 */

//this fragment contains hint
public class fragment_2 extends Fragment {
    private TextView tv_hint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //setUpFragmentGUI(container);
        View fragmentView = inflater.inflate(R.layout.fragment_2, container, false);
        tv_hint = fragmentView.findViewById(R.id.tv_hint);
        return fragmentView;
    }

    public void setUpFragmentGUI( ViewGroup container ) {
        if (tv_hint == null) {
            tv_hint = new TextView(getActivity());
            container.addView( tv_hint );
        }
    }

    public void onStart() {
        Log.e("Testing", "Starting fragment 2");
        super.onStart();

        MainActivity act = (MainActivity) getActivity();

        tv_hint.setText( act.getHang().getHint());
    }

    //unsure if needed
    public void setHint(String hint) {
        tv_hint.setText(hint);
    }
}
