package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HockeyStick {

    private void hockeyStick(int row, int length) {
        System.out.println("Hockey stick statring from " + row);
        List<Integer> finalResult = new ArrayList<>(Arrays.asList(1, ++row));
        int oldValue = 1;
        int newValue = row;
        int sum = row + 1;
        for (int i = 2; i < length - 1; i++) {
            finalResult.add(newValuebimialCoefficient(oldValue + newValue, i, ++row));
            oldValue += newValue;
            newValue = finalResult.get(i);
            sum += newValue;
        }
        finalResult.add(sum);
        System.out.println(finalResult);
    }

    private int newValuebimialCoefficient(int oldValue, int index, int line) {
        return (oldValue * (line - index + 1) / index);
    }

    public static void main(String[] args) {
        int row = 1;
        int length = 4;
        new HockeyStick().hockeyStick(row, length);
    }

}