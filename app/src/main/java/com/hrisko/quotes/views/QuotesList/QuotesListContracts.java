package com.hrisko.quotes.views.QuotesList;

import com.hrisko.quotes.models.Quote;

import java.util.List;

public interface QuotesListContracts {
    interface View {
        void setPresenter(Presenter presenter);
        void showQuotes(List<Quote> quotes);
        void showEmptyQuotesList();
        void showError(Throwable e);
        void showLoading();
        void hideLoading();
        void showQuoteDetails(Quote quote);
    }

    interface Presenter {
        void subscribe(View view);
        void loadQuotes();
        void filterQuotes(String pattern);
        void selectQuote(Quote quote);
    }

    interface Navigator {
        void navigateWith(Quote quote);
    }
}
