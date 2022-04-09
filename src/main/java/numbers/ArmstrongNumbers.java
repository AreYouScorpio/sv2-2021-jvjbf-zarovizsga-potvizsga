package numbers;

import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumbers {

    private List<Character> arrayOfNumbers = new ArrayList<>();


    public int howLongIsTheNumber(int number) {
        return String.valueOf(number).length();
    }

    public void getCharArray(int number) {
        arrayOfNumbers.clear();
        for (int i = 1; i < howLongIsTheNumber(number) + 1; i++) {
            arrayOfNumbers.add(String.valueOf(number).charAt(i - 1));
        }
    }

    public boolean isArmstrongNumber(int number) {

        if (number < 0) throw new IllegalArgumentException("Number can't be negative: " + number);

        getCharArray(number);

        int result = 0;

        for (int i = 1; i < arrayOfNumbers.size() + 1; i++) {
            int newNumber = Character.getNumericValue(arrayOfNumbers.get(i - 1));
            result += Math.pow(newNumber, howLongIsTheNumber(number));
        }
        return result == number;


    }
}
