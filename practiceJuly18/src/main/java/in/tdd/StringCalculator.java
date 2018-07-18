package in.tdd;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;
import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.Optional.of;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summingInt;

public class StringCalculator {

    private final String VALID_SEPARATORS = "[,|\n]";

    public int add(String numbers) {
        String delimiter = extractDelimiter(numbers);
        Map<Boolean, List<Integer>> lists = stream(sanitize(numbers, delimiter).split(delimiter))
                .filter(NumberUtils::isNumber)
                .map(Integer::parseInt)
                .collect(partitioningBy(num -> num < 0));
        validateNegativeInput(lists.get(true));
        return lists.get(false).stream().collect(summingInt(x -> Integer.valueOf(x)));
    }

    private void validateNegativeInput(List<Integer> list) {
        if (!list.isEmpty()) throw new IllegalArgumentException("Negative values : " + list);
    }

    private String extractDelimiter(String input) {
        return ofNullable(input)
                .filter(in -> in.startsWith("//"))
                .map(in -> valueOf(input.charAt(2)))
                .orElse(",");
    }

    private String sanitize(String numbers, String delimiter) {
        return ofNullable(numbers)
                .map(input -> input.replaceAll(VALID_SEPARATORS, delimiter))
                .filter(input -> !input.contains(",,"))
                .orElseThrow(() -> new IllegalArgumentException());
    }

}
