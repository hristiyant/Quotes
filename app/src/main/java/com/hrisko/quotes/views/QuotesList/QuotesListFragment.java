package com.hrisko.quotes.views.QuotesList;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hrisko.quotes.R;
import com.hrisko.quotes.models.Quote;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class QuotesListFragment extends Fragment implements QuotesListContracts.View, QuotesAdapter.OnQuoteClickListener {

    private QuotesListContracts.Navigator mNavigator;

    @BindView(R.id.lv_quotes)
    RecyclerView mQuotesView;

    @BindView(R.id.loading)
    ProgressBar mProgressBar;

    @BindView(R.id.et_filter)
    EditText mFilteredText;

    @Inject
    QuotesAdapter mQuotesAdapter;

    private QuotesListContracts.Presenter mPresenter;
    private GridLayoutManager mQuotesViewLayoutManager;

    @Inject
    public QuotesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quotes_list, container, false);

        ButterKnife.bind(this, view);

        mQuotesAdapter.setOnQuoteClickListener(this);
        mQuotesView.setAdapter(mQuotesAdapter);
        mQuotesViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mQuotesView.setLayoutManager(mQuotesViewLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadQuotes();
    }

    @Override
    public void onClick(Quote quote) {
        mPresenter.selectQuote(quote);
    }

    @Override
    public void setPresenter(QuotesListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showQuotes(List<Quote> quotes) {
        mQuotesAdapter.clear();
        mQuotesAdapter.addAll(quotes);
        mQuotesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyQuotesList() {
        Toast.makeText(getContext(), "No quotes...", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        mQuotesView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
        mQuotesView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showQuoteDetails(Quote quote) {
        mNavigator.navigateWith(quote);
    }

    void setNavigator(QuotesListContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @OnTextChanged(R.id.et_filter)
    public void onTextChanged() {
        String pattern = mFilteredText.getText().toString();
        mPresenter.filterQuotes(pattern);
    }

}
