package com.hrisko.quotes.http;

import com.hrisko.quotes.http.base.HttpRequester;

import java.io.IOException;

public class OkHttpRequester implements HttpRequester {

    public OkHttpRequester(){

    }

    @Override
    public String get(String url) throws IOException {
        return null;
    }

    @Override
    public String put(String url, String body) throws IOException {
        return null;
    }

    @Override
    public String post(String url, String body) throws IOException {
        return null;
    }
}
