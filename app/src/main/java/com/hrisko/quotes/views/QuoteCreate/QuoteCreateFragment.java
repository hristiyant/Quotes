package com.hrisko.quotes.views.QuoteCreate;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.hrisko.quotes.R;
import com.hrisko.quotes.models.Quote;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteCreateFragment extends Fragment implements QuoteCreateContracts.View{

    private QuoteCreateContracts.Presenter mPresenter;

    @BindView(R.id.et_author)
    EditText mNameEditText;

    @BindView(R.id.et_topic)
    EditText mSecretIdentity;

    @BindView(R.id.et_quote)
    EditText mQuoteText;


    private QuoteCreateContracts.Navigator mNavigator;

    @Inject
    public QuoteCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quote_create, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @OnClick(R.id.btn_save)
    public void onQuoteSaveClicked() {
        String authorsName = mNameEditText.getText().toString();
        String topic = mSecretIdentity.getText().toString();
        String quoteText = mQuoteText.getText().toString();
        String urlImsge = "img_url";
        Quote quote = new Quote(authorsName, topic, quoteText, urlImsge);
        mPresenter.save(quote);
    }

    @Override
    public void setPresenter(QuoteCreateContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void navigateToHome() {
        mNavigator.navigateToHome();
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    public void setNavigator(QuoteCreateContracts.Navigator navigator) {
        mNavigator = navigator;
    }
}
