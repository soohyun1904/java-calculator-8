package calculator.domain;

import java.util.Iterator;
import java.util.List;

public class Operands implements Iterable<Number> {
    private final List<Operand> operands;

    public Operands(List<Operand> operands) {
        this.operands = operands;
    }

    @Override
    public Iterator<Number> iterator() {
        return operands.stream()
                .map(Operand::getValue)
                .iterator();
    }
}
