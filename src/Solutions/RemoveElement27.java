package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement27 {
    public static void main(String[] args) {
        System.out.println("Siema");

        int[] nums = new int[]{0,1,2,2,3,0,4,2}; // Input array
        int val = 2; // Value to remove

        System.out.println(removeElementSwapTactics(nums,val));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int lastElement = nums.length;
        int reachLength = 0;
        for (int i = 0; i < lastElement-reachLength; i++) {

            if(i+reachLength+1 == nums.length-1){
                if(nums[nums.length-1]==val)
                reachLength--;
                break;
            }
            else if(nums[i+reachLength]==val){
                nums[i+reachLength]=nums[i+reachLength+1];
                reachLength++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return lastElement-reachLength;
    }

    public static int removeElement2(int[] nums, int val) {
        ArrayList toRemove = new ArrayList<Integer>();
        for (int i = 0; i <nums.length; i++) {
            if(nums[i]==val){
                toRemove.add(i);
            }
        }
        int finalSize = nums.length-toRemove.size();
        int skipingSize = 0;
        for (int i = 0; i < finalSize; i++) {
            if(toRemove.getFirst().equals(i)){
                skipingSize++;
            }
        }

        return finalSize;
    }

//    public static int removeElement3(int[] nums, int val) {
//        List<Integer> toNotRemove = new ArrayList<>();
//        for (int i = 0; i <nums.length; i++) {
//            if(nums[i]!=val){
//                toNotRemove.add(i);
//            }
//        }
//
//    }

    public static int removeElementSwapTactics(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;
        int leftCopy = 0;

        while (left <= right){
            if(nums[left] == val){
                leftCopy = nums[left];
                nums[left] = nums[right];
                nums[right] = leftCopy;
                right--;
            }
            else{
                left++;
            }
        }
        return left;
    }
}
