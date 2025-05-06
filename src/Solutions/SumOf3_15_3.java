package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SumOf3_15_3 {

//      Sort the array → This allows skipping duplicates easily.
//      Iterate through the array using a loop:
//      Treat nums[i] as a fixed element.
//      Use a left pointer at i + 1 and a right pointer at the end.
//      If nums[i] + nums[left] + nums[right] == 0, store the triplet and move both pointers.
//      If the sum is too low, move left right.
//      If the sum is too high, move right left.
//      Skip duplicate elements to avoid duplicate triplets.

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        List<List<Integer>> triplets = new ArrayList<>();

        int left;
        int right;

        for (int i = 0; i < nums.length -2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            left = i + 1;
            right = nums.length - 1;

            while (left < right){
                int sum = nums [i] + nums[left] + nums[right];

                if (sum == 0){
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    if(nums[left] == nums[left + 1]) left++;
                    if(nums[right] == nums[right + 1]) right++;

//                    left++;
//                    right--;
                } else if (sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }
}
