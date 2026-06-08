package Solutions;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstring3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> substringLetters = new HashSet<>();

        char[] chars = s.toCharArray();

        int biggestSpan = 0;
        int left = 0, right = 0;

        while (right < chars.length){

            while(substringLetters.contains(chars[right])){
                substringLetters.remove(chars[left]);
                left++;
            }
            substringLetters.add(chars[right]);

            biggestSpan = Math.max(biggestSpan, (right - left + 1));
            right++;
        }
        return biggestSpan;
    }
}
