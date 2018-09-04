package com.hrisko.quotes.repositories;

import com.hrisko.quotes.http.base.HttpRequester;
import com.hrisko.quotes.parsers.base.JsonParser;
import com.hrisko.quotes.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

public class HttpRepository<T> implements Repository<T> {

    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<T> mJsonParser;

    public HttpRepository(HttpRequester httpRequester, String serverUrl, JsonParser<T> jsonParser) {
        mHttpRequester = httpRequester;
        mServerUrl = serverUrl;
        mJsonParser = jsonParser;
    }

    @Override
    public List<T> getAll() throws IOException {
        return null;
    }

    @Override
    public T add(T item) throws IOException {
        return null;
    }

    @Override
    public T edit(T item, int id) throws IOException {
        return null;
    }
}
