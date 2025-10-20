package calculator.view;

public class OutputView {
    public static final String OUTPUT_FORMAT = "결과 : ";

    public OutputView() {
    }

    public void printResultMessage(int result){
        System.out.println(OUTPUT_FORMAT + result);
    }
}
