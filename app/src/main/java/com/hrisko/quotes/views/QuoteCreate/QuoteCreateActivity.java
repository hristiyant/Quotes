package com.hrisko.quotes.views.QuoteCreate;

import android.app.Activity;
import android.os.Bundle;

import com.hrisko.quotes.R;
import com.hrisko.quotes.views.BaseDrawerActivity;

public class QuoteCreateActivity extends BaseDrawerActivity{

    public static final long IDENTIFIER = 33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_create);
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }
}
