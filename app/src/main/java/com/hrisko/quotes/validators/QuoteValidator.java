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

    public String showMessage() {
        String message = String.format("Quote Author's name should be %s - %s long\n" +
                "Topic %s - %s long and \n" +
                "Quote length: %s - %s characters long!",
                Constants.QUOTE_AUTHOR_NAME_MIN_LENGTH,
                Constants.QUOTE_AUTHOR_NAME_MAX_LENGTH,
                Constants.QUOTE_TOPIC_MIN_LENGTH,
                Constants.QUOTE_TOPIC_MAX_LENGTH,
                Constants.QUOTE_CONTENT_MIN_LENGTH,
                Constants.QUOTE_CONTENT_MAX_LENGTH);
        return  message;
    }

    private boolean isTopicValid(Quote quote) {
        return quote.getTopic().length() >= Constants.QUOTE_TOPIC_MIN_LENGTH &&
                quote.getTopic().length() <= Constants.QUOTE_TOPIC_MAX_LENGTH;
    }

    private boolean isAuthorNameValid(Quote quote) {
        return quote.getAuthorName().length() >= Constants.QUOTE_AUTHOR_NAME_MIN_LENGTH &&
                quote.getAuthorName().length() <= Constants.QUOTE_AUTHOR_NAME_MAX_LENGTH;
    }

    private boolean isQuoteContentValid(Quote object) {
        return object.getQuote().length() >= Constants.QUOTE_CONTENT_MIN_LENGTH &&
                object.getQuote().length() <= Constants.QUOTE_CONTENT_MAX_LENGTH;
    }

}
