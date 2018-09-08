package com.hrisko.quotes.validators.base;

public interface Validator<T> {
    boolean isValid(T object);
}
