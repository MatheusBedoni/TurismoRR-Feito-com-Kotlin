package com.app.redes.turismorr.auxiliares;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Matheus on 03/02/2016.
 */
//Responsavel por verificar a internet do smartphone do usuario
public class UtilTCM {
    public static boolean isConnection(Context context){
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if(netInfo != null && netInfo.isConnected()){
            return true;
        }else{
            return false;
        }
    }
    public static boolean verifyConnection(Context c) {
        try {
            ConnectivityManager cm = (ConnectivityManager)
                    c.getSystemService(Context.CONNECTIVITY_SERVICE);
            int[] p = {0,1,6,9};
            for (int i : p) {
                if (cm.getNetworkInfo(i).isConnected()) return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
