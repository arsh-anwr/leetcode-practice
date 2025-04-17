package arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;

        List<Integer> ans = new ArrayList();

        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]){
                ans.add(nums1[i]);
                i++;
            }else {
                ans.add(nums2[j]);
                j++;
            }
        }
        while(i < m) {
            ans.add(nums1[i]);
            i++;
        }

        while(j < n) {
            ans.add(nums2[j]);
            j++;
        }

        for(int k = 0; k < nums1.length; k++)
            nums1[k] = ans.get(k);
    }
}
