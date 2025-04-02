package slidingWindow.medium;

public class MaxConsecutiveOnesIII {

    //OPTIMAL APPROACH--------------------------------------------------------------------------------------------------

    public int longestOnes(int[] nums, int k) {
        /**      0 1 2 3 4 5 6 7 8 9 10
         [1 1 1 0 0 0 1 1 1 1 0]
         i->  i i i i i i            |strt-> i=3zero--(3->2)
         j->  j j j j j j j j j j j |end
         zC-> 0     1 2 3->2 2 2 2 2 3->2|zeroCount
         mC-> 1 2 3 4 5 3 4 5 6 7 |end-start+1




         */
        int n = nums.length;
        int zeroCount = 0;
        int maxOnce = 0;
        int start = 0;

        for(int end = 0; end < n; end++){
            if(nums[end] == 0){
                zeroCount++;
            }

            while(zeroCount > k){
                if(nums[start] == 0)
                    zeroCount--;

                start++;
            }


            maxOnce = Math.max(maxOnce, end - start +1 );

        }
        return maxOnce;
    }



}
