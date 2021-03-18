package test_task;

import java.util.List;
/*
    https://www.baeldung.com/java-convert-roman-arabic
 */
public class NotationConverter {
    public int toArabic(String romanNotation) throws InvalidValueException {
//        Не получилось без внесения 4 9 40 90 400 900 в enum

        if (romanNotation.length() < 0 || romanNotation == null) {
            throw new InvalidValueException();
        }
        romanNotation = romanNotation.toUpperCase();
        int result = 0;

        List<Roman> romanNumerals = Roman.getReverseSortedValues();

        int i = 0;

        while ((romanNotation.length() > 0) && (i < romanNumerals.size())) {
            Roman symbol = romanNumerals.get(i);
            if (romanNotation.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNotation = romanNotation.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        return result;
    }
}
