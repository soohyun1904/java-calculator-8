package calculator.domain;

import java.util.List;

public class Calculator {
    private final Operands operands;

    private Calculator(Operands operands) {
        this.operands = operands;
    }

    public static Calculator from(String input) {
        List<String> numbers = Separator.splitByDelimiter(input);
        Operands operands = Operands.from(numbers);
        return new Calculator(operands);
    }

    public int sum() {
        return operands.sum();
    }

}
