package com.hrisko.quotes.views.QuotesList;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hrisko.quotes.R;
import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.views.BaseDrawerActivity;
import com.hrisko.quotes.views.Details.QuoteDetailsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class QuotesListActivity extends BaseDrawerActivity implements QuotesListContracts.Navigator{

    public static final long IDENTIFIER = 22;

    @Inject
    QuotesListFragment mQuotesListFragment;

    @Inject
    QuotesListContracts.Presenter mQuotesListPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_list);

        setSupportActionBar(getToolbar());

        ButterKnife.bind(this);

        mQuotesListFragment.setNavigator(this);
        mQuotesListFragment.setPresenter(mQuotesListPresenter);

        FragmentTransaction ft = getFragmentManager().beginTransaction()
                .replace(R.id.content, mQuotesListFragment);

        ft.commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateWith(Quote quote) {
        Intent intent = new Intent(this, QuoteDetailsActivity.class);
        intent.putExtra(QuoteDetailsActivity.EXTRA_KEY, quote);
        startActivity(intent);
    }
}
