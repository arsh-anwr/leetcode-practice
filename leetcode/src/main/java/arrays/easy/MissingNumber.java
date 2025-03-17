class Solution {
    public int missingNumber(int[] nums) {//nums = [ 3 0 1]

        int num1 =0;
        int num2 =0;
        //nums.length=2
        for(int i=1; i < nums.length+1; i++){//i=1 | i=2 | i=3
            num1 = num1 ^ i;//num1=0 ^ 1-> 1 | num1=1 ^ 2-> 3 | num1=3 ^ 3-> 0
        }
        for(int i=0; i < nums.length;i++){//i=0 | i=1 | i = 2
            num2 = num2 ^ nums[i];//num2=0 ^ nums[0]=3 ->3 |  num2=3 ^ nums[1]=0 ->3 | num2=3 ^ nums[2]=1-> 2
        }
        return num2 = num1 ^ num2;//num2= 2 ^ num1=0 -> 2
    }
}


//XOR  ->  0 - 0-> 0
//         1 - 0-> 1
//         0 - 1-> 1
//         1 - 1-> 0