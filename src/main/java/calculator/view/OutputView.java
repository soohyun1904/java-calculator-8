package calculator.view;

public class OutputView {
    public static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String OUTPUT_FORMAT = "결과 : ";
    
    private OutputView() {
    }

    public static void printStartMessage(){
        System.out.println(INPUT_MESSAGE);
    }

    public static void printResultMessage(int result){
        System.out.println(OUTPUT_FORMAT + result);
    }
}
