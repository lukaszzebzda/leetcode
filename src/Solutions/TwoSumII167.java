package Solutions;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumII167 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{2,7,11,15}, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int wanted = target - numbers[i];
            if (map.containsKey(wanted)){
                return new int[]{(map.get(wanted) + 1), i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1,-1};
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int lower = 0,upper = numbers.length - 1;


        while (lower < upper) {
            int lower_value = numbers[lower];
            int upper_value = numbers[upper];
            int sum = lower_value + upper_value;
            if (sum == target){
                return new int[]{lower + 1, upper + 1};
            }
            else if (sum < target){
                lower++;
            }
            else {
                upper--;
            }
        }
        return new int[]{-1,-1};
    }

}
