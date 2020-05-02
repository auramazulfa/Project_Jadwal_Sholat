package com.kelompok4.jadwalsholatfix.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kelompok4.jadwalsholatfix.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KeluhanFragment extends Fragment {

    public KeluhanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_keluhan, container, false);
    }
}
