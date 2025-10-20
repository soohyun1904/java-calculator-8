package calculator.domain;

import java.util.Iterator;
import java.util.List;

public class Operands implements Iterable<Integer> {
    private final List<Operand> operands;

    public Operands(List<Operand> operands) {
        this.operands = operands;
    }

    @Override
    public Iterator<Integer> iterator() {
        return operands.stream()
                .map(Operand::getValue)
                .iterator();
    }
}
