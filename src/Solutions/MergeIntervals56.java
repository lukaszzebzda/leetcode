package Solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals56 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{ {2,6}, {1,2},{8,15}};
        int[][] mergedIntervals = merge3(intervals);
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }


    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res = new ArrayList<>();

        // Checking for all possible overlaps
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Skipping already merged intervals
            if (!res.isEmpty() && res.get(res.size() - 1)[1] >= end) {
                continue;
            }

            // Find the end of the merged range
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                }
            }
            res.add(new int[]{start, end});
        }
        int[][] newRes = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            newRes[i] = res.get(i);
        }
        return newRes;
    }

    public static int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] res = new int[intervals.length][2];
        int index = 0;

        res[index] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = res[index];

            if (last[1] >= current[0]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                index++;
                res[index] = current;
            }
        }

        return Arrays.copyOf(res, index + 1);
    }

    public static int[][] merge3(int[][] intervals) {
        // Sort intervals based on start values
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> res = new ArrayList<>();
        res.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] curr = intervals[i];

            // If current interval overlaps with the last merged interval,
            // merge them
            if (curr[0] <= last[1])
                last[1] = Math.max(last[1], curr[1]);
            else
                res.add(new int[]{curr[0], curr[1]});
        }


        int[][] newRes = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            newRes[i] = res.get(i);
        }
        return newRes;
    }


}
