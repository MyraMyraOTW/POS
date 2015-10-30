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

    private OnFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().findViewById(R.id.b1).setOnClickListener(handler);
        getActivity().findViewById(R.id.b2).setOnClickListener(handler);
        getActivity().findViewById(R.id.b3).setOnClickListener(handler);
        getActivity().findViewById(R.id.b4).setOnClickListener(handler);
        getActivity().findViewById(R.id.b5).setOnClickListener(handler);
        getActivity().findViewById(R.id.b6).setOnClickListener(handler);
        getActivity().findViewById(R.id.b7).setOnClickListener(handler);
        getActivity().findViewById(R.id.b8).setOnClickListener(handler);
        getActivity().findViewById(R.id.b9).setOnClickListener(handler);
        getActivity().findViewById(R.id.b0).setOnClickListener(handler);
        getActivity().findViewById(R.id.b00).setOnClickListener(handler);
        getActivity().findViewById(R.id.bdot).setOnClickListener(handler);

        getActivity().findViewById(R.id.clear).setOnClickListener(handlespecial);
        getActivity().findViewById(R.id.groc_b).setOnClickListener(handlespecial);
        getActivity().findViewById(R.id.auto_b).setOnClickListener(handlespecial);
        getActivity().findViewById(R.id.general_b).setOnClickListener(handlespecial);
        getActivity().findViewById(R.id.gst_b).setOnClickListener(handlespecial);
        getActivity().findViewById(R.id.pst_b).setOnClickListener(handlespecial);
        getActivity().findViewById(R.id.total_b).setOnClickListener(handlespecial);


    }

    private View.OnClickListener handler = new View.OnClickListener() {
        public void onClick(View arg0) {
            Button std = (Button)arg0;

            if(mListener != null){
                String temp = std.getText().toString();
                mListener.onFragmentInteraction(temp,0);
            }
        }
    };

    private View.OnClickListener handlespecial = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Button std = (Button)arg0;

            if (mListener != null) {
                String temp = std.getText().toString();
                mListener.onFragmentInteraction(temp,1);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cashier, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String string, int chk);
    }
}