package Solutions;

public class JumpGame55 {
    public boolean canJump(int[] nums) {
        int i = 0;

        while (true) {
            if (i == nums.length - 1) {
                return true;
            }

            if (nums[i] == 0) {
                int zeroOffset = 0;

                int j = i+1;
                while(j < nums.length-1){
                    if(nums[j]==0){
                        zeroOffset++;
                        j++;
                    }
                    else {
                        break;
                    }
                }


                int pointer = i - 1;
                while (pointer >= 0) {
                    if (nums[pointer] > (i + zeroOffset - pointer)) {
                        break;
                    }
                    pointer--;
                }

                if(pointer < 0){
                    return false;
                }
            }

            i++;
        }
    }
}
