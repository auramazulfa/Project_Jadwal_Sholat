package com.kelompok4.jadwalsholatfix.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kelompok4.jadwalsholatfix.R;
import com.kelompok4.jadwalsholatfix.view.activity.SholatActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SholatFragment extends Fragment {
    Button btnJadwalSholat, btnArahKiblat;

    public SholatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sholat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnJadwalSholat = view.findViewById(R.id.btn_jadwal_sholat);
        btnJadwalSholat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SholatActivity.class);
                startActivity(intent);
            }
        });
    }
}
