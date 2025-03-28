package arrays.medium;

public class SortColors {
    //Optimal Approach----------------------------------------------------------------------------------------------
    class Solution {
        public void sortColors(int[] nums) {
            if(nums.length == 1)
                return;

            int i = 0;  //denotes 0
            int j = 0;  //denotes 1
            int k = nums.length-1;//denotes 2

            while(j <= k){
                if(nums[j] == 1){
                    j++;
                }else if(nums[j] == 2){
                    int temp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = temp;
                    k--;
                }else{//if(nums[j] = 0)
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    i++;
                    j++;
                }
            }

        }
    }



    //Better Approach----------------------------------------------------------------------------------------------
    class Solution {
        public void sortColors(int[] nums) {
            if(nums.length == 1)
                return;

            int countR = 0;
            int countW = 0;
            int countB = 0;

            for (int num : nums) {
                if (num == 0) {
                    countR++;
                } else if (num == 1) {
                    countW++;
                } else{
                    countB++;
                }
            }

            for (int i = 0; i < nums.length; i++){
                if(countR > 0){
                    nums[i] = 0;
                    countR--;
                }else if(countW > 0){
                    nums[i] = 1;
                    countW--;
                }else if(countB > 0){
                    nums[i] = 2;
                    countB--;
                }
            }
        }
    }


}
