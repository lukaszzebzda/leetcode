package Solutions;

public class RangeSumQuery303 {
    private final int[] sum;


    public static void main(String[] args) {
        RangeSumQuery303 obiekt = new RangeSumQuery303(new int[]{-2,0,3,-5,2,-1});

    }


    public RangeSumQuery303(int[] nums) {
        this.sum = new int[nums.length];
        this.sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.sum[i] = nums[i] + sum[i-1];
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0) return sum[right];
        return sum[right] - sum[left-1];
    }
}
