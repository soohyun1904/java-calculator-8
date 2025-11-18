package calculator.view;

public class OutputView {
    public static final String OUTPUT_FORMAT = "결과 : ";

    public OutputView() {
    }

    public void printResultMessage(double result){
        if(isInteger(result)){
            System.out.println(OUTPUT_FORMAT + result);
            return;
        }
        System.out.println(OUTPUT_FORMAT + result);
    }

    private boolean isInteger(double result) {
        return result == (long) result;
    }
}
