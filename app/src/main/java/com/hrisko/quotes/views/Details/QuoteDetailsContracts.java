package com.hrisko.quotes.views.Details;

import com.hrisko.quotes.models.Quote;

public interface QuoteDetailsContracts {
    interface View {
        void showQuote(Quote quote);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void loadQuote();

        void setQuoteId(int id);
    }
}
