package com.hrisko.quotes.views;

import com.hrisko.quotes.async.base.SchedulerProvider;
import com.hrisko.quotes.models.Quote;

import java.util.List;

import javax.inject.Inject;


public class QuotesListPresenter implements QuotesListContracts.Presenter {

    private final SchedulerProvider mSchedulerProvider;
    private QuotesListContracts.View mView;

    @Inject
    public QuotesListPresenter(SchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
        //mQuotesService = quotesService;
    }

    @Override
    public void subscribe(QuotesListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadQuotes() {

    }

    @Override
    public void filterQuotes(String pattern) {

    }

    @Override
    public void selectQuote(Quote quote) {

    }

    private void presentQuotesToView(List<Quote> quotes) {
        if (quotes.isEmpty()) {
            mView.showEmptyQuotesList();
        } else {
            mView.showQuotes(quotes);
        }
    }
}
