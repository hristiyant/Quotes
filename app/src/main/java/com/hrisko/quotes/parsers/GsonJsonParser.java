package com.hrisko.quotes.parsers;

import com.google.gson.Gson;
import com.hrisko.quotes.parsers.base.JsonParser;

import java.util.List;


public class GsonJsonParser<T> implements JsonParser<T> {

    private final Class<T> mKlass;
    private final Class<T[]> mArrayKlass;
    private final Gson mGson;

    public GsonJsonParser(Class<T> klass, Class<T[]> arrayKlass) {
        mKlass = klass;
        mArrayKlass = arrayKlass;
        mGson = new Gson();
    }


    @Override
    public List<T> fromJsonArray(String jsonString) {
        return null;
    }

    @Override
    public T fromJson(String jsonString) {
        return null;
    }

    @Override
    public String toJson(T object) {
        return null;
    }
}
