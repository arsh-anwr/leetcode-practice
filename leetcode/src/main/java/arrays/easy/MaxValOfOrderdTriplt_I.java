package arrays.easy;

public class MaxValOfOrderdTriplt_I {

    //OPTIMAL APPROACH--------------------------------------------------------------------------------------------------
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        long maxI = 0;
        long maxDiff = 0;
        long result = 0;

        for(int m =0; m < n; m++){
            result = Math.max(result , maxDiff * nums[m]);
            maxDiff = Math.max(maxDiff , (maxI - nums[m]));
            maxI = Math.max(maxI , nums[m]);
        }


        return result;
    }




    //BETTER APPROACH---------------------------------------------------------------------------------------------------
    /**
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i + 1]);
        }

        long result = 0;
        for (int j = 1; j < n - 1; j++) {
            result = Math.max(result, (long)(leftMax[j] - nums[j]) * rightMax[j]);
        }

        return result;
    }
    */





    //BRUTE FORCE APPROACH----------------------------------------------------------------------------------------------

    /**


    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxVal = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long currentVal = ((long) nums[i] - nums[j]) * nums[k];
                    maxVal = Math.max(maxVal, currentVal);
                }
            }
        }

        return maxVal;
    }
     */
}
