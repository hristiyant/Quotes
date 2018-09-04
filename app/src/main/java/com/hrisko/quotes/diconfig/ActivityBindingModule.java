package com.hrisko.quotes.diconfig;

import com.hrisko.quotes.views.QuotesList.QuotesListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
            //modules = QuotesListActivity.class
    )
    abstract QuotesListActivity quotesListActivity();

//    @ActivityScoped
//    @ContributesAndroidInjector(
//            modules = SuperheroDetailsModule.class
//    )
//    abstract SuperheroDetailsActivity superheroDetailsActivity();
//
//    @ActivityScoped
//    @ContributesAndroidInjector(
//            modules = SuperheroCreateModule.class
//    )
//    abstract SuperheroCreateActivity superheroCreateActivity();
}
