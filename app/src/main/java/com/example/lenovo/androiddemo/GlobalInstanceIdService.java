package com.example.lenovo.androiddemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.iid.zzd;

/**
 * Created by admin on 12/26/2016.
 */

public class GlobalInstanceIdService extends FirebaseInstanceIdService {
    private static final String TAG = "MyFirebaseIIDService";
    private SharedPreferences sharedPreferences;


    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String refreshedToken= FirebaseInstanceId.getInstance().getToken();
        Log.e(TAG, "Refreshed token: " + refreshedToken);

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);

        sharedPreferences.edit().putString("token",refreshedToken).apply();
        sharedPreferences.edit().putBoolean("isToken",true).apply();

        sendRegistrationToServer(refreshedToken);

    }


    private void sendRegistrationToServer(String token) {

    }

}
