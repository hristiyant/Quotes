package com.hrisko.quotes.diconfig;


import android.content.Context;
import android.support.v7.widget.RecyclerView;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewsModule {
    @Provides
    public RecyclerView.Adapter<QuotesAdapter.SuperheroViewHolder> quotesAdapter(Context context) {
        return new QuotesAdapter();
    }
}