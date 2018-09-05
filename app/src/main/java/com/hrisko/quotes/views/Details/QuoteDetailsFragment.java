package com.hrisko.quotes.views.Details;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hrisko.quotes.R;
import com.hrisko.quotes.models.Quote;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteDetailsFragment extends Fragment implements QuoteDetailsContracts.View{

    private QuoteDetailsContracts.Presenter mPresenter;

    @BindView(R.id.tv_name_author)
    TextView mAuthorTextView;

    @BindView(R.id.tv_topic_details)
    TextView mTopic;

    @BindView(R.id.tv_quote_text)
    TextView mQuoteText;

    @Inject
    public QuoteDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quote_details, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadQuote();
    }

    @Override
    public void showQuote(Quote quote) {
        mAuthorTextView.setText(quote.getAuthorName());
        mTopic.setText(quote.getTopic());
        mQuoteText.setText(quote.getQuote());
    }

    @Override
    public void setPresenter(QuoteDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
