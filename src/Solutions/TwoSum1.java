package Solutions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum1 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // 1. Sort
        // 2. Exclude too big numbers
        // 3. pick the biggest and try to match lower numbers
        //    a) if lucky return answer
        //    b) if not, continue with next big number
        // 4. if left >= right next number
        // 5. if right i == 0 return false
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int numsLength = Arrays.binarySearch(sortedNums, target + 1);
        if (numsLength < 0) {
            numsLength = -numsLength - 1;
        }

        int r = 0;

        int[] answerValue = new int[0];

        for (int i = numsLength - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                r = sortedNums[i] + sortedNums[j];
                if (r == target) {
                    answerValue = new int[]{sortedNums[j], sortedNums[i]};
                    break;
                }
                if (r > target) {
                    break;
                }
            }
            if (answerValue.length > 0) break;
        }

        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == answerValue[0]) {
                left = i;
            } else if (nums[i] == answerValue[1]) {
                right = i;
            }
        }

        return new int[]{left, right};
    }

    public static int[] twoSum2(int[] nums, int target) {
        // Brute Force

        for (int j = 0; j < nums.length; j++) {
            for (int i = nums.length - 1; i > 0; i--) {
                if (i <= j) break;
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }

        return new int[]{0, 0};
    }

    public static int[] twoSum3(int[] nums, int target) {
        // Hashmap

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int wanted = target - nums[i];
            if (map.containsKey(wanted)) {
                return new int[]{i, map.get(wanted)};
            }
            map.put(nums[i], i);
        }

        return new int[]{0, 0};
    }
}
