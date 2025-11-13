package calculator;

import calculator.io.CalculatorIOHandler;
import calculator.operation.ArithmeticLogicUnit;
import calculator.util.NumberValidator;
import calculator.util.UserInputNumbersParser;

public class Application {
    public static void main(String[] args) {
        CalculatorIOHandler ioHandler = new CalculatorIOHandler();
        NumberValidator numberValidator = new NumberValidator();
        ArithmeticLogicUnit alu = new ArithmeticLogicUnit();

        UserInputNumbersParser parser = new UserInputNumbersParser(numberValidator);

        Calculator calculator = new Calculator(ioHandler, parser, alu);

        calculator.run();
    }
}
