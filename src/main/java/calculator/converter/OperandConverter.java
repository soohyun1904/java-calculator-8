package calculator.converter;

import calculator.domain.Operand;
import static calculator.constant.Message.NUMBER_PARSE_ERROR;

public class OperandConverter {
    public OperandConverter() {
    }

    public Operand convert(String numberPart){
        if(numberPart.isEmpty()){
            return new Operand(0);
        }
        try{
            if(numberPart.contains(".")){
                double number = Double.parseDouble(numberPart);
                return new Operand(number);
            }
            int number = Integer.parseInt(numberPart);
            return new Operand(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_PARSE_ERROR.getMessage());
        }
    }
}
