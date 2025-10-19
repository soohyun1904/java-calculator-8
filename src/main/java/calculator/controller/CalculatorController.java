package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.OutputView;

import static calculator.view.InputView.*;
import static calculator.view.OutputView.printStartMessage;

public class CalculatorController {
    public void run(){
        printStartMessage();
        String inputValue = readInput();
        Calculator calculator = Calculator.from(inputValue);
        OutputView.printResultMessage(calculator.sum());
    }
}
