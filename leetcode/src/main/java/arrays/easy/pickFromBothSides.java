public class Solution {
    public int solve(int[] A, int B) {

        int n = A.length;        //A -> [ 2 4 -2 1 3 5 7 9 ]
        //B -> 4
        int currentSum =0;

        for(int i=0; i<B; i++)      //i=0  |i=1 |i=2 |i=3
            currentSum += A[i];         //cS=2 |cS=6|cS=4|cS=5 -> cS=5

        int maxSum = currentSum;    //cS= 5 = mS
        //cS=  cS - A[B-i] = A[n-i]
        for(int i=1; i <= B; i++){                     //   i=1    |   i=2       |    i=3     |    i=4
            currentSum = currentSum - A[B-i] + A[n-i];//cS=5-1+9=13|cS=13--2+7=22|cs=22-4+5=23|cS=23-2+3=24
            maxSum = Math.max(maxSum,currentSum);   //mS=13 & 5=13 |mS=22 & 13=22|mS=23 &22=23|mS 23 & 24=24
        }                                          //max->(mS & cS)
        return maxSum;                             //
    }
}
