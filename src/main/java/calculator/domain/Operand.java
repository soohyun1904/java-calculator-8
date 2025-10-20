package calculator.domain;

import static calculator.constant.Message.*;

public class Operand {
    private final int value;

    public Operand(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(NEGATIVE_NOT_ALLOWED.getMessage());
        }
    }

    public int getValue(){
        return value;
    }
}
