package com.hrisko.quotes.diconfig;

import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.parsers.GsonJsonParser;
import com.hrisko.quotes.parsers.base.JsonParser;

import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {
    @Provides
    public JsonParser<Quote> superheroJsonParser() {
        return new GsonJsonParser<>(Quote.class, Quote[].class);
    }
}
