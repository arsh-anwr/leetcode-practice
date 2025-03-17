class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxNo = 0;
        //length=6
        for(int i = 0; i < nums.length; i++){//
            if(nums[i] == 1){//
                count++;//
            }
            else{
                count = 0;//
            }
            if(count> maxNo){//

                maxNo = count;
            }

        }
        return maxNo;
    }
}