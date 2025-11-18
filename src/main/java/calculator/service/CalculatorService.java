package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Operands;
import calculator.factory.OperandsFactory;

public class CalculatorService {
    private final OperandsFactory operandsFactory;

    public CalculatorService(OperandsFactory operandsFactory) {
        this.operandsFactory = operandsFactory;
    }

    public double calculate(String input) {
        Operands operands = operandsFactory.createForm(input);
        Calculator calculator = new Calculator(operands);
        return calculator.sum();
    }
}
