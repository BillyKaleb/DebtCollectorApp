package com.rizaldev.debtcollector.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import io.reactivex.Observable;


/**
 * Created by devel on 22/10/2017.
 */

public class NetworkUtils {
    private static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public static Observable<Boolean> isNetworkAvailableObservable(Context context) {
        return Observable.just(NetworkUtils.isNetworkAvailable(context));
    }
}
