package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateFromSortedArray26 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicatesBetterSolution(nums));

    }

    public static int removeDuplicates(int[] nums) {
        List<Integer> listOfUniqueNumbers = new ArrayList<Integer>();
        listOfUniqueNumbers.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!= listOfUniqueNumbers.getLast()){
                listOfUniqueNumbers.add(nums[i]);
            }
        }

        for (int i = 0; i < listOfUniqueNumbers.size(); i++) {
            nums[i]=listOfUniqueNumbers.get(i);
        }

        System.out.println(Arrays.toString(nums));

        return listOfUniqueNumbers.size();
    }

    public static int removeDuplicatesBetterSolution (int[] nums){
        int j=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[j]!=nums[i]){
                j++;
                nums[j]=nums[i];
            }
        }

        System.out.println(Arrays.toString(nums));

        return j+1;
    }
}
