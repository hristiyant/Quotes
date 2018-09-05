package com.hrisko.quotes.diconfig;

import com.hrisko.quotes.views.QuoteCreate.QuoteCreateContracts;
import com.hrisko.quotes.views.QuoteCreate.QuoteCreateFragment;
import com.hrisko.quotes.views.QuoteCreate.QuoteCreatePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class QuoteCreateModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract QuoteCreateFragment quoteCreateFragment();

    @ActivityScoped
    @Binds
    abstract QuoteCreateContracts.Presenter quoteCreatePresenter(QuoteCreatePresenter presenter);
}
