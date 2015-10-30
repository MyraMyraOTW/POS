package com.example.myriad.pos;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Cashier extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rd = inflater.inflate(R.layout.fragment_cashier, container, false);

        rd.findViewById(R.id.b1).setOnClickListener(handlenumbers);
        rd.findViewById(R.id.b2).setOnClickListener(handlenumbers);
        rd.findViewById(R.id.b3).setOnClickListener(handlenumbers);
        rd.findViewById(R.id.b4).setOnClickListener(handlenumbers);
        rd.findViewById(R.id.b5).setOnClickListener(handlenumbers);
        rd.findViewById(R.id.b6).setOnClickListener(handlenumbers);
        rd.findViewById(R.id.b7).setOnClickListener(handlenumbers);
        rd.findViewById(R.id.b8).setOnClickListener(handlenumbers);
        rd.findViewById(R.id.b9).setOnClickListener(handlenumbers);
        rd.findViewById(R.id.b0).setOnClickListener(handlenumbers);
        rd.findViewById(R.id.b00).setOnClickListener(handlenumbers);
        rd.findViewById(R.id.bdot).setOnClickListener(handlenumbers);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cashier, container, false);
    }

    private View.OnClickListener handlenumbers = new View.OnClickListener() {
        public void onClick(View rd) {
            Button std = (Button)rd;
            String temp = std.getText().toString();
            ((MainActivity) getActivity()).appendText(temp);

        }
    };

    private View.OnClickListener handlespecial = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){

            }
        }
    };

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String string);
    }
}