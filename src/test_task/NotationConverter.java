package test_task;

/*
    без зависимости порядка цифр, кроме (4, 9, 40, 90, 400, 900), XM = 1010
 */
public class NotationConverter {
    public int toArabic(String romanNotation) throws InvalidValueException {
        String errorMessage = "String must contain only valid roman numerals [I, V, X, L, C, D, M]";

        if(romanNotation == null || romanNotation.length() <= 0) {
            throw new InvalidValueException(errorMessage);
        }
        char[] charSequence = romanNotation.toCharArray();
        int result = 0;

        try{
            for(int i = 0; i < charSequence.length; i++){
                if(i == 0) {
                    result += RomanNumbers.valueOf(String.valueOf(charSequence[i])).getValue();
                }else {
                    if(RomanNumbers.valueOf(String.valueOf(charSequence[i])).getValue() > RomanNumbers.valueOf(String.valueOf(charSequence[i-1])).getValue()) {

                        if(String.valueOf(charSequence[i-1]).equals("I") && (String.valueOf(charSequence[i]).equals("V") || String.valueOf(charSequence[i]).equals("X")) ||
                                String.valueOf(charSequence[i-1]).equals("X") && (String.valueOf(charSequence[i]).equals("L") || String.valueOf(charSequence[i]).equals("C")) ||
                                String.valueOf(charSequence[i-1]).equals("C") && (String.valueOf(charSequence[i]).equals("D") || String.valueOf(charSequence[i]).equals("M"))){
                            result += RomanNumbers.valueOf(String.valueOf(charSequence[i])).getValue() - 2 * RomanNumbers.valueOf(String.valueOf(charSequence[i - 1])).getValue();
                        }else {
                            result += RomanNumbers.valueOf(String.valueOf(charSequence[i])).getValue();
                        }
                    } else {
                        result += RomanNumbers.valueOf(String.valueOf(charSequence[i])).getValue();
                    }
                }
            }
        }catch(Exception e){
            throw new InvalidValueException(errorMessage);
        }

        return result;
    }
}
