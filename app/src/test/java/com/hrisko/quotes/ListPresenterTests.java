package com.hrisko.quotes;


import com.hrisko.quotes.async.SyncSchedulerProvider;
import com.hrisko.quotes.async.base.SchedulerProvider;
import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.services.base.QuotesService;
import com.hrisko.quotes.views.QuotesList.QuotesListContracts;
import com.hrisko.quotes.views.QuotesList.QuotesListPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListPresenterTests {

    @Mock
    QuotesService mockService;

    @Mock
    QuotesListContracts.View mockView;

    SchedulerProvider schedulerProvider = new SyncSchedulerProvider();

    ArrayList<Quote> mQuotes;

    private QuotesListPresenter mPresenter;

    @Before
    public void setupTest() throws Exception {
        mQuotes = new ArrayList<>();
        when(mockService.getAllQuotes())
                .thenReturn(mQuotes);

        when(mockService.getFilteredQuotes(anyString()))
                .thenReturn(mQuotes);

        mPresenter = new QuotesListPresenter(schedulerProvider, mockService);
        mPresenter.subscribe(mockView);


    }

    @Test
    public void presenterLoadSuperheroes_whenNoSuperheroes_expectViewShowEmptySuperheroes() throws Exception {
        List<Quote> superheroList = Collections.emptyList();
        mPresenter.loadQuotes();

        verify(mockView).showEmptyQuotesList();
    }

}




