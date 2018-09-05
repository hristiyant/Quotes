package com.hrisko.quotes.views.QuoteCreate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.hrisko.quotes.R;
import com.hrisko.quotes.views.BaseDrawerActivity;
import com.hrisko.quotes.views.QuotesList.QuotesListActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class QuoteCreateActivity extends BaseDrawerActivity implements QuoteCreateContracts.Navigator{

    public static final long IDENTIFIER = 33;

    @Inject
    QuoteCreateFragment mView;

    @Inject
    QuoteCreateContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_create);
        ButterKnife.bind(this);

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, QuotesListActivity.class);
        startActivity(intent);
        finish();
    }
}
