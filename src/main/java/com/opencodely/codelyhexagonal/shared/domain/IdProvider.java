package com.opencodely.codelyhexagonal.shared.domain;

public interface IdProvider<T> {

  T provide();
}
