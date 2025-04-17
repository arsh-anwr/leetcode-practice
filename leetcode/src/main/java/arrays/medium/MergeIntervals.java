package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    //OPTIMAL SOLUTION--------------------------------------------------------------------------------------------------

    public int[][] merge(int[][] intervals) {
        Arrays.sort(
                intervals,
                (a, b) -> a[0] - b[0]
        );

        ArrayList<int[]> result = new ArrayList<>();

        int l0 = intervals[0][0];
        int l1 = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int r0 = intervals[i][0];
            int r1 = intervals[i][1];

            if(r0 > l1){
                result.add(new int[]{l0, l1});
                l0 = r0;
                l1 = r1;
            }else{
                l1 = Math.max(r1,l1);
            }
        }
        result.add(new int[]{l0,l1});

        int[][] ans = new int[result.size()][2];
        int k =0;

        for(int[] r : result) ans[k++] = r;

        return ans;
    }
}
