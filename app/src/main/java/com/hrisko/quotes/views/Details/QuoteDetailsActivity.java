package com.hrisko.quotes.views.Details;

import android.content.Intent;
import android.os.Bundle;

import com.hrisko.quotes.R;
import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class QuoteDetailsActivity extends BaseDrawerActivity {

    public static final String EXTRA_KEY = "QUOTE_EXTRA_KEY";

    @Inject
    QuoteDetailsFragment mQuoteDetailsFragment;

    @Inject
    QuoteDetailsContracts.Presenter mQuoteDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Quote quote = (Quote) intent.getSerializableExtra(QuoteDetailsActivity.EXTRA_KEY);

        mQuoteDetailsPresenter.setQuoteId(quote.getId());
        mQuoteDetailsFragment.setPresenter(mQuoteDetailsPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mQuoteDetailsFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return 0;
    }
}
