package calculator.io;

import java.util.Scanner;

public class InputHandler {

    private final Scanner SCANNER = new Scanner(System.in);

    public String getUserInput() {
        return SCANNER.nextLine();
    }
}