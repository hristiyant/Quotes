package com.hrisko.quotes.diconfig;

import com.hrisko.quotes.views.Details.QuoteDetailsActivity;
import com.hrisko.quotes.views.QuoteCreate.QuoteCreateActivity;
import com.hrisko.quotes.views.QuotesList.QuotesListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
            modules = QuotesListModule.class
    )
    abstract QuotesListActivity quotesListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = QuoteDetailsModule.class
    )
    abstract QuoteDetailsActivity quoteDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = QuoteCreateModule.class
    )
    abstract QuoteCreateActivity quoteCreateActivity();
}
