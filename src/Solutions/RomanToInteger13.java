package Solutions;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(romanToInt("XIV"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I',1);
        romanToIntMap.put('V',5);
        romanToIntMap.put('X',10);
        romanToIntMap.put('L',50);
        romanToIntMap.put('C',100);
        romanToIntMap.put('D',500);
        romanToIntMap.put('M',1000);

        int sum = 0;
        Character currentPlaceValue = 'I';

        for (int i = s.length()-1; i >= 0; i--) {
            if(romanToIntMap.get(currentPlaceValue) < romanToIntMap.get(s.charAt(i))){
                currentPlaceValue = s.charAt(i);
                sum += romanToIntMap.get(s.charAt(i));
            } else if (romanToIntMap.get(currentPlaceValue) == romanToIntMap.get(s.charAt(i))) {
                sum += romanToIntMap.get(s.charAt(i));
            } else if (romanToIntMap.get(currentPlaceValue) > romanToIntMap.get(s.charAt(i))) {
                sum -= romanToIntMap.get(s.charAt(i));
            }
        }

        return sum;
    }

    public static int romanToIntSwitchInsteadOfMap(String s) {
        int sum = 0; int num = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            num = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> num;
            };

            if (4 * num < sum) {
                sum -= num;
            } else {
                sum += num;
            }
        }

        return sum;
    }
}
