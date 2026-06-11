package Solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray215 {

    public static void main(String[] args) {
        System.out.println("XD");
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargestWith(nums, 1));

    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public static int findKthLargestWith(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {

            priorityQueue.add(nums[i]);

            if(priorityQueue.size() > k){
                priorityQueue.poll();

            }

        }
        return priorityQueue.peek();
    }
}
