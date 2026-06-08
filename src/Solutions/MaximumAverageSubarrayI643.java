package Solutions;

public class MaximumAverageSubarrayI643 {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{0,1,1,3,3}, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double lastWindowSum = 0;
        for (int i = 0; i < k; i++) {
            lastWindowSum += nums[i];
        }

        double maxValue = lastWindowSum;

        for (int j = 0; j < nums.length - k; j++) {
            double windowSum = lastWindowSum - nums[j] + nums[j+k];
            if (windowSum > maxValue){
                maxValue = windowSum;
            }
            lastWindowSum = windowSum;
        }

        return maxValue/k;
    }
}
