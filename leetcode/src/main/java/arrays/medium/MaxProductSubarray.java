package arrays.medium;

public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        /**
         2 3 -2 0 4 8

         2         -> 2
         2 3       -> 6
         2 3 -2.   -> -12
         2 3 -2 4. -> -48

         3         -> 3
         3 -2      -> -6
         3 -2 4    -> -24

         -2       -> -2
         -2 4.    -> -8

         4        -> 4

         */
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            prefix = prefix == 0 ? 1 : prefix;
            suffix = suffix == 0 ? 1 : suffix;

            prefix *= nums[i];
            suffix *= nums[n - i - 1];

            ans = Math.max(ans, Math.max(prefix, suffix));
        }

        return ans;
    }
}
