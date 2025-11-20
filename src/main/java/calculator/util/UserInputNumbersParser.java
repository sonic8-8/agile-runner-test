package calculator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserInputNumbersParser {

    private final NumberValidator numberValidator;

    private static final int CUSTOM_DELIMITER_START_INDEX = 2;

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String BASIC_DELIMITERS_REGEX = "[,:]";

    public UserInputNumbersParser(NumberValidator numberValidator) {
        this.numberValidator = numberValidator;
    }

    public List<Integer> parse(String userInput) {
        List<Integer> numbers = new ArrayList<>();

        String delimitersRegex = BASIC_DELIMITERS_REGEX;
        String numbersPart = userInput;

        if (userInput.startsWith(CUSTOM_DELIMITER_PREFIX) && userInput.contains(CUSTOM_DELIMITER_SUFFIX)) {
            int suffixStartIndex = userInput.indexOf(CUSTOM_DELIMITER_SUFFIX);

            String customDelimiter = userInput.substring(CUSTOM_DELIMITER_START_INDEX, suffixStartIndex);
            delimitersRegex = BASIC_DELIMITERS_REGEX + "|" + Pattern.quote(customDelimiter);

            int numbersPartStartIndex = suffixStartIndex + CUSTOM_DELIMITER_SUFFIX.length();
            numbersPart = userInput.substring(numbersPartStartIndex);
        }

        String[] candidates = numbersPart.split(delimitersRegex);

        for (String candidate : candidates) {
            if (candidate.isEmpty()) {
                numbers.add(0);
                continue;
            }

            numberValidator.validate(candidate);

            numbers.add(Integer.parseInt(candidate));
        }

        return numbers;
    }
}
