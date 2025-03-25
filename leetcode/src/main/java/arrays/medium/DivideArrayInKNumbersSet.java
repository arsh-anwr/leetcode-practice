package arrays.medium;

import java.util.Arrays;
import java.util.HashMap;

public class DivideArrayInKNumbersSet {
    public boolean isPossibleDivide(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Arrays.sort(nums);

        for (int num: nums) {
            if (map.containsKey(num)) {

                for (int i = num; i < num + k; i++) {
                    if (!map.containsKey(i)) {
                        return false;
                    }

                    map.put(i,  map.get(i) - 1);

                    if (map.get(i) == 0) map.remove(i);
                }
            }
        }

        return true;
    }
}
