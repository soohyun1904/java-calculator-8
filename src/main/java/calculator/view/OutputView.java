package calculator.view;

import static calculator.constant.Message.INPUT_MESSAGE;
import static calculator.constant.Message.OUTPUT_FORMAT;

public class OutputView {

    public static void printStartMessage(){
        System.out.println(INPUT_MESSAGE);
    }

    public static void printResultMessage(int result){
        System.out.println(OUTPUT_FORMAT + result);
    }
}
