package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Operands;
import calculator.factory.CalculatorFactory;
import calculator.factory.OperandsFactory;

public class CalculatorService {
    private final OperandsFactory operandFactory;
    private final CalculatorFactory calculatorFactory;

    public CalculatorService(OperandsFactory operandFactory, CalculatorFactory calculatorFactory) {
        this.operandFactory = operandFactory;
        this.calculatorFactory = calculatorFactory;
    }

    public int calculate(String inputValue){
        Operands operands = operandFactory.createForm(inputValue);
        Calculator calculator = calculatorFactory.createForm(operands);
        return calculator.sum();
    }
}
