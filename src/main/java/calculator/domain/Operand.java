package calculator.domain;

import static calculator.constant.Message.*;

public class Operand {
    private final int value;

    private Operand(int value) {
        validate(value);
        this.value = value;
    }

    public static Operand from(String numbersPart){
        if(numbersPart.isEmpty()){
            return new Operand(0);
        }
        try{
            int number = Integer.parseInt(numbersPart.trim());
            return new Operand(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_PARSE_ERROR.getMessage());
        }
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
