class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;

        while(i < nums.length){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
            i++;
        }

        int n = nums.length;
        //int left = 0;
        //int right = left+1;

        // for(int i=0; i < n; i++){
        //     for(int j =i+1; j < n; j++){
        //         if(nums[i] == 0 && nums[i] != nums[j]){
        //             int temp = nums[i];
        //             nums[i] = nums[j];
        //             nums[j] = temp;
        //         }
        //     }
        // }

    }
}