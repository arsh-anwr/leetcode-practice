package arrays.medium;

public class SumOfAllSubarray {
    public long subarraySum(int[] a) {
        // code here

        /**
         * [3,1,2,4]
         *  3 -> (n - i) -> 4
         *  1 -> (n - i) -> 3
         *  2 -> (n - i) -> 2
         *  4 -> (n - i) -> 1
         *  (i + 1) * (n - i);
         3 -> 3
         3 1 -> 4
         3 1 2 -> 6
         3 1 2 4 -> 10

         1 -> 1
         1 2 -> 3
         1 2 4 -> 7

         2 -> 2
         2 4 -> 6

         4 -> 4
         -------
         46
         */
        long result = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            result += a[i] * (i + 1) * (n - i);
        }

        return result;
    }
}
