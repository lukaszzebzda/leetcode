package Solutions;

import java.security.KeyPair;
import java.util.*;
import java.util.stream.Stream;

public class SumOf3_15_2 {

    public List<List<Integer>> sumOfTriplets(int[] nums) {

        List<List<Integer>> foundTriplets = new ArrayList<>();
        Map<Pair, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int l = j + 1; l < nums.length; l++) {

                    if ((nums[i] + nums[j] + nums[l]) == 0) {
                        List<Integer> sorted = Stream.of(nums[i], nums[j], nums[l]).sorted().toList();
                        if (givenTripletsNotFoundYet(hashMap, sorted))
                            hashMap.put(new Pair(sorted.getFirst(), sorted.get(1)), sorted.get(2));
                    }
                }
            }
        }


        return foundTriplets;
    }

    private boolean givenTripletsNotFoundYet(Map<Pair, Integer> hashMap, List<Integer> sorted) {
        Integer value = hashMap.get(new Pair(sorted.getFirst(), sorted.get(1)));
        return !sorted.getLast().equals(value);
    }
}
