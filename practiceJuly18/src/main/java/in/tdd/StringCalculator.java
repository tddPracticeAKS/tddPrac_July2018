package in.tdd;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.function.IntBinaryOperator;

import static in.tdd.OperatorFactory.getOperator;
import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;

public class StringCalculator {

    public int add(String numbers) {
        return stream(ofNullable(numbers).orElse("0").split(","))
                .filter(element -> !element.isEmpty())
                .filter(element -> StringUtils.isNumeric(element))
                .mapToInt(Integer::parseInt)
                .reduce(OperatorFactory.getOperator("+")).getAsInt();
    }

    public int operate(String numbers, String operator) {
        IntBinaryOperator operation = getOperator(operator);
        return stream(ofNullable(numbers).orElse("0").split(","))
                .filter(element -> !element.isEmpty())
                .mapToInt(Integer::parseInt)
                .reduce(operation)
                .getAsInt();
    }

}
