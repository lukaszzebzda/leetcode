package Solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestCommonPrefix14 {

    public static void main(String[] args) {
        String[] trs = new String[]{"flower","flow","flight"};
        String[] trs2 = new String[]{"dog","racecar","car"};

        System.out.println(longestCommonPrefixPerformance(trs));
    }

    public static String longestCommonPrefix(String[] strs) {
//        Po pierwsze bruteForce?
//        Czy znalezienie najczęściej występującej
//        Najprościej działać warstwowo? Najpierw sprawdzić najczęstszą pierwszą literę?
//        Później z nich szukać kolejnej
//        Wyznaczyć 1.Most common first letter
//        longest common prefix means the longest  of letters that occured more than once in
//        int[] wordsToConsiderNextIter = IntStream.range(0, strs.length).toArray();
        int maxLengthOfAWord = 200;
        Set<Integer> indexesOfWordsToConsider = IntStream.range(0, strs.length).boxed().collect(Collectors.toSet());
        StringBuilder currentLongestPrefix = new StringBuilder();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        Character mostCommon = null;
        int maxCount = 0;
        for (int i = 0; i < maxLengthOfAWord; i++) {
            for (int index: indexesOfWordsToConsider) {
                if(strs[index].length() > i) {
                    frequencyMap.put(strs[index].charAt(i), frequencyMap.getOrDefault(strs[index].charAt(i), 0) + 1);
                }
            }

            maxCount = 0;

            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() > maxCount) {
                    mostCommon = entry.getKey();
                    maxCount = entry.getValue();
                }
            }

            if(maxCount <= 1){
                break;
            }

            Set<Integer> newIndexesOfWordsToConsider = new HashSet<>();
            for (int index : indexesOfWordsToConsider) {
                if (strs[index].charAt(i) == mostCommon) {
                    newIndexesOfWordsToConsider.add(index);
                }
            }
            indexesOfWordsToConsider = newIndexesOfWordsToConsider;

            currentLongestPrefix.append(mostCommon);
            frequencyMap = new HashMap<>();
        }

        return currentLongestPrefix.toString();
    }

    public static String longestCommonPrefix2(String[] strs) {
//        Starting fromSratch because last time i missinterpreted the task
//        The only thing i need to find is largest prefix that exist for EVERY word, nod SOME words given.
        int maxWordLength = 200;
        StringBuilder commonPrefix = new StringBuilder();
        Character currentChar;
        for (int characterIndex = 0; characterIndex < maxWordLength; characterIndex++) {
            if(strs[0].length() <= characterIndex){
                break;
            }
            currentChar = strs[0].charAt(characterIndex);
            for (int wordIndex = 0; wordIndex <strs.length; wordIndex++) {
                if(strs[wordIndex].length() <= characterIndex || strs[wordIndex].charAt(characterIndex) != currentChar){
                    currentChar = null;
                    break;
                }
            }
            if(currentChar !=null){
                commonPrefix.append(currentChar);

            }
            else {
                break;
            }
        }
        return commonPrefix.toString();
    }

    public static String longestCommonPrefixPerformance(String[] strs) {
        if(strs.length==0){
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)){
                prefix=prefix.substring(0,prefix.length()-1);

                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}
