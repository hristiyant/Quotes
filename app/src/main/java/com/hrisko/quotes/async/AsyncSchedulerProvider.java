package com.hrisko.quotes.async;

import com.hrisko.quotes.async.base.SchedulerProvider;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AsyncSchedulerProvider implements SchedulerProvider {

    private static SchedulerProvider instance;

    private AsyncSchedulerProvider() {
        //Required empty private constructor for Singleton
    }

    public static SchedulerProvider getInstance() {
        if (instance == null) {
            instance = new AsyncSchedulerProvider();
        }
        return instance;
    }

    @Override
    public Scheduler background() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
