package in.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("String Calculator tests with default delimiter as ',' ")
public class StringCalculatorWithDefaultDelimiterTest {

    @DisplayName("Return Zero when input is Null")
    @Test
    public void returnZeroWhenInputNull() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.add(null));
    }

    @DisplayName("Return Zero when input is empty")
    @Test
    public void returnZeroWhenInputEmpty() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @DisplayName("Return 1 when input is single number 1")
    @Test
    public void returnOneWhenInputSingleNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        int sum = stringCalculator.add("1");
        assertEquals(1, sum);
    }

    @DisplayName("Return 2 when input is single number 2")
    @Test
    public void returnTwoWhenInputSingleNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        int sum = stringCalculator.add("2");
        assertEquals(2, sum);
    }

    @DisplayName("Return 99 when input is single number 99")
    @Test
    public void return99WhenInputSingleNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        int sum = stringCalculator.add("99");
        assertEquals(99, sum);
    }

    @DisplayName("Return sum 3 when input is multiple inputs 1 and 2")
    @Test
    public void returnSumThreeWhenInputMultipleInputsOneAndTwo() {
        StringCalculator stringCalculator = new StringCalculator();
        int sum = stringCalculator.add("1,2");
        assertEquals(3, sum);
    }

    @DisplayName("Return sum 21 when input is multiple inputs 1,2,3,4,5,6")
    @Test
    public void returnSumWhenInputMultipleInputsAsList() {
        StringCalculator stringCalculator = new StringCalculator();
        int sum = stringCalculator.add("1,2,3,4,5,6");
        assertEquals(21, sum);
    }

    @DisplayName("Return sum 21 when input is multiple inputs 1,2,3,4,5\n6")
    @Test
    public void returnSumWhenInputMultipleInputsAsListWithNewLineChar() {
        StringCalculator stringCalculator = new StringCalculator();
        int sum = stringCalculator.add("1,2,3,4,5\n6");
        assertEquals(21, sum);
    }

    @DisplayName("Return sum 0 when input is multiple inputs 1,2,3,4,5,\n6, a invalid string")
    @Test
    public void returnSumWhenInputMultipleInputsAsListWithInvalidString() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,2,3,4,5,\n6"));
    }

    @DisplayName("Return wrong input when input not integers")
    @Test
    public void returnWrongInputWhenInputNotIntegers() {
        StringCalculator stringCalculator = new StringCalculator();
        int product = stringCalculator.add("a,b,3");
        assertEquals(3, product);
    }


}
