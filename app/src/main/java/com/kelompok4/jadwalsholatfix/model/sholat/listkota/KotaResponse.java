package com.kelompok4.jadwalsholatfix.model.sholat.listkota;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class KotaResponse {

	@SerializedName("kota")
	private ArrayList<KotaItem> kota;

	@SerializedName("query")
	private Query query;

	@SerializedName("status")
	private String status;

	public void setKota(ArrayList<KotaItem> kota){
		this.kota = kota;
	}

	public ArrayList<KotaItem> getKota(){
		return kota;
	}

	public void setQuery(Query query){
		this.query = query;
	}

	public Query getQuery(){
		return query;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"kota = '" + kota + '\'' + 
			",query = '" + query + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}