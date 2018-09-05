package com.hrisko.quotes.diconfig;

import com.hrisko.quotes.views.Details.QuoteDetailsContracts;
import com.hrisko.quotes.views.Details.QuoteDetailsFragment;
import com.hrisko.quotes.views.Details.QuoteDetailsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class QuoteDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract QuoteDetailsFragment quoteDetailsFragment();

    @ActivityScoped
    @Binds
    abstract QuoteDetailsContracts.Presenter quotesDetailsPresenter(QuoteDetailsPresenter presenter);
}
