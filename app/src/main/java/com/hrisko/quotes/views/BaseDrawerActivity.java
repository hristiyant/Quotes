package com.hrisko.quotes.views;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hrisko.quotes.R;
import com.hrisko.quotes.views.QuoteCreate.QuoteCreateActivity;
import com.hrisko.quotes.views.QuotesList.QuotesListActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolbar;

    public BaseDrawerActivity() {

    }

    public void setupDrawer() {
        PrimaryDrawerItem listQuotesItem = new PrimaryDrawerItem()
                .withIdentifier(QuotesListActivity.IDENTIFIER)
                .withName("Quotes");

        PrimaryDrawerItem createQuoteItem = new PrimaryDrawerItem()
                .withIdentifier(QuoteCreateActivity.IDENTIFIER)
                .withIcon(android.R.drawable.btn_plus)
                .withName("Create quote");

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        listQuotesItem,
                        new DividerDrawerItem(),
                        createQuoteItem
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(
                            View view,
                            int position,
                            IDrawerItem drawerItem) {
                        long identifier = drawerItem.getIdentifier();

                        if (getIdentifier() == identifier) {
                            return false;
                        }

                        Intent intent = getNextIntent(identifier);
                        if (intent == null) {
                            return false;
                        }

                        startActivity(intent);
                        return true;
                    }
                })
                .build();
    }

    private Intent getNextIntent(long identifier) {
        if (identifier == QuoteCreateActivity.IDENTIFIER) {
            return new Intent(this, QuoteCreateActivity.class);
        }

        return null;
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    protected abstract long getIdentifier();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }
}

