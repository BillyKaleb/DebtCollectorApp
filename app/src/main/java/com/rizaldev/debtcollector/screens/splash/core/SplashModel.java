package com.rizaldev.debtcollector.screens.splash.core;

import com.rizaldev.debtcollector.api.DebtApi;
import com.rizaldev.debtcollector.screens.splash.SplashActivity;
import com.rizaldev.debtcollector.utils.NetworkUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by devel on 23/10/2017.
 */

public class SplashModel {

    SplashActivity context;

    public SplashModel(SplashActivity context) {
        this.context = context;
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(context);
    }
    Disposable delaySplash(){
        return Observable.just(true).delay(3000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(o -> navigateToLogin()).subscribe();
    }
    public void navigateToLogin() {
        context.navigateToLogin();
    }
}
