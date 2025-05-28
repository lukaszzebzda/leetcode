package Solutions;

public class IsSubsequence392 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("ace", "abcde"));
    }

    public static boolean isSubsequence(String s, String t) {
        int lastLetterOfSinT;
        for (int i = s.length()-1; i >=0; i--) {
            lastLetterOfSinT = t.lastIndexOf(s.charAt(i));
            if(lastLetterOfSinT >= 0){
                t = t.substring(0, lastLetterOfSinT);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
