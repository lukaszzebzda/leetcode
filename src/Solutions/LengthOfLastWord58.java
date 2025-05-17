package Solutions;

import java.util.Arrays;

public class LengthOfLastWord58 {

    public static void main(String[] args) {
        String s = "luffyisstilljoyboy";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        char[] result = s.trim().toCharArray();
        for (int i = result.length-1; i >= 0; i--) {
            if(result[i] == ' ')
                return result.length-i-1;
        }
        return result.length;
    }

    public static int lengthOfLastWordMuchSimpler(String s) {
        String trimmed = s.trim();
        return trimmed.length() - trimmed.lastIndexOf(" ") - 1;
    }
}
