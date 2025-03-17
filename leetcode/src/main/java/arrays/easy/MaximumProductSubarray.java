class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int prefix = 1;
        int sufix = 1;
        int ans = Integer.MIN_VALUE;

        for(int i =0; i < n; i++){
            if(prefix == 0) prefix =1;
            if(sufix == 0) sufix =1;

            prefix = prefix * nums[i];
            sufix = sufix * nums[n-i-1];

            ans = Math.max(ans, Math.max(prefix,sufix));
        }

        return ans;
    }
}