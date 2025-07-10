package Solutions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {

    public static void main(String[] args) {
        String[] list = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(list));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<Integer>> truthMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            String sortedString = new String(sorted);
//            if(truthMap.containsKey(sortedString)){
//                List<Integer> liczby = new ArrayList<>();
//                liczby.addAll(truthMap.get(sortedString));
//                liczby.add(i);
//                truthMap.put(sortedString, liczby);
//            }else {
//                truthMap.put(sortedString, List.of(i));
//            }
            truthMap.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(i);
        }

        ArrayList<List<String>> response = new ArrayList<>(truthMap.size());

        for (List<Integer> list : truthMap.values()) {
            ArrayList<String> smallList = new ArrayList<>();
            for (Integer i : list) {
                smallList.add(strs[i]);
            }
            response.add(smallList);
        }
        return response;
    }


    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            String sortedString = new String(sorted);

            map.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(i);
        }

        ArrayList<List<String>> response = new ArrayList<>(map.size());

        for (List<Integer> values : map.values()) {
            ArrayList<String> smallList = new ArrayList<>(values.size());
            for (Integer i : values) {
                smallList.add(strs[i]);
            }
            response.add(smallList);
        }
        return response;
    }

    public static List<List<String>> groupAnagrams3(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String sortedString = new String(sorted);

            map.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
