package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        /**
         [4,3,2,7,8,2,3,1]
         n = 8
         [1, 8]
         ->  1 2 3 4 5 6 7 8
         [4 3 2 7 8 2 3 1]

         i = 0 -> 4 -> swap(nums[3], nums[i])
         [7 3 2 4 8 2 3 1]
         ans.add(2 3);
         i = 0 -> 7 -> swap(nums[6], nums[i])
         [3 3 2 4 8 2 7 1]
         i = 0 -> 3 -> swap(nums[2], nums[i])
         [2 3 3 4 8 2 7 1]
         i = 0 -> 2 -> swap()
         [3 2 3 4 8 2 7 1]
         i = 4 8
         [3 2 3 4 1 2 7 8]
         i = 4 1
         [1 2 3 4 3 2 7 8]
         i = 7


         [1 2 3 4 3 2 7 8]
         0 1 2 3 5 4 6 7

         arr.add(3, 2)
         */


        int n = nums.length;
        int i = 0;
        List<Integer> ans = new ArrayList<>();

        while (i < n) {
            int j = nums[i];
            if ((j - 1 < n) && (i != j - 1) && (nums[i] != nums[j - 1])) {
                int temp = nums[i];
                nums[i] = nums[j - 1];
                nums[j - 1] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (i != nums[i] - 1) ans.add(nums[i]);
        }

        return ans;
    }
}
