package calculator;

import calculator.io.CalculatorIOHandler;
import calculator.operation.ArithmeticLogicUnit;
import calculator.util.NumberValidator;
import calculator.util.UserInputNumbersParser;

import java.util.List;

public class Calculator {
    private final CalculatorIOHandler ioHandler;
    private final UserInputNumbersParser parser;
    private final ArithmeticLogicUnit alu;

    public Calculator(CalculatorIOHandler ioHandler, UserInputNumbersParser parser, ArithmeticLogicUnit alu) {
        this.ioHandler = ioHandler;
        this.parser = parser;
        this.alu = alu;
    }

    public void run() {
        String userInput = ioHandler.askUserInput();

        List<Integer> integers = parser.parse(userInput);

        int sum = alu.sum(integers);

        ioHandler.showResultOf(sum);
    }
}