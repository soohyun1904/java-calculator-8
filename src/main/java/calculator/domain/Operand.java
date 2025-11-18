package calculator.domain;

import calculator.constant.Message;

public class Operand {
    private final double value;

    public Operand(double value) {
        validate(value);
        this.value = value;
    }

    private void validate(double value) {
        if (value < 0) {
            throw new IllegalArgumentException(Message.NEGATIVE_NOT_ALLOWED.getMessage());
        }
    }

    public double getValue() {
        return value;
    }
}
