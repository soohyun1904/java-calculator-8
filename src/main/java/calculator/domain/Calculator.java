package calculator.domain;

public class Calculator {
    private final Operands operands;

    public Calculator(Operands operands) {
        this.operands = operands;
    }

    public Number sum() {
        double result=0.0;
        boolean hasDecimal = false;
        for(Number value: operands){
            result += value.doubleValue();
            hasDecimal = isHasDecimal(value, hasDecimal);
        }
        if (!hasDecimal && result == (int) result) {
            return (int) result;
        }
        return result;
    }

    private boolean isHasDecimal(Number value, boolean hasDecimal) {
        if(value instanceof Double|| value instanceof Float){
            hasDecimal = true;
        }
        return hasDecimal;
    }
}
