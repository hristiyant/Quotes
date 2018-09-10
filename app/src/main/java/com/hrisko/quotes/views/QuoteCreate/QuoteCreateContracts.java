package com.hrisko.quotes.views.QuoteCreate;

import com.hrisko.quotes.models.Quote;

public interface QuoteCreateContracts {
    interface View {

        void setPresenter(Presenter presenter);

        void navigateToHome();

        void showError(Throwable throwable);

        void hideLoading();

        void showLoading();

//        void showRequirementsMessage(String message);
    }

    interface Presenter {

        void subscribe(View view);

        void unsubscribe();

        void save(Quote quote);
    }

     interface Navigator {

        void navigateToHome();
    }
}
