class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }

        return result;



        // int n = nums.length;
        // int[] left = new int[n];
        // int[] right = new int[n];
        // left[0] = 1;
        // right[n - 1] = 1;

        // for (int i = 1; i < nums.length; i++) {
        //     left[i] = left[i - 1] * nums[i - 1];
        // }

        // for (int i = n - 2; i >= 0; i--) {
        //     right[i] = right[i + 1] * nums[i + 1];
        // }

        // int[] result = new int[n];
        // for (int i = 0; i < n; i++) {
        //     result[i] = left[i] * right[i];
        // }

        // return result;







        //    int product = 0;
        //     int productWithoutZero = 1;
        //     for (int i : nums) {
        //         if (i == 0)
        //             product++;
        //         else
        //             productWithoutZero *= i;
        //     }

        //     int[] result = new int[nums.length];
        //     for (int i = 0; i < nums.length; i++) {
        //         if (nums[i] != 0) {
        //             if (product > 0)
        //                 result[i] = 0;
        //             else
        //                 result[i] = productWithoutZero / nums[i];
        //         } else {
        //             if (product > 1)
        //                 result[i] = 0;
        //             else
        //                 result[i] = productWithoutZero;
        //         }
        //     }
        //     return result;

    }
}