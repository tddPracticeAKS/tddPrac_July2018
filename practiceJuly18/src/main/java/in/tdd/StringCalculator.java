package in.tdd;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

import static in.tdd.OperatorFactory.getOperator;
import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;

public class StringCalculator {

    public int add(String numbers) {
           return stream(validateInput(numbers).get().split("[,\n]"))
                .filter(element -> !element.isEmpty())
                .filter(element -> StringUtils.isNumeric(element))
                .mapToInt(Integer::parseInt)
                .reduce(OperatorFactory.getOperator("+")).getAsInt();
    }

    private Optional<String> validateInput(String numbers) {
        return Optional.of(ofNullable(numbers).orElse(numbers.contains(",\n") ? "0" : numbers));
    }

    public int operate(String numbers, String operator) {
        IntBinaryOperator operation = getOperator(operator);
        return stream(validateInput(numbers).orElse("0").split(","))
                .filter(element -> !element.isEmpty())
                .mapToInt(Integer::parseInt)
                .reduce(operation)
                .getAsInt();
    }

}
