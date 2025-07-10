package Solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {

    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println(isAnagram3(s, t));

//        for (char c= 'a'; c <= 'z'; c++ ) {
//            System.out.println(c);
//        }
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length() ) return false;
        HashMap<Character, Integer> truthTable = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (truthTable.containsKey(s.charAt(i))) {
                truthTable.put(s.charAt(i), truthTable.get(s.charAt(i)) + 1);
            } else {
                truthTable.put(s.charAt(i), 1);
            }

            if (truthTable.containsKey(t.charAt(i))) {
                truthTable.put(t.charAt(i), truthTable.get(t.charAt(i)) - 1);
            } else {
                truthTable.put(t.charAt(i), -1);
            }
        }

        boolean allZero = true;
        for (Map.Entry<Character, Integer> entry : truthTable.entrySet()) {
            if (entry.getValue() != 0) {
                allZero = false;
                break;
            }
        }

        return allZero;
    }

    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;

        Integer totalSum = 0;
        for (int i = 0; i < s.length(); i++) {
            totalSum = totalSum+s.charAt(i) - t.charAt(i);
        }

        return totalSum == 0;
    }

    public static boolean isAnagram3(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] sortedS = s.toCharArray();
        Arrays.sort(sortedS);

        char[] sortedT = t.toCharArray();
        Arrays.sort(sortedT);

        for (int i = 0; i < s.length(); i++) {
            if (sortedS[i] != sortedT[i]) return false;
        }
        return true;
    }
}
