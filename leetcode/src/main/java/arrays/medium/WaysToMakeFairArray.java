package arrays.medium;

public class WaysToMakeFairArray {
    public int waysToMakeFair(int[] nums) {
        /**
         even[0, 2, 2, 8, 8] odd[0, 0, 1, 1, 5]
         1
         2 6 4
         even = 2 4
         odd = 6

         even = even[i] + (odd[n] - odd[i + 1])
         odd = odd[i] + (even[n] - even[i + 1])

         */
        int[] even = new int[nums.length + 1];
        int[] odd = new int[nums.length + 1];
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < nums.length; i++) { // even[0, 2, 2, 8, 8] odd[0, 0, 1, 1, 5] // O(N)
            if (i % 2 == 0) {
                even[i + 1] = even[i] + nums[i];
                odd[i + 1] = odd[i];
            } else {
                even[i + 1] = even[i];
                odd[i + 1] = odd[i] + nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) { // O(N)
            int e = even[i] + (odd[n] - odd[i + 1]);
            int o = odd[i] + (even[n] - even[i + 1]);

            if (e == o) result++;
        }

        return result;
    }
}
