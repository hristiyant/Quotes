package com.hrisko.quotes.validators;

import com.hrisko.quotes.Constants;
import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.validators.base.Validator;

public class QuoteValidator implements Validator<Quote>{
    @Override
    public boolean isValid(Quote quote) {
        return isTopicValid(quote) &&
                isAuthorNameValid(quote) &&
                isQuoteContentValid(quote) &&
                quote != null;
    }

    private boolean isTopicValid(Quote quote) {
        return quote.getTopic().length() >= Constants.QUOTE_TOPIC_MIN_LENGHT &&
                quote.getTopic().length() <= Constants.QUOTE_TOPIC_MAX_LENGHT;
    }

    private boolean isAuthorNameValid(Quote quote) {
        return quote.getAuthorName().length() >= Constants.QUOTE_AUTHOR_NAME_MIN_LENGHT &&
                quote.getAuthorName().length() <= Constants.QUOTE_AUTHOR_NAME_MAX_LENGHT;
    }

    private boolean isQuoteContentValid(Quote object) {
        return object.getQuote().length() >= Constants.QUOTE_CONTENT_MIN_LENGHT &&
                object.getQuote().length() <= Constants.QUOTE_CONTENT_MAX_LENGHT;
    }

}
