package com.hrisko.quotes.services.base;

import com.hrisko.quotes.models.Quote;

import java.util.List;

public interface QuotesService {
    List<Quote> getAllQuotes() throws Exception;

    Quote getDetailsById(int id) throws Exception;

    List<Quote> getFilteredQuotes(String pattern) throws Exception;

    Quote createQuote(Quote quote) throws Exception;
}
