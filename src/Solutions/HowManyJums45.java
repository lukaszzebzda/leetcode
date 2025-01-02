package Solutions;

public class HowManyJums45 {
    public static int howManyJumps(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int lastStepIndex = 0;
        int currentBestStep;
        int lastIndex = nums.length - 1;
        int numberOfSteps = 0;

        while (true) {
            numberOfSteps++;

            if (nums[lastStepIndex] + lastStepIndex >= lastIndex) {
                return numberOfSteps;
            }

            currentBestStep = nums[lastStepIndex] + lastStepIndex;

            for (int i = currentBestStep; i > lastStepIndex; i--) {
                if ((nums[i] + i - currentBestStep) > nums[currentBestStep]) {
                    currentBestStep = i;
                }
            }

            lastStepIndex = currentBestStep;
        }


        // 1. Sprawdź czy
        // 2. Zaczynamy analizę od najdalszego dostępnego od obecnego pola
        //  a) sprawdzamy czy z niego możemy sięgnąć końca, jeśli tak ===> Koniec
        //  b) przechodzimy w
    }
}
