package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        if (s==null || s.isBlank()) {
            return false;
        }
        int numberOfDigits = (int) s.chars()
                .filter(x -> x > (int) '0' && x < (int) '9')
                .count();
        int otherChar = s.length()-numberOfDigits;
        return numberOfDigits > otherChar;
    }
}
