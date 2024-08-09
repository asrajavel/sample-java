package org.stringTesting;

import lombok.Value;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HeadingMaker {
    private static final String UNDERSCORE = "_";

    public static String makeHeading(String key, SuffixWithPredicate... suffixWithPredicates) {
        String completeSuffix = Arrays.stream(suffixWithPredicates)
                .filter(SuffixWithPredicate::isShouldIncludeSuffix)
                .map(SuffixWithPredicate::getSuffix)
                .collect(Collectors.joining(UNDERSCORE));

        return key + UNDERSCORE + completeSuffix;
    }

    @Value
    public static class SuffixWithPredicate {
        String suffix;
        boolean shouldIncludeSuffix;
    }
}
