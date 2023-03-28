package com.opencodely.codelyhexagonal.shared;

import net.datafaker.Faker;

import java.util.Locale;

public interface RootSupplier {
    Faker faker = new Faker(new Locale("es", "ES"));

}
