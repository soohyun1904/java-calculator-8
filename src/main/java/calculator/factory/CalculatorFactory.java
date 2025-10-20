package calculator.factory;

import calculator.domain.Calculator;
import calculator.domain.Operands;

public class CalculatorFactory {
    public CalculatorFactory() {
    }

    public Calculator createForm(Operands operands){
        return new Calculator(operands);
    }
}
