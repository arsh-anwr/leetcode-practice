package arrays.easy;

import java.util.ArrayList;

public class MergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         i
         [1 2 3]
         j
         [2 5 6]

         [1 2 2 3 5 6]
         */

        int i = 0;
        int j = 0;
        ArrayList<Integer> arr = new ArrayList();

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                arr.add(nums1[i]);
                i++;
            } else {
                arr.add(nums2[j]);
                j++;
            }
        }

        while (i < m) {
            arr.add(nums1[i]);
            i++;
        }

        while (j < n) {
            arr.add(nums2[j]);
            j++;
        }

        for (int k = 0; k < nums1.length; k++) nums1[k] = arr.get(k);
    }
}
