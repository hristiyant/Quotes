package com.hrisko.quotes.diconfig;

import com.hrisko.quotes.views.QuotesListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class QuotesListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract QuotesListFragment superheroesListFragment();

    @ActivityScoped
    @Binds
    abstract QuotesListFragment.Presenter superheroesListPresenter(QuotesListPresenter presenter);
}
