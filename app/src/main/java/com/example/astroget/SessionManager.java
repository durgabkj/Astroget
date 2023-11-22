package com.example.astroget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.astroget.Screen.Login.LoginActivity;

public class SessionManager {
    //user data
    private static final String PREF_NAME = "userName";
    private static final String IS_LOGIN = "isLogin";
    private static SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void clearSession() {
        editor.clear();
        editor.commit();
    }


    public void logoutUser() {
        clearSession();
        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);

    }

}

