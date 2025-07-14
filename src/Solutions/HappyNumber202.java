package Solutions;

import java.util.HashMap;
import java.util.HashSet;

public class HappyNumber202 {

    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy2(n));
    }

    public static boolean isHappy(int n) {
        String number = Integer.toString(n);
        int sum  = 0;
        HashSet<Integer> set = new HashSet<>();

        while (true){
            sum = 0;
            for (int i=0; i<number.length(); i++){
                int digit = Integer.parseInt(number.substring(i, i + 1));
                sum += (digit * digit);
            }

            if (sum == 1)
            {
                return true;
            }
            else{
                if(set.contains(sum)){
                    return false;
                }
                else{
                    set.add(sum);
                }
                number=Integer.toString(sum);
            }
        }
    }

    public static int sum(int n){
        int sum = 0;
        while (n!=0){
            int digit = n%10;
            sum += digit * digit;
            n = n/10;
        }
        return sum;
    }

    public static boolean isHappy2(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (true){
            int sum = sum(n);
            if(sum==1)return true;
            if(set.contains(sum)) break;
            set.add(sum);
            n = sum;
        }

        return false;
    }

    public static boolean isHappy3(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = sum(slow);
            fast = sum(sum(fast));
        }while (slow != fast);

        if(slow == 1){
            return true;
        }
        return false;
    }
}
