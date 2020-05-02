package com.kelompok4.jadwalsholatfix.service;

import com.kelompok4.jadwalsholatfix.model.sholat.jadwalsholat.JadwalSholatResponse;
import com.kelompok4.jadwalsholatfix.model.sholat.listkota.KotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SholatRepository {
    @GET("/sholat/format/json/kota")
    Call<KotaResponse> getListCity();

    @GET("/sholat/format/json/jadwal/kota/{cityId}/tanggal/{date}")
    Call<JadwalSholatResponse> getJadwalSholat(@Path("cityId") String cityId, @Path("date") String date);
}
