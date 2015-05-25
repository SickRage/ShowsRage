package com.mgaetan89.showsrage.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import retrofit.RestAdapter;

public class SickRageApi {
	@NonNull
	private String apiUrl = "";

	private static final SickRageApi INSTANCE = new SickRageApi();

	private SickRageServices services = null;

	@NonNull
	private String videosUrl = "";

	private SickRageApi() {
	}

	public static SickRageApi getInstance() {
		return INSTANCE;
	}

	public void init(Context context) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		String protocol = preferences.getBoolean("use_https", false) ? "https" : "http";
		String address = preferences.getString("server_address", "");
		String portNumber = preferences.getString("server_port_number", "");
		String path = preferences.getString("server_path", "");
		String apiKey = preferences.getString("api_key", "");

		this.apiUrl = String.format("%s://%s:%s/%s/%s/", protocol, address, portNumber, path, apiKey);
		this.videosUrl = String.format("%s://%s:%s/videos/", protocol, address, portNumber);

		RestAdapter restAdapter = new RestAdapter.Builder()
				.setEndpoint(this.apiUrl)
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.build();

		this.services = restAdapter.create(SickRageServices.class);
	}

	@NonNull
	public String getApiUrl() {
		return this.apiUrl;
	}

	public SickRageServices getServices() {
		return this.services;
	}

	@NonNull
	public String getVideosUrl() {
		return this.videosUrl;
	}
}
