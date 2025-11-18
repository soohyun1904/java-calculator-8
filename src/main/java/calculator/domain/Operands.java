package calculator.domain;

import java.util.List;

public class Operands{
    private final List<Operand> operands;

    public Operands(List<Operand> operands) {
        this.operands = operands;
    }

    public double sum() {
        double sum = 0;
        for (Operand operand : operands) {
            sum += operand.getValue();
        }
        return sum;
    }
}
