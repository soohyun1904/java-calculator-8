package calculator.domain;

public class Calculator {
    private final Operands operands;

    public Calculator(Operands operands) {
        this.operands = operands;
    }

    public double sum() {
        return operands.sum();
    }
}
