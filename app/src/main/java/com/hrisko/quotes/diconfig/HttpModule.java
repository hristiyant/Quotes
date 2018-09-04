package com.hrisko.quotes.diconfig;

import com.hrisko.quotes.Constants;
import com.hrisko.quotes.http.OkHttpHttpRequester;
import com.hrisko.quotes.http.base.HttpRequester;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {
    @Provides
    public HttpRequester httpRequester() {
        return new OkHttpHttpRequester();
    }

    @Provides
    @Named("baseServerUrl")
    public String baseServerUrl() {
        return Constants.BASE_SERVER_URL;
    }
}

