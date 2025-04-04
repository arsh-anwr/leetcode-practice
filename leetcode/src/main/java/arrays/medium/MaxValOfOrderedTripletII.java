package arrays.medium;

public class MaxValOfOrderedTripletII {


    //OPTIMAL APPROACH--------------------------------------------------------------------------------------------------

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        long maxI = 0;
        long maxDiff = 0;
        long result = 0;

        for(int i =0; i < n; i++){
            result = Math.max(result , maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff , maxI - nums[i]);
            maxI = Math.max(maxI , nums[i]);
        }

        return result;
    }


}
