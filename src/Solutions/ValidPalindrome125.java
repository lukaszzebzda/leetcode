package Solutions;

public class ValidPalindrome125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }


    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        for (int i = 0; i < (s.length()/2); i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }
}
