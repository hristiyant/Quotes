package com.hrisko.quotes.diconfig;

import com.hrisko.quotes.http.base.HttpRequester;
import com.hrisko.quotes.models.Quote;
import com.hrisko.quotes.parsers.base.JsonParser;
import com.hrisko.quotes.repositories.HttpRepository;
import com.hrisko.quotes.repositories.InMemoryRepository;
import com.hrisko.quotes.repositories.base.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    @Singleton
    public Repository<Quote> quoteRepository() {
        Repository<Quote> repository = new InMemoryRepository<>();
        List<Quote> initQuotes = Arrays.asList(
                new Quote("Marcus Tullius Cicero",
                        "Books",
                        "A room without books is like a body without a soul.",
                        "https://firebasestorage.googleapis.com/v0/b/test-project-5944f.appspot.com/o/avengers_infinity_war.jpg?alt=media&token=a32d7f68-eeba-40d0-bcf3-8f0dbfe8d3b8"),
                new Quote("Marilyn Monroe",
                        "Life",
                        "I'm selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can't handle me at my worst, then you sure as hell don't deserve me at my best.",
                        "https://firebasestorage.googleapis.com/v0/b/test-project-5944f.appspot.com/o/avengers_infinity_war.jpg?alt=media&token=a32d7f68-eeba-40d0-bcf3-8f0dbfe8d3b8"),
                new Quote("Oscar Wilde",
                        "Life",
                        "Be yourself; everyone else is already taken.",
                        "https://firebasestorage.googleapis.com/v0/b/test-project-5944f.appspot.com/o/avengers_infinity_war.jpg?alt=media&token=a32d7f68-eeba-40d0-bcf3-8f0dbfe8d3b8"),
                new Quote("Albert Einstein",
                        "Stupidity",
                        "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.",
                        "https://firebasestorage.googleapis.com/v0/b/test-project-5944f.appspot.com/o/avengers_infinity_war.jpg?alt=media&token=a32d7f68-eeba-40d0-bcf3-8f0dbfe8d3b8"),
                new Quote("Frank Zappa",
                        "Books",
                        "So many books, so little time.",
                        "https://firebasestorage.googleapis.com/v0/b/test-project-5944f.appspot.com/o/avengers_infinity_war.jpg?alt=media&token=a32d7f68-eeba-40d0-bcf3-8f0dbfe8d3b8"),
                new Quote("Bernard M. Baruch",
                        "Life",
                        "Be who you are and say what you feel, because those who mind don't matter, and those who matter don't mind.",
                        "https://firebasestorage.googleapis.com/v0/b/test-project-5944f.appspot.com/o/avengers_infinity_war.jpg?alt=media&token=a32d7f68-eeba-40d0-bcf3-8f0dbfe8d3b8")
        );

        int[] index = new int[1];
        initQuotes.forEach(q -> {
            try {
                q.setId(index[0]); //Only place where setId() should be used!
                index[0]++;
                repository.add(q);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return repository;
    }

//        @Provides
//    @Singleton
//    public Repository<Quote> quoteRepository(
//            @Named("baseServerUrl") String baseServerUrl,
//            HttpRequester httpRequester,
//            JsonParser<Quote> jsonParser
//    ) {
//        String url = baseServerUrl + "/quotes";
//        return new HttpRepository<>(httpRequester, url, jsonParser);
//    }
}
