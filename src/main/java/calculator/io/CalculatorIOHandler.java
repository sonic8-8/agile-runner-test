package calculator.io;

public class CalculatorIOHandler {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public String askUserInput() {
        outputHandler.askUserInput();
        return inputHandler.getUserInput();
    }

    public void showResultOf(int sum) {
        outputHandler.showResultOf(sum);
    }
}