class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0; i < nums.length; i++){
            int num = nums[i];
            int moreNeeded = target -num;
            if(map.containsKey(moreNeeded)){
                ans[0] = map.get(moreNeeded);
                ans[1] = i;
            }
            map.put(nums[i], i);
        }
        return ans;







        // int[] ans = new int[2];

        // for(int i=0; i < nums.length; i++){
        //     for(int j =i+1; j < nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //             ans[0]=i;
        //             ans[1]=j;
        //         }
        //     }
        // }
        // return ans;

    }
}