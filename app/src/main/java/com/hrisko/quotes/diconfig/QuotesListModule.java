package com.hrisko.quotes.diconfig;

import com.hrisko.quotes.views.QuotesList.QuotesListFragment;
import com.hrisko.quotes.views.QuotesList.QuotesListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class QuotesListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract QuotesListFragment quotesListFragment();

    /*@ActivityScoped
    @Binds
    abstract QuotesListFragment.Presenter quotesListPresenter(QuotesListPresenter presenter);*/
}
