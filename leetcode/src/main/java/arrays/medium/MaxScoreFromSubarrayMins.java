package arrays.medium;

public class MaxScoreFromSubarrayMins {
    //The Only Approach----------------------------------------------------------------------------------------------
    public int pairWithMaxSum(int arr[]) {
        // Your code goes here
        int n = arr.length;
        int ans =Integer.MIN_VALUE;

        for(int i = 1; i < n; i++){
            ans = Math.max(ans, arr[i] + arr[i - 1]);
        }
        return ans;

    }
}
