import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MajorityElementII {
    //BETTER APPROACH---------------------------------------------------------------------------------------------------
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums) map.put(num, map.getOrDefault(num,0)+1);

        List<Integer> result = new ArrayList<>();

        for(int i : map.keySet()){
            if(map.get(i) > n/3)
                result.add(i);
        }
        return result;
    }

    //OPTIMAL APPROACH--------------------------------------------------------------------------------------------------
    /**
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = 0;
        int count1 = 0;

        int count2 = 0;
        int maj2 = 0;

        for (int i =0; i < nums.length; i++){
            if(nums[i] == maj1){
                count1++;
            }else if(nums[i] == maj2){
                count2++;
            }else if(count1 == 0){
                maj1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                maj2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }

        }
        ArrayList<Integer> result = new ArrayList<>();
        count1 = 0; count2 = 0;

        for(int i=0; i <nums.length; i++){
            if(maj1 == nums[i]){ count1++;}
            else if(maj2 == nums[i]){ count2++;}
        }

        int reqFreq = (int)(nums.length/3 +1);
        if(count1 >= reqFreq) result.add(maj1);
        if(count2 >= reqFreq) result.add(maj2);

        return result;
    }
     */
}