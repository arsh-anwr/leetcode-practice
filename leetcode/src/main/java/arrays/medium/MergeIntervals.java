package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        /**
         -----------------
         1               10
         ---------
         15      18
         <------------------------------------------------>
         0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18

         arr =     [[1,3],[2,6], [8,10],[15,18]]

         l = [1, 3] = arr[0]
         r = [2 ,6] = arr[1]
         l1 = l[0]
         l2 = l[1]
         r1 = r[0]
         r2 = r[1]

         r1 > l2
         */

        Arrays.sort(
                intervals,
                (a, b) -> a[0] - b[0]
        );

        ArrayList<int[]> result = new ArrayList();

        int l0 = intervals[0][0];
        int l1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int r0 = intervals[i][0];
            int r1 = intervals[i][1];

            if (r0 > l1) {
                result.add(new int[]{l0, l1});
                l0 = r0;
                l1 = r1;
            } else {
                l1 = Math.max(r1, l1);
            }
        }
        result.add(new int[]{l0, l1});

        int[][] ans = new int[result.size()][2];
        int k = 0;

        for (int[] r: result) ans[k++] = r;

        return ans;
    }
}
