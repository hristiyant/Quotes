package com.hrisko.quotes.diconfig;

import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.validators.QuoteValidator;
import com.hrisko.quotes.validators.base.Validator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ValidatorModule {
    @Provides
    @Singleton
    public Validator<Quote> quoteValidator(){
        return new QuoteValidator();
    }
}
