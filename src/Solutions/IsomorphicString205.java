package Solutions;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> pairs = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (pairs.containsKey(s.charAt(i))) {
                if (pairs.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else if (pairs.containsValue(t.charAt(i))) {
                if (!pairs.containsKey(s.charAt(i))) {
                    return false;
                }
            } else {
                pairs.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    private static Character findKeyOfValue (Character key, HashMap<Character, Character> mapa){
        for (Map.Entry<Character, Character> entry : mapa.entrySet()) {
            if (entry.getValue().equals(key)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static boolean isIsomorphic2(String s, String t) {
        int[] mapST = new int[256]; // mapping from s to t
        int[] mapTS = new int[256]; // mapping from s to t

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If not previously mapped, map it
            if (mapST[c1] == 0 && mapTS[c2] == 0) {
                mapST[c1] = c2;
                mapTS[c2] = c1;
            }
            // If previously mapped, check consistency
            else {
                if (mapST[c1] != c2 || mapTS[c2] != c1) return false;
            }

        }

        return true;
    }
}
