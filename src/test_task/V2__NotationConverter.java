package test_task;

import java.util.ArrayList;
import java.util.List;

/*
    зависимость от порядлка расположения и запрет исполльзования XXXX (или любого повторения более 3 раз)
 */
public class V2__NotationConverter {
    public int toArabic(String romanNotation) throws InvalidValueException {
        String errorMessage = "String must contain only valid roman numerals [I, V, X, L, C, D, M]";

        if(romanNotation == null || romanNotation.length() <= 0) {
            throw new InvalidValueException(errorMessage);
        }

        //Массив исключений для римских цифр
        String[] exceptionOfRomanNum = {"IV", "4", "IX", "9", "XL", "40", "XC", "90", "CD", "400", "CM", "900"};

        int result = 0; // переменная для хранения результата
        romanNotation = romanNotation.toUpperCase(); // перевод символов строки в верхний регистр xcvi -> XCVI
        char[] charSequence = romanNotation.toCharArray();

        if(charSequence.length >= 4) {
            for(int i = 0; i< charSequence.length; i++) {
                if(i <= charSequence.length - 4) {
                    if(charSequence[i] == charSequence[i + 1] && charSequence[i] == charSequence[i + 2] && charSequence[i] == charSequence[i + 3]){
                        throw new InvalidValueException("измените запись числа пример XXXX -> XL");
                    }
                }
            }
        }

        StringBuilder builder = new StringBuilder(); // получение строки из двух символов
        List<Integer> values = new ArrayList<>();

        try{
            for(int i = 0; i < charSequence.length; i++) {
                if(i == charSequence.length - 1) {
                    for(RomanNumbers rn : RomanNumbers.values()) {
                        if(rn.getName().equals(String.valueOf(charSequence[i]))) {
                            values.add(rn.getValue());
                        }
                    }
                }else {
                    builder.append(charSequence[i]);
                    builder.append(charSequence[i+1]);
                    boolean check = false;
                    for(int k = 0; k < exceptionOfRomanNum.length; k++){
                        if(builder.toString().equals(exceptionOfRomanNum[k])) {
                            values.add(Integer.parseInt(exceptionOfRomanNum[k+1]));
                            builder.setLength(0);
                            check = true;
                            i++;
                        }
                    }
                    if(check) continue;
                    for(RomanNumbers rn : RomanNumbers.values()) {
                        if(rn.getName().equals(String.valueOf(charSequence[i]))) {
                            values.add(rn.getValue());
                        }
                    }
                    builder.setLength(0);
                }
            }
        }catch(Exception e) {
            throw new InvalidValueException(errorMessage);
        }

        for(int i = 0; i < values.size(); i++) {
            if(i == 0) {
                result += values.get(i);
                continue;
            }
            if(values.get(i) <= values.get(i-1)) {
                result += values.get(i);
            }else {
                throw new InvalidValueException("Порядок должен быть от большего к меньшему");
            }
        }
        return result;
    }
}
