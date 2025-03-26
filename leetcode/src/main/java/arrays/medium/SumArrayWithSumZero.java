package arrays.medium;

import java.util.HashMap;

public class SumArrayWithSumZero {
    public static int getLongestZeroSumSubarrayLength(int []arr){
        // Write your code here.

        /**
         [ 8 {4 -1 3 -7 2 -1 1 -1} 7]

         0 8 12 11 14 7 9 8 9 8 14

         map = {{prefixSumTillI, Index}}

         map = {0 = -1}
         i = 0 = 8 map = {0 = -1, 8 = 0}
         i = 1 = 12 map = {0 = -1, 8 = 0, 12 = 1}
         i = 2 = 11 map = {0 = -1, 8 = 0, 12 = 1, 11 = 2}
         .
         .
         .
         i = 6 = 8 map = {0 = -1, 8 = 0, 12 = 1, 11 = 2, 14 = 3, 7 = 4, 9 = 5}
         (ans = i - map.get(8))
         */

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        long prefixSum = 0L;
        int ans = 0;

        for (int j = 0; j < arr.length; j++) {
            prefixSum += arr[j];
            if (map.containsKey(prefixSum)) {
                ans = Math.max(ans, j - map.get(prefixSum));
            } else {
                map.put(prefixSum, j);
            }
        }

        return ans;
    }
}
