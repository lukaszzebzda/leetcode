package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern290 {

    public static void main(String[] args) {
        System.out.println(wordPattern2("abba", "dog cat cat fish"));
    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> patterns = new HashMap<>();
        String[] words = s.split(" ");
        for (int i = 0; i < pattern.length(); i++) {
            if (!patterns.containsKey(pattern.charAt(i))) {
                patterns.put(pattern.charAt(i), words[i]);
            } else if (words[i].compareTo(patterns.get(pattern.charAt(i))) != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean wordPattern2(String pattern, String s) {
        int[] mapPS = new int[256];
//        int[] mapSP = new int[Integer.MAX_VALUE];
        Map<Integer,Character> mapSP = new HashMap<>();

        String[] words = s.split(" ");

        if(pattern.length() != words.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c1 = pattern.charAt(i);
            int c2 = words[i].hashCode();

            // If not previously mapped, map it
            if (mapPS[c1] == 0 && !mapSP.containsKey(c2)) {
                mapPS[c1] = c2;
                mapSP.put(c2, c1);
            }
            // If previously mapped, check consistency
            else {
                if (mapPS[c1] != c2 || mapSP.get(c2) != c1) return false;
            }

        }

        return true;
    }

    // Requested array size exceeds VM limit :C
    public static boolean wordPattern3(String pattern, String s) {
        int[] mapPS = new int[256];
        int[] mapSP = new int[Integer.MAX_VALUE];
//        Map<Integer,Character> mapSP = new HashMap<>();

        String[] words = s.split(" ");

        if(pattern.length() != words.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c1 = pattern.charAt(i);
            int c2 = words[i].hashCode();

            // If not previously mapped, map it
            if (mapPS[c1] == 0 && mapSP[c2] != 0) {
                mapPS[c1] = c2;
                mapSP[c2] = c1;
            }
            // If previously mapped, check consistency
            else {
                if (mapPS[c1] != c2 || mapSP[c2] != c1) return false;
            }

        }

        return true;
    }
}
