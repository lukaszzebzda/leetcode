package Solutions;

import java.util.Arrays;

public class BinarySearch704 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        System.out.println(search(nums, 9));

    }

    public static int wrongBinarySearch(int[] nums, int target) {
        int index;
        while (true){
            index = nums.length/2;
            if (index == 0) {
                return -1;
            } else if (nums[index] == target){
                return index;
            }
            else if(nums[index] < target){
                nums = Arrays.copyOfRange(nums, index+1, nums.length);
            }
            else {
                nums = Arrays.copyOfRange(nums, 0, index-1);
            }
        }
    }

    public static int search(int[] nums, int target) {
        int low = 0, high=nums.length-1;

        while (low <= high){
            int mid = low + (high-low)/ 2;
            if (nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                high = mid-1;
            }
            else {
                low = mid + 1;
            }

        }
        return -1;
    }
}
