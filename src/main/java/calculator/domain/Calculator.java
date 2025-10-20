package calculator.domain;

public class Calculator {
    private final Operands operands;

    public Calculator(Operands operands) {
        this.operands = operands;
    }

    public int sum() {
        int result=0;
        for(int value: operands){
            result += value;
        }

        return result;
    }
}
