package com.hrisko.quotes.views.Details;

import com.hrisko.quotes.async.base.SchedulerProvider;
import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.services.base.QuotesService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class QuoteDetailsPresenter implements QuoteDetailsContracts.Presenter {
    private final QuotesService mQuotesService;
    private final SchedulerProvider mSchedulerProvider;

    private QuoteDetailsContracts.View mView;

    private int mQuoteId;

    @Inject
    public QuoteDetailsPresenter(
            QuotesService quotesService,
            SchedulerProvider schedulerProvider
    ) {
        mQuotesService = quotesService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(QuoteDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadQuote() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Quote>) emitter -> {
                    Quote quote = mQuotesService.getDetailsById(mQuoteId);
                    emitter.onNext(quote);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showQuote);
    }

    @Override
    public void setQuoteId(int quoteId) {
        mQuoteId = quoteId;
    }
}
