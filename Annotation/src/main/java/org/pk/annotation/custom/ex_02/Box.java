package org.pk.annotation.custom.ex_02;

public class Box<@NonEmpty T> {

    @NonEmpty int size;

    @NonEmpty T type;

    public Box(@NonEmpty int size, @NonEmpty T type) {
        this.size = size;
        this.type = type;
    }

    class NestedBox extends Box<T> {
        NestedBox(@NonEmpty int size, @NonEmpty T type) {
            super(size, type);
        }
    }
}
