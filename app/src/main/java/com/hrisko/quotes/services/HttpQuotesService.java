package com.hrisko.quotes.services;

import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.repositories.base.Repository;
import com.hrisko.quotes.services.base.QuotesService;
import com.hrisko.quotes.validators.base.Validator;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class HttpQuotesService implements QuotesService {

    private final Repository<Quote> mQuotesRepository;
    private final Validator<Quote> mQuotesValidator;

    public HttpQuotesService(Repository<Quote> repository ,Validator<Quote> validator) {
        mQuotesRepository = repository;
        mQuotesValidator = validator;
    }

    @Override
    public List<Quote> getAllQuotes() throws Exception {
        return mQuotesRepository.getAll();
    }

    @Override
    public Quote getDetailsById(int id) throws Exception {
        return mQuotesRepository.getById(id);
    }

    @Override
    public List<Quote> getFilteredQuotes(String pattern) throws Exception {
        final String patternToLower = pattern.toLowerCase();

        return getAllQuotes().stream()
                .filter(quote -> quote.getTopic().toLowerCase().contains(patternToLower) ||
                                quote.getAuthorName().toLowerCase().contains(patternToLower))
                .collect(Collectors.toList());
    }

    @Override
    public Quote createQuote(Quote quote) throws IllegalArgumentException, IOException {
        if(!mQuotesValidator.isValid(quote)){
            throw new IllegalArgumentException("Quote is not valid!");
        }else {

            return mQuotesRepository.add(quote);
        }
    }
}
