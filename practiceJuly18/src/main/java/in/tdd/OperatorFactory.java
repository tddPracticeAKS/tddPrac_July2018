package in.tdd;

import java.util.function.IntBinaryOperator;

public class OperatorFactory {

    public static IntBinaryOperator getOperator(String operator){
        IntBinaryOperator operation = OperatorFactory::sum;
        if("*".equals(operator))
            operation = OperatorFactory::multiply;
        return operation;
    }

    private static int sum(int x, int y) {
        return x + y;
    }

    private static int multiply(int x, int y) {
        return x * y;
    }
}
