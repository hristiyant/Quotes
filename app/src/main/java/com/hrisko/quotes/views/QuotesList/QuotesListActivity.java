package com.hrisko.quotes.views.QuotesList;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hrisko.quotes.R;
import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.views.BaseDrawerActivity;

public class QuotesListActivity extends BaseDrawerActivity implements QuotesListContracts.Navigator{

    public static final long IDENTIFIER = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_list);
        setSupportActionBar(getToolbar());


    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateWith(Quote quote) {

    }
}
