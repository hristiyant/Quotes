package com.hrisko.quotes.views.QuoteCreate;

import com.hrisko.quotes.async.base.SchedulerProvider;
import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.services.base.QuotesService;
import com.hrisko.quotes.validators.QuoteValidator;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class QuoteCreatePresenter implements QuoteCreateContracts.Presenter{
    private final QuotesService mQuotesService;
    private final SchedulerProvider mSchedulerProvider;
    private QuoteCreateContracts.View mView;
    private Quote mQuote;


    @Inject
    public QuoteCreatePresenter(
            QuotesService quotesService,
            SchedulerProvider schedulerProvider) {
        this.mQuotesService = quotesService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(QuoteCreateContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void save(Quote quote) {
//        if (!mValidator.isValid(quote)) {
//            int c = 9;
//            mView.showRequirementsMessage(mValidator.showMessage());
//            return;
//        }
        mQuote = quote;

        mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<Quote>) emitter -> {
                    Quote createdQuote = mQuotesService.createQuote(mQuote);
                    int b = 4;
                    emitter.onNext(createdQuote);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnEach(x -> mView.hideLoading())
                .doOnError(mView::showError)
                .subscribe(s -> mView.navigateToHome());
    }
}
