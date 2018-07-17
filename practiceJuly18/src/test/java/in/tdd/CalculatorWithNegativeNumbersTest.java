package in.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("String Calculator tests with negative numbers")
public class CalculatorWithNegativeNumbersTest {

    @DisplayName("throw exception when negative number is given in input")
    @Test
    public void throwExceptionOnNegativeInput(){
        assertThrows(IllegalArgumentException.class, () -> new StringCalculator().add("-1,1,-9,-8"));
    }
}
