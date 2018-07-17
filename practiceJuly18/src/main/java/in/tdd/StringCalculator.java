package in.tdd;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;
import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

public class StringCalculator {

    private final String VALID_SEPARATORS = "[,|\n]";

    public int add(String numbers) {
        String delimiter = extractDelimiter(numbers).get();
        Map<Boolean, List<Integer>> lists = stream(sanitize(numbers, delimiter).get().split(delimiter))
                .filter(input -> !input.isEmpty())
                .filter(NumberUtils::isNumber)
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(num -> num < 0));
        validateNegativeInput(lists.get(true));
        return sumOf(lists.get(false));
    }

    private int sumOf(List<Integer> list) {
        return ofNullable(list).orElseGet(() -> emptyList()).stream()
                .mapToInt(Integer::intValue)
                .reduce((x, y) -> x + y).orElse(0);
    }

    private void validateNegativeInput(List<Integer> list) {
        ofNullable(list).ifPresent(elements -> {
            throw new IllegalArgumentException("Negative values : " + elements);
        });
    }

    private Optional<String> extractDelimiter(String input) {
        return of(ofNullable(input)
                .filter(in -> in.startsWith("//"))
                .map(in -> valueOf(input.charAt(2)))
                .orElse(","));
    }

    private Optional<String> sanitize(String numbers, String delimiter) {
        return of(ofNullable(numbers)
                .map(input -> input.replaceAll(VALID_SEPARATORS, delimiter))
                .filter(input -> !input.contains(",,"))
                .orElseThrow(() -> new IllegalArgumentException()));
    }

}
