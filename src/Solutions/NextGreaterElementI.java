package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement2(nums1, nums2)));
    }

    // BruteForce1
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int greater;
        int[] solutions = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            greater = -1;
            for (int j = 0; j < nums2.length; j++) {
                if(nums2[j] == nums1[i]){
                    petla: for (int k = j+1; k < nums2.length; k++) {
                        if(nums2[k] > nums1[i]){
                            greater = nums2[k];
                            break petla;
                        }
                    }
                }
            }
            solutions[i] = greater;
        }
        return solutions;
    }

    // Monotonic
    public static int[] monotonicDecreasingStack(int[] nums) {
        int n = nums.length;
        int[] result = new int[n]; // Output array
        Arrays.fill(result, -1); // Default to -1 if no greater element exists
        Stack<Integer> stack = new Stack<>(); // Stack stores indices

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // While stack is not empty and current element is greater than stack top
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop(); // Pop the top element
                result[index] = nums[i]; // The current element is the Next Greater Element
            }
            stack.push(i); // Push the current index onto the stack
        }
        return result;
        //https://github.com/ashishps1/awesome-leetcode-resources/blob/main/patterns/java/MonotonicStack.java
    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] res = new int[nums2.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                int index = stack.pop();
                res[index] = nums2[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int index = 0;

            while (nums2[index] != nums1[i]){
                index++;
            }

            nums1[i] = res[index];
        }

        return  nums1;
    }
}
