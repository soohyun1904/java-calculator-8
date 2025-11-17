package calculator.view;

public class OutputView {
    public static final String OUTPUT_FORMAT = "결과 : ";

    public OutputView() {
    }

    public void printResultMessage(Number result){
        if(isInteger(result)){
            System.out.println(OUTPUT_FORMAT + result.intValue());
            return;
        }
        System.out.println(OUTPUT_FORMAT + result.doubleValue());
    }

    private boolean isInteger(Number result) {
        return result instanceof Integer;
    }
}
