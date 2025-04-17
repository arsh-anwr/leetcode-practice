package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    //MERGE SORT DEVIDE AND CONQUER-------------------------------------------------------------------------------------

    public int[] sortArray(int[] nums) {

        mergeSort(nums , 0 , nums.length-1);

        return nums;
    }
    public void mergeSort(int[] nums, int low, int high){
        if(low == high)
            return;

        int mid = (low + high) / 2;

        mergeSort(nums, low , mid);
        mergeSort(nums, mid+1 , high);
        merge(nums, low , mid , high);
    }

    public void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high) {
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }

        while(left <= mid){
            temp.add(nums[left]);
            left++;
        }
        while(right <= high){
            temp.add(nums[right]);
            right++;
        }

        for(int k = low; k <= high; k++)
            nums[k] = temp.get(k - low );
    }
}
