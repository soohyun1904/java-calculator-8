package calculator.domain;

import static calculator.constant.Message.*;

public class Operand {
    private final Number value;

    public Operand(Number value) {
        validate(value);
        this.value = value;
    }

    private void validate(Number value) {
        if (value.doubleValue() < 0) {
            throw new IllegalArgumentException(NEGATIVE_NOT_ALLOWED.getMessage());
        }
    }

    public Number getValue(){
        return value;
    }
}
