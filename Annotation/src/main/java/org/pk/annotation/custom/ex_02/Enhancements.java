package org.pk.annotation.custom.ex_02;

public class Enhancements {
    /**
     * This is the way we can use annotation every where
     * @param args
     */
    public static void main(String[] args) {
        Box<String> box = new @NonEmpty @ReadOnly Box<String>(10, "Container");

        Box<String>.NestedBox cylinder = box.new @ReadOnly NestedBox(11, "Cylinder");

        System.out.println();
    }

}
