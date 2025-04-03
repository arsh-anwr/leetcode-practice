package arrays.medium;

import java.util.HashMap;

public class BinarySubArrayWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        /**
         1 0 0 0 1 0 1 0 1 0 0 0
         3
         1 1 1 1 2 2 3 3 4 4 4 4
         1 0 0 0 1 0 1

         map {1 = 2, 2 = 2}, count = 2
         prefix[j] - goal = prefix[i];
         currSum - goal = prefix[i];


         if (freq(sum - goal))

         freq = {prefixSum: occ}


         */
        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == goal) ans++;

            if (map.containsKey(sum - goal)) {
                ans += map.get(sum - goal);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
        // return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        int  n = nums.length;
        int sum = 0;
        int goalCount = 0;

        int i = 0;
        int j = 0;

        while(j < n){
            sum += nums[j];

            while(i <= j && sum > goal){
                sum = sum - nums[i];
                i++;
            }

            goalCount += j - i + 1;
            j++;
        }

        return goalCount;
    }
}
