package com.app.redes.turismorr.auxiliares;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Matt on 14/01/2019.
 */
//Classe que serve como auxiliar para poder guardar o token gerado no login
public class LibraryClass {
    public static String PREF = "com.app.redes.moipchallenge.PREF";

    static public void saveSP(Context context, String key, String value ){
        SharedPreferences sp = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).apply();
    }

    static public String getSP(Context context, String key ){
        SharedPreferences sp = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        String token = sp.getString(key, "");
        return( token );
    }
}
