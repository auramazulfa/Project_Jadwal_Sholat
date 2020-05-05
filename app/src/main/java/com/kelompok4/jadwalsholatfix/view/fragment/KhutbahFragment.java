package com.kelompok4.jadwalsholatfix.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kelompok4.jadwalsholatfix.R;
import com.kelompok4.jadwalsholatfix.model.khutbah.AppDatabase;
import com.kelompok4.jadwalsholatfix.model.khutbah.KhutbahModel;
import com.kelompok4.jadwalsholatfix.view.activity.LihatDataKhutbahActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class KhutbahFragment extends Fragment {
    private AppDatabase appDatabase;
    private EditText etWaktu, etKhatib, etKhutbah;
    private Button btnSimpan, btnLihat;

    public KhutbahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_khutbah, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etWaktu = view.findViewById(R.id.et_waktu);
        etKhatib = view.findViewById(R.id.et_khatib);
        etKhutbah = view.findViewById(R.id.et_khutbah);
        btnSimpan = view.findViewById(R.id.btn_simpan);
        btnLihat = view.findViewById(R.id.btn_catatan);

        appDatabase = AppDatabase.initDatabase(getContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String inputWaktu = etWaktu.getText().toString().trim();
                    String inputKhutbah = etKhutbah.getText().toString().trim();

                    boolean isEmptyFields = false;

                    if (TextUtils.isEmpty(inputWaktu)) {
                        isEmptyFields = true;
                        etWaktu.setError("Field can't be empty");
                    }

                    if (TextUtils.isEmpty(inputKhutbah)) {
                        isEmptyFields = true;
                        etKhutbah.setError("Field can't be empty");
                    }

                    if (!isEmptyFields) {
                        KhutbahModel khutbahModel = new KhutbahModel();
                        khutbahModel.setWaktu(etWaktu.getText().toString());
                        khutbahModel.setKhatib(etKhatib.getText().toString());
                        khutbahModel.setKhutbah(etKhutbah.getText().toString());

                        appDatabase.khutbahDAO().insertKhutbah(khutbahModel);

                        etWaktu.setText("");
                        etKhatib.setText("");
                        etKhutbah.setText("");

                        Log.d("FragmentKhutbah ", "Sukses");
                        Toast.makeText(getContext(), "Catatan Tersimpan", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Log.e("FragmentKhutbah ", "Gagal Menyimpan , msg : " + e.getMessage());
                    Toast.makeText(getContext(), "Gagal Menyimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LihatDataKhutbahActivity.class);
                startActivity(intent);
            }
        });
    }
}
