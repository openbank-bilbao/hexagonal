package com.opencodely.codelyhexagonal.shared;

import java.util.function.Supplier;

public final class NameSupplier implements RootSupplier {
    public static String get() {
        return faker.name().firstName();
    }
}
