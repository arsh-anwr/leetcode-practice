package arrays.medium;

public class RearrangeArrayElementsBySign {


    //OPTIMAL APPROACH---------------------------------------------------------------------------------------------
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int pi =0;
        int ni =1;

        for(int num : nums){
            if(num > 0){
                ans[pi] = num;
                pi += 2;
            }else{
                ans[ni] = num;
                ni += 2;
            }
        }

        return ans;


    }










    //BETTER APPROACH----------------------------------------------------------------------------------------------
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> ls_E = new ArrayList<>();
        List<Integer> ls_O = new ArrayList<>();

        for(int i =0; i < n; i++){
            if(nums[i] > 0){
                ls_E.add(nums[i]);
            }else if(nums[i] < 0){
                ls_O.add(nums[i]);
            }
        }

        for(int i =0; i < n/2; i++){

            nums[2 * i] = ls_E.get(i);

            nums[2 * i + 1] = ls_O.get(i);
        }
        return nums;


    }





}
