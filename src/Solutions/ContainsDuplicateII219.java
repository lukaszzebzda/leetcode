package Solutions;

public class ContainsDuplicateII219 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // 1. We have an array of integers, at first we need to locate every possible distinctive indices that have same values
        // 2. In second step we need to check if any sum of those pairs of indices are below k value.
        //    We can also shorten the route by checking if pair match given description at the moment of finding it.
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i + 1; j <nums.length; j++) {
                if (nums[i]==nums[j]){
                    if(Math.abs(i-j) <= k) return true;
                }
            }
        }

        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        // We run into an issue. The time limit for the solution was exceeded.
        // Now we can eliminate the issue be reducing the complexity by sorting array first, thanks to this, we can skip one iteration
        

        return false;
    }
}
