package Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class SumOf3_15 {
    public List<List<Integer>> sumOfTriplets(int[] nums) {

        List<List<Integer>> foundTriplets = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int l = j+1; l < nums.length; l++) {
                    if ((nums[i] + nums[j] + nums[l]) == 0 && givenTripletsNotFoundYet(foundTriplets, nums[i], nums[j], nums[l])) foundTriplets.add(Stream.of(nums[i], nums[j], nums[l]).sorted().toList());
                }
            }
        }



        return foundTriplets;
    }

    private boolean givenTripletsNotFoundYet(List<List<Integer>> foundTriplets, int first, int second, int third) {
        List<Integer> sortedSearchedList = Stream.of(first,second, third).sorted().toList();
        Optional<List<Integer>> found = foundTriplets.stream().filter(sortedSearchedList::equals).findFirst();
        return found.isEmpty();
    }
}
