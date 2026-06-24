package Solutions;

import java.util.HashMap;
import java.util.Map;

public class firstUniqChar387 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }


    public static int firstUniqChar(String s) {
        Map<Character, Integer> spottedCharacters = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            if(spottedCharacters.containsKey(s.charAt(i))){
                spottedCharacters.put(s.charAt(i), spottedCharacters.get(s.charAt(i)) + 1);
            }else{
                spottedCharacters.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++){
            if(spottedCharacters.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }

    public static int firstUniqChar2(String s) {
        int[] freqTable = new int[26];

        for(int i=0; i<s.length(); i++){
            freqTable[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if (freqTable[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}
