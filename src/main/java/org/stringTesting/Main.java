package org.stringTesting;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> randomList = List.of("sdf");
        boolean isCancelled = true;
        String heading = HeadingMaker.makeHeading("key",
                new HeadingMaker.SuffixWithPredicate("suffix1", randomList.isEmpty()),
                new HeadingMaker.SuffixWithPredicate("suffix2", isCancelled));
        System.out.println("heading = " + heading);
    }
}
