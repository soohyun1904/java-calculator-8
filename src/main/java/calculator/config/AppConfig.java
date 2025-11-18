package calculator.config;

import calculator.controller.CalculatorController;
import calculator.converter.OperandConverter;
import calculator.factory.OperandsFactory;
import calculator.parser.DelimiterParser;
import calculator.parser.InputParser;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {
    public InputView inputView(){
        return new InputView();
    }

    public OutputView outputView(){
        return new OutputView();
    }

    public InputParser inputParser(){
        return new DelimiterParser();
    }

    public OperandConverter operandConverter(){
        return new OperandConverter();
    }

    public OperandsFactory operandsFactory(){
        return new OperandsFactory(inputParser(), operandConverter());
    }

    public CalculatorService calculatorService(){
        return new CalculatorService(operandsFactory());
    }

    public CalculatorController calculatorController(){
        return new CalculatorController(inputView(), outputView(), calculatorService());
    }
}
