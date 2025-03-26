package arrays.medium;

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        /**

         For those who are still struggling.. calculate the sum as follows. if you find a 1 add 1 to the sum; if you find 0 substract 1 from the sum.
         nums = [1,1,0,0,1,1,0,1,1]
         sum = [1,2,1,0,1,2,1,2,3]
         Observe it carefully. If you find a sum which you have already found. you actually have a subarr with equal number of 0's and 1's. For example. in the sum array you have 2 as the sum in index 1. you found the sum 2 again in index 5. see the elements of nums from index 1+1 to 5 you have equal number of 0's and 1's. Write that down in a paper and pen and you can observe it easily. One more edge case is , what if you have a sum as 0. You can easily figure it out...

         [0,1,1,1,1,1,0,0,0]
         [-1 1 1 1 1 1 -1 -1 -1]
         0 -1 0 1 2 3 4 3 2 1

         sum = 0 -1  0  1. 2. 3. 4. 3  2  1
         */

        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);

        int prefixSum = 0;
        int ans = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                prefixSum -= 1;
            } else {
                prefixSum += 1;
            }

            if (map.containsKey(prefixSum)) {
                ans = Math.max(ans, j - map.get(prefixSum));
            } else {
                map.put(prefixSum, j);
            }
        }

        return ans;
    }
}
