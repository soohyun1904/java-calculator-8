package calculator.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Operands {
    private List<Operand> operands;

    private Operands(List<Operand> operands) {
        this.operands = operands;
    }

    public static Operands from(List<String> numbers) {
        List<Operand> operandList = numbers.stream()
                .map(Operand::from)
                .collect(Collectors.toList());

        return new Operands(operandList);
    }

    public int sum() {
        return operands.stream()
                .mapToInt(Operand::getValue)
                .sum();
    }
}
