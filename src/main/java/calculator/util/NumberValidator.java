package calculator.util;

public class NumberValidator {

    public void validate(String candidate) {
        if (!Character.isDigit(candidate.charAt(0))) {
            throw new IllegalArgumentException();
        }
    }
}
