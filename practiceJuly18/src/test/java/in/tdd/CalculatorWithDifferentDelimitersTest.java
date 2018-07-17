package in.tdd;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("String Calculator tests with default delimiter as ',' ")
public class CalculatorWithDifferentDelimitersTest {

    @DisplayName("return 6 when //;\n1;2;3")
    @Test
    public void returnSumWhenDelimiterIsGiven(){
        assertEquals(6, new StringCalculator().add("//;\n1;2;3"));
    }

    @DisplayName("return 10 when //#\n1#2#3#4")
    @Test
    public void returnSumWhenDelimiterIsGivenCase2(){
        assertEquals(10, new StringCalculator().add("//#\n1#2#3#4"));
    }
}
