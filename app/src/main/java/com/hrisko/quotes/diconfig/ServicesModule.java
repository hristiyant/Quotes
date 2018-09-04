package com.hrisko.quotes.diconfig;

import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.repositories.base.Repository;
import com.hrisko.quotes.services.HttpQuotesService;
import com.hrisko.quotes.services.base.QuotesService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public QuotesService quotesService(Repository<Quote> repository
           // , Validator<Superhero> validator
    ) {
        return new HttpQuotesService(repository
//                , validator
        );
    }
}
