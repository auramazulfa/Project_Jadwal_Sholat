package com.kelompok4.jadwalsholatfix.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.kelompok4.jadwalsholatfix.R;
import com.kelompok4.jadwalsholatfix.adapter.KhutbahAdapter;
import com.kelompok4.jadwalsholatfix.model.khutbah.AppDatabase;
import com.kelompok4.jadwalsholatfix.model.khutbah.KhutbahModel;

import java.util.ArrayList;

public class LihatDataKhutbahActivity extends AppCompatActivity {
    private KhutbahAdapter khutbahAdapter;
    private RecyclerView rvKhutbah;
    private AppDatabase appDatabase;
    private ArrayList<KhutbahModel> listKhutbah = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_khutbah);

        rvKhutbah = findViewById(R.id.rv_list_khutbah);
        khutbahAdapter = new KhutbahAdapter(getApplicationContext());
        khutbahAdapter.notifyDataSetChanged();

        if (appDatabase == null) {
            appDatabase = AppDatabase.initDatabase(getApplicationContext());
        }

        listKhutbah.addAll(appDatabase.khutbahDAO().getDataKhutbah());
        khutbahAdapter.setData(listKhutbah);

        rvKhutbah.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvKhutbah.setAdapter(khutbahAdapter);

        khutbahAdapter.setListener(new KhutbahAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getApplicationContext(),LihatDataKhutbahActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onClick1(int position) {
                Intent intent = new Intent(getApplicationContext(), EditKhutbahActivity.class);
                intent.putExtra("khutbah_id", listKhutbah.get(position).getId());
                intent.putExtra("khutbah_waktu", listKhutbah.get(position).getWaktu());
                intent.putExtra("khutbah_khatib", listKhutbah.get(position).getKhatib());
                intent.putExtra("khutbah_isi", listKhutbah.get(position).getKhutbah());
                startActivity(intent);
                finish();
            }
        });
    }
}
