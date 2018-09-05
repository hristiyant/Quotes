package com.hrisko.quotes.views.QuoteCreate;

import com.hrisko.quotes.models.Quote;

public interface QuoteCreateContracts {
    interface View {

        void setPresenter(Presenter presenter);

        void navigateToHome();

        void showError(Throwable throwable);

        void hideLoading();

        void showLoading();
    }

    interface Presenter {

        void subscribe(View view);

        void unsubscribe();

        void save(Quote quote);
    }

    public interface Navigator {

        void navigateToHome();
    }
}
