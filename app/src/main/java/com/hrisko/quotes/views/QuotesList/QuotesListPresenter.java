package com.hrisko.quotes.views.QuotesList;

import com.hrisko.quotes.async.base.SchedulerProvider;
import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.services.base.QuotesService;
import com.hrisko.quotes.views.QuotesList.QuotesListContracts;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;


public class QuotesListPresenter implements QuotesListContracts.Presenter {

    private final QuotesService mQuotesService;
    private final SchedulerProvider mSchedulerProvider;
    private QuotesListContracts.View mView;

    @Inject
    public QuotesListPresenter(SchedulerProvider schedulerProvider, QuotesService quotesService) {
        mSchedulerProvider = schedulerProvider;
        mQuotesService = quotesService;
    }

    @Override
    public void subscribe(QuotesListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadQuotes() {
        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<List<Quote>>) emitter -> {
            List<Quote> quotes = mQuotesService.getAllQuotes();
            emitter.onNext(quotes);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentQuotesToView,
                        error -> mView.showError(error));
    }

    @Override
    public void filterQuotes(String pattern) {
        mView.showLoading();
        Disposable observable = Observable.create((ObservableOnSubscribe<List<Quote>>) emitter -> {
            List<Quote> quotes = mQuotesService.getFilteredQuotes(pattern);
            emitter.onNext(quotes);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(this::presentQuotesToView,
                        error -> mView.showError(error));
    }

    @Override
    public void selectQuote(Quote quote) {
        mView.showQuoteDetails(quote);
    }

    private void presentQuotesToView(List<Quote> quotes) {
        if (quotes.isEmpty()) {
            mView.showEmptyQuotesList();
        } else {
            mView.showQuotes(quotes);
        }
    }
}
