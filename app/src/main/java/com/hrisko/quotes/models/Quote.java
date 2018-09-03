package com.hrisko.quotes.models;

public class Quote {
    public int id;
    public String author;
    public String topic;
    public String quote;
    public boolean isDeleted;

    public Quote() {

    }
    public Quote( String author, String topic, String quote) {
        this.author = author;
        this.topic = topic;
        this.quote = quote;
        isDeleted = false;
    }


    public int getId() {
        return id;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
