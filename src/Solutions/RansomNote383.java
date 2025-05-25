package Solutions;

import java.util.HashMap;
import java.util.Optional;

public class RansomNote383 {

    public static void main(String[] args) {
        System.out.println(canConstructWithoutHashMap("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> availableLetters = new HashMap<>();

        for (char letter : magazine.toCharArray())
        {
            availableLetters.put(letter, availableLetters.getOrDefault(letter, 0)+1);
        }

        for (char letter : ransomNote.toCharArray()){
            if(availableLetters.getOrDefault(letter, 0) > 0)
            {
                availableLetters.put(letter, availableLetters.get(letter)-1);
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean canConstructWithoutHashMap(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (char letter : magazine.toCharArray())
        {
            freq[letter - 'a']++;
        }

        for (char letter : ransomNote.toCharArray()){
            if (freq[letter - 'a'] == 0)
                return false;
            freq[letter-'a']--;
        }

        return true;
    }
}
