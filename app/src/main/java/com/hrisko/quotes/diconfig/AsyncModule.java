package com.hrisko.quotes.diconfig;

import com.hrisko.quotes.async.AsyncSchedulerProvider;
import com.hrisko.quotes.async.base.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public SchedulerProvider schedulerProvider() {
        return AsyncSchedulerProvider.getInstance();
    }
}
