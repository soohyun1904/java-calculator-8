package calculator.factory;

import calculator.converter.OperandConverter;
import calculator.domain.Operand;
import calculator.domain.Operands;
import calculator.parser.InputParser;
import java.util.List;

public class OperandsFactory {
    private final InputParser inputParser;
    private final OperandConverter operandConverter;

    public OperandsFactory(InputParser inputParser, OperandConverter operandConverter) {
        this.inputParser = inputParser;
        this.operandConverter = operandConverter;
    }

    public Operands createForm(String input){
        List<String> stringNumber = inputParser.parser(input);
        List<Operand> operandList = stringNumber.stream()
                .map(operandConverter::convert)
                .toList();

        return new Operands(operandList);
    }
}
